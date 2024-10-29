"""
 * Permission of the Geneva Convention
 * Forbidden = 'true'
 * Not forbidden = 'false'
"""

class PGC:
    def __init__(self, cal= False):
        self.__pgc = cal

    def set_pgc(self, cal):
        self.__pgc = cal

    def get_pgc(self):
        return self.__pgc