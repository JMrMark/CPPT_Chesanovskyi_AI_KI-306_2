"""
 * Used = true
 * Not Used = false
"""

class Usage:
    def __init__(self, cal= False):
        self.__usage = cal

    def set_usage(self, cal):
        self.__usage = cal

    def get_usage(self):
        return self.__usage