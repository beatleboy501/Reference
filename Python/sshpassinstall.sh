#/bin/bash
cd ~
rm -rf .ssh
ssh-keygen -t rsa -N "" -f /root/.ssh/id_rsa
wget http://downloads.sourceforge.net/project/sshpass/sshpass/1.05/sshpass-1.05.tar.gz
tar xvf sshpass-1.05.tar.gz
cd sshpass-1.05
./configure
make
make install
echo "done with install"
cd ~
echo "back in root directory"
rm -rf sshpass-1.05.tar*
echo "removed tar file"
echo "yes" | ssh <user>@<host>
sshpass -p <password> ssh-copy-id -o StrictHostKeyChecking=no <user>@<host>
