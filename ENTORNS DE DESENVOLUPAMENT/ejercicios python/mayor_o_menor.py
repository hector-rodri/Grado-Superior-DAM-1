if __name__ == "__main__":
    print("Ingresa el primer número: ")
    A = input()
    A = int(A)
    print("Ingresa el segundo número: ")
    B=input()
    B= int(B)

    if A > B:   
        print (A, "es mayor")
    elif A==B:
         print(A,"y",B, "son iguales")
    else:   
        print (B, "es mayor")