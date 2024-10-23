import threading

class WaterMolecule:
    def __init__(self):
        self.hydrogen_count = 0
        self.oxygen_count = 0
        self.lock = threading.Lock()
        self.hydrogen = threading.Condition(self.lock)
        self.oxygen = threading.Condition(self.lock)

    def Hydrogen(self):
        with self.hydrogen:
            self.hydrogen_count += 1
            if self.hydrogen_count == 2 and self.oxygen_count == 1:
                self.hydrogen.notify_all()
                self.oxygen.notify()
            else:
                self.hydrogen.wait()
        print("Hydrogen joined to form water molecule.")

    def Oxygen(self):
        with self.oxygen:
            self.oxygen_count += 1
            if self.hydrogen_count == 2 and self.oxygen_count == 1:
                self.oxygen.notify()
                self.hydrogen.notify_all()
            else:
                self.oxygen.wait()
        print("Oxygen joined to form water molecule.")

    def GetWaterMolecule(self):
        with self.lock:
            self.hydrogen_count = 0
            self.oxygen_count = 0
        return "H2O"


