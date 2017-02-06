#/bin/bash
cd ~
ssh-keygen -t rsa -N "" -f /root/.ssh/id_rsa 
sudo wget http://downloads.sourceforge.net/project/sshpass/sshpass/1.05/sshpass-1.05.tar.gz 
tar xvf sshpass-1.05.tar.gz 
cd sshpass-1.05
./configure
make
make install
cd ~
rm -rf sshpass-1.05.tar* 
cd .ssh 
sshpass -p <password> ssh-copy-id -i id_rsa -o StrictHostKeyChecking=no <user>@<host>