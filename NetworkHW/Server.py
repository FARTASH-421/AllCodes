import socket
import hashlib
import random


def MD5_Hash(data:str):
    return hashlib.md5(data.encode()).hexdigest()   #returns 32 byte str


serverSK = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serverSK.bind((socket.gethostname(), 1234))

serverSK.listen(1)
serverSocket, address = serverSK.accept()

print(f'IP Address Client -> {address[0]}')
serverSocket.send(bytes("Welcome to server !", "utf-8"))          # send massage to client, connecting successfully

msg = serverSocket.recv(4)                                        # receive massage to client
random_num = int((random.random()*100)%32)                        # created a random number
ServerHash = MD5_Hash(str(address[0])+str(random_num))            # create ServerHash with IP Address and random number


while True:
    print(f'Client_massage: {msg.decode()}')
    reply = "Send Hash!"
    serverSocket.send(reply.encode())
    msg = serverSocket.recv(32)

    if msg.decode() == ServerHash:                  # compare ServerHash with ClientHash
        print(f'Hash is Correct!!')
        successMag = "Hash Found"
        serverSocket.send(successMag.encode())
        break


serverSK.close()