def main():
    # Читаємо розмір масиву і символ заповнення
    nRows = read_size()
    filler = read_filler()

    # Створюємо зубчастий масив
    jagged_array = create_jagged_array(nRows)

    # Заповнюємо масив символом
    fill_jagged_array(jagged_array, filler)

    # Виводимо масив на екран
    print_jagged_array(jagged_array)

# Метод для зчитування розміру масиву від користувача
def read_size():
    nRows = int(input("Size: "))
    return nRows

# Метод для зчитування символу від користувача
def read_filler():
    filler_input = input("Symbol: ")
    # Перевірка, що введено один символ
    if len(filler_input) != 1:
        print("Please provide exactly one symbol.")
        exit(1)  # завершення програми, якщо введено більше одного символу
    return filler_input[0]

# Метод для створення зубчастого масиву
def create_jagged_array(nRows):
    jagged_array = []
    mid_point = nRows // 2
    for i in range(nRows): #range(1, 5, 1)
        num_symbols = i + 1 if i < mid_point else nRows - i
        jagged_array.append([None] * num_symbols)  # створюємо рядок необхідної довжини
    return jagged_array

# Метод для заповнення зубчастого масиву
def fill_jagged_array(jagged_array, filler):
    for i in range(len(jagged_array)):
        for j in range(len(jagged_array[i])):
            jagged_array[i][j] = filler

# Метод для виведення масиву на екран і у файл
def print_jagged_array(jagged_array):
    for row in jagged_array:
        line = ''.join(row)
        print(line)

# Виконання основної програми
if __name__ == "__main__":
    main()
