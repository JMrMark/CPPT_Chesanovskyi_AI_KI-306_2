from Caliber import Caliber
from PGC import PGC
from Type import Type
from Usage import Usage

class Patron:

    def __init__(self, calf, pgcl, typel, usagel):
        self.__caliber = Caliber(calf)
        self.__pgc = PGC(pgcl)
        self.__type = Type(typel)
        self.__usage = Usage(usagel)

    def show_status(self):
        print("Caliber: " + str(self.__caliber.get_caliber()))
        print("PGC: " + str(self.__pgc.get_pgc()))
        print("Type: " + str(self.__type.get_type()))
        print("Usage: " + str(self.__usage.get_usage()) + "\n")

    def reload_patron(self):
        self.__usage.set_usage(False)

    def PGC_change(self, x = False):
        self.__pgc.set_pgc(x)

    def use_patron(self):
        if (self.__pgc.get_pgc() == True):
            print("Cannot use patron! Problem: PGC\n")
            return
        
        if (self.__usage.get_usage() == True):
            print("Cannot use patron! Problem: Usage\n")
            return

        self.__usage.set_usage(True)
        print("Patron was successfully used\n")



