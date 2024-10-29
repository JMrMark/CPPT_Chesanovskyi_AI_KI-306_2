import os
import struct
import sys
import math

class CalcException(Exception):
    pass

def writeResTxt(fName, result):
    with open(fName, 'w') as f:
        f.write(str(result))

def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = f.read()
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def writeResBin(fName, result):
     with open(fName, 'wb') as f:
        f.write(struct.pack('f', result))

def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def calculate(x):
    rad = x * math.pi / 180.0
    try:
        y = 1 / math.tan(2 * rad)
        
        # Проверяем на NaN и бесконечные значения
        if math.isnan(y) or math.isinf(y) or x % 45 == 0:
            raise ArithmeticError()
    except ArithmeticError:
        if x % 45 == 0:
            raise CalcException("Exception reason: Illegal value of X for tangent calculation")
        else:
            raise CalcException("Unknown reason of the exception during calculation")
    
    return y

if __name__ == "__main__":
    data = float(input("Enter data: "))
    result = calculate(data)
    print(f"Result is: {result}")
    try:
        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)
        print("Result is: {0}".format(readResBin("binRes.bin")))
        print("Result is: {0}".format(readResTxt("textRes.txt")))
    except FileNotFoundError as e:
        print (e)
    sys.exit(1)
