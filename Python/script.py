#!/usr/bin/env python2
# coding=utf8
import os,subprocess,sys,pexpect

## We're logged into the agent as user 'root'
current_user = os.getenv('USER')
## Get the user's home path (~ or /root)
home_path = os.getenv('HOME')
## Absolute file path to the public key
pub_key_path =  home_path + '/.ssh/id_rsa.pub'
## The remote host to which we want to copy the public key
hostname = ''
## The remote user to which we want passwordless access
remote_user = ''
## Command to read the public key
file_cmd = 'file ' + pub_key_path
## This copies the public key to the authorized_hosts on the remote machine
scp_cmd = 'ssh-copy-id -i ' + pub_key_path + ' ' + remote_user + '@' + hostname
## The password we want to provide when prompted
passwd = ''

## Print to stdout the values
print 'current_user = ' + current_user
print 'home_path = ' + home_path
print 'pub_key_path = ' + pub_key_path
print 'hostname = ' + hostname
print 'remote_user = ' + remote_user

## $ ssh-copy-id <user>@<host>

## The authenticity of host 'xxx (xx.xxx.xx.xxx)' can't be established.
## RSA key fingerprint is ...
## Are you sure you want to continue connecting (yes/no)? yes
## /usr/bin/ssh-copy-id: INFO: attempting to log in with the new key(s), to filter out any that are already installed
## /usr/bin/ssh-copy-id: INFO: 1 key(s) remain to be installed -- if you are prompted now it is to install the new keys
## <user>@<host>'s password:

## Number of key(s) added: 1
 
## Now try logging into the machine, with:   "ssh '<user>@<host>'"
## and check to make sure that only the key(s) you wanted were added.

## Function to perform the copy. Takes public key, username, and hostname as parameters
def ssh_copy_id_python(pub_key_path,remote_user,hostname):
	print 'ssh-copy-id %s@%s' %(remote_user,hostname)
	child = pexpect.spawn('ssh-copy-id %s@%s' %(remote_user,hostname))
	try:
		index = child.expect(['continue connecting \(yes/no\)\?','\'s password:',pexpect.EOF],timeout=8)
		print index
		if index == 0:
			child.sendline('yes')
			child.expect('continue connecting \(yes/no\)')
			child.sendline('yes')
			print child.after,child.before
		if index == 1:
			child.sendline('\n')
			child.expect('\'s password:')
			child.sendline('\n')
			print child.after,child.before
		if index == 2:
			print '[ failed ]'
			print child.after,child.before
			child.close()
	except pexpect.TIMEOUT:
		print child.after,child.before
		child.close()
	else:
		print 'No exception occurring, no prompt, continuing...'
