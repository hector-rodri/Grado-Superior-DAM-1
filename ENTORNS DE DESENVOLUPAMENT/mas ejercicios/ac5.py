if __name__=="__main__":
    print("Hola!!!")
    print("Necesito que me digas la fecha de hoy")
    print("Dime el dia")
    DIA= float(input())
    print("Dime el mes:")
    MES= float (input())

if MES == 2:
    if 1 <= DIA <= 29:
        print("La fecha es correcta")
    else:
        print("La fecha es incorrecta")
elif MES in [4, 6, 9, 11]:
    if 1 <= DIA <= 30:
        print("La fecha es correcta")
    else:
        print("La fecha es incorrecta")
elif MES in [1, 3, 5, 7, 8, 10, 12]:
    if 1 <= DIA <= 31:
        print("La fecha es correcta")
    else:
        print("La fecha es incorrecta")
else:
    print("ERROR")