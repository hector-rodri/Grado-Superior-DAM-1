import unittest
def add(number1, number2):
    return number1 + number2

def subtract(number1, number2):
    return number1 - number2

def multiplication(number1, number2):
    return number1 * number2

def division(number1, number2):
    if number2 == 0:
        return "Error: Division by zero is not allowed."
    return number1 / number2

def show_menu():
    print("1. Add")
    print("2. Subtract")
    print("3. Multiplication")
    print("4. Division")
    print("5. Exit")

def calculator():
    show_menu()

    try:
        number1 = float(input("Enter the first number: "))
        number2 = float(input("Enter the second number: "))
    except ValueError:
        print("Invalid input. Please enter numeric values.")
        return False

    try:
        option = int(input("Enter an option: "))
    except ValueError:
        print("Invalid input. Please enter a number between 1 and 5.")
        return False

    if option == 1:
        print("Result:", add(number1, number2))
    elif option == 2:
        print("Result:", subtract(number1, number2))
    elif option == 3:
        print("Result:", multiplication(number1, number2))
    elif option == 4:
        print("Result:", division(number1, number2))
    elif option == 5:
        return True
    else:
        print("Invalid option. Please select a number between 1 and 5.")
    return False

def run():
    exit = False
    while not exit:
        exit = calculator()

run()

class TestSum(unittest.TestCase):

    def test_sun(self):
        self.assertEqual(add(2,3),5)
