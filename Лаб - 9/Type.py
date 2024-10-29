"""
 * 'n' = none
 * 'a' = armor piercing
 * 's' = simple
 * 'f' = incendiary (fire) 
"""

class Type:
    def __init__(self, cal="a"):
        self.__type = cal

    def set_type(self, cal):
        self.__type = cal

    def get_type(self):
        return self.__type