import sh

my_server = sh.ssh.bake("<user>@<host>")
print(my_server.ifconfig())
print(my_server.whoami())
