if __name__ == "__main__":
    print("Ingresa el primer número: ")
    A = input()
    A = int(A)
    print("Ingresa el segundo número: ")
    B=input()
    B= int(B)

suma = A + B
resta = A - B
producto = A * B

if B != 0:
    division = A / B
else:
    division = "Error"

print ("La suma de estos números es= ",suma)
print ("La resta de estos números es= ",resta)
print ("El produccto de estos números es= ",producto)
print ("La division de estos números es= ",division)
    

    
