#!/usr/bin/env python3

import socket

HOST = "127.0.0.1"
PORT = 8080

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    message = input('Enter message: ')
    s.sendall(message.encode('utf-8'))
    s.shutdown(socket.SHUT_WR)
    data = s.recv(1)

result = int.from_bytes(data, 'big')
print('Received', result)
