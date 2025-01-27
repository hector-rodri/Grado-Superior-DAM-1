import math 
def a6():
    print("Ingresa el primer número: ")
    A = input()
    A = int(A)

    if A<=0:
        print("ERROR")
        return None 
    else:
        print("DEL NÚMERO",A, "SU POTENCIA ES",A*A, "Y SU RAIZ ES", (math.sqrt(A)))
    


if __name__ == "__main__":
    a6()