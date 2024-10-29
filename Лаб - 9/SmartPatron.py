from Patron import Patron

class SmartPatron(Patron):
    
    def __init__(self, calf, pgcl, typel, usagel, distance = 100):
        super().__init__(calf, pgcl, typel, usagel)
        self.__distance = distance

    def distance_change(self, distance):
        self.__distance = distance

    def accuracy_count(self):
        return self.__distance * 0.123
    
    def show_status(self):
        super().show_status()
        print("Accuracy: " + str(self.accuracy_count()) + "\n")

    def use_patron(self):
        return super().use_patron()
    
    def reload_patron(self):
        return super().reload_patron()
    
    def PGC_change(self, x=False):
        return super().PGC_change(x)