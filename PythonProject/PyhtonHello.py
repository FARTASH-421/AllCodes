class Students:
    def __init__(self, fName, LName, age, id):
        self.name = fName
        self.lName = LName
        self.age = age
        self.id = id

    def getName(self):
        return self.name

    def getLastName(self):
        return self.lName

    def getAge(self):
        return self.age

    def getId(self):
        return self.id

    def __set_name__(self, name):
        self.name = name

    def setLastName(self, Lnaem):
        self.lName = Lnaem

    def setAge(self, age):
        self.age = age

    def setID(self, id):
        self.id = id

    def showInfo(self):
        print(f"Name: {self.name}\nLast Name: {self.lName}\nage: {self.age}\nID: {self.id}")


s = Students("A", "Fartash", 21, 99243100)
s.showInfo()
s.__set_name__("Abdul Qadir")
print("===================")
s.showInfo()
