import math as m
import numpy as np
x = np.array([2,3,4])
class Human:
    def __init__(self, name,Lname, age):
        self.name = name
        self.lastName = Lname
        self.age = age
    def show(self):
        print("name is:",self.name, end="\n")
        print("LastName is:", self.lastName,end="\n")
        print("age is:", self.age)

h = Human("Fartash","AAQQ",24)
x = np.linspace(-1,1,100)* m.pi
y = np.sin(x,'r-*')
h.show()