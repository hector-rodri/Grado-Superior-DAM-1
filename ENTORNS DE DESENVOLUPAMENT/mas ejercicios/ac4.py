if __name__=="__main__":
    print("Hola!!!")
    print("Dime un número:")
    A= float(input())
    print("Dime otro número:")
    B= float (input())
    print("Dime otro número:")
    C= float (input())

    if A>B>C:
        print(A)
    if B>A>C:
        print(B)
    if C>B>A:
        print(C)