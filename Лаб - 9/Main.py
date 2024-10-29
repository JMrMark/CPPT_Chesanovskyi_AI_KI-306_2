from SmartPatron import SmartPatron

if __name__ == "__main__":

    patron = SmartPatron(10, "n", True, True, 1000)
    
    patron.show_status()

    patron.use_patron()

    patron.reload_patron()

    patron.use_patron()
