import socket
import hashlib
import random


def MD5_Hash(data:str):
    return hashlib.md5(data.encode()).hexdigest() #returns 32 byte str


clientSK = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
clientSK.connect((socket.gethostname(), 1234))


IP_address = socket.gethostbyname(socket.gethostname())
print(f"My IP Address-> {IP_address} ")


msg = clientSK.recv(22)
print(f'Sever_massage : {msg.decode()}')

mass = "Auth"
clientSK.send(mass.encode())

while True:
    msg = clientSK.recv(12)
    if msg.decode() == "Hash Found":
        print(f'Sever_massage: {msg.decode()}')
        break

    print(f'Sever_massage: {msg.decode()}')
    random_num = int((random.random()*100) % 32)
    ClientHash = MD5_Hash(str(IP_address) + str(random_num))
    clientSK.send(ClientHash.encode())

clientSK.close()


