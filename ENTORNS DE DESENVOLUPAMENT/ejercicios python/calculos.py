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

    if A<0:
        print (A*B*C, "ESTE ES EL PRODUCTO DE LOS TRES NÚMEROS")
    else:
        print (A+B+C, "ESTA ES LA SUMA DE LOS TRES NÚMEROS")
    