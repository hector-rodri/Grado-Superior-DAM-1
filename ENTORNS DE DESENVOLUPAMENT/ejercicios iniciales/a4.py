if __name__ == "__main__":
    print("Ingresa el primer número: ")
    A = input()
    A = int(A)
    print("Ingresa el segundo número: ")
    B=input()
    B= int(B)
    print ("Ingresa el tercer número: ")
    C=input()
    C=int(C)

    if A > B | C:
        print (A, "es mayor")
    elif B > A | C:
        print (B, "es mayor")
    elif C > A | B:
        print (C, "es mayor")