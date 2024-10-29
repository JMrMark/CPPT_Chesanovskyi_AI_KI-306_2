class Caliber:
    def __init__(self, cal=0.0):
        self.__caliber = cal

    def set_caliber(self, cal):
        self.__caliber = cal

    def get_caliber(self):
        return self.__caliber