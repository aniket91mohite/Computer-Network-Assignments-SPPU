import socket

print 'Welcome to DNS Lookup'

var=raw_input('Enter URL : ')
addr2 = socket.gethostbyname(var)
print(addr2)

var1=raw_input('Enter IP Address:')
addr6=socket.gethostbyaddr(var1)
print(addr6)


