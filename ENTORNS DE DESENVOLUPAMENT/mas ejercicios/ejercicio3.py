#Este ejercicio de Mouredev, consiste en crear una agenda para guardar, buscar, actualizar y eliminar contactos.

def my_agenda():

    agenda = {}

    def insert_contact(): 
        phone = input("Introduce el teléfono del contacto: ")
        if phone.isdigit() and len(phone) > 1 and len(phone) <= 11: #En esta línea obligamos a que los digitos incluidos son allfanúmericos y tienen que ser entre 1 y 11 dígitos.
            agenda[name] = phone
        else:
            print(
                "NO VÁLIDO. EL NÚMERO DE TELÉFONO TIENE QUE SER DE 11 DÍGITOS.")#Si el número no cumple los requisitos, la función no se ejecutará y aparecerá este mensaje.

    while True:

        print("1. Buscar contacto")
        print("2. Agregar contacto")
        print("3. Actualizar contacto")
        print("4. Eliminar contacto")
        print("5. Salir")

        option = input("\nSelecciona una opción: ")

        match option:#Según el caso que elija se ejecutará una funcionalidad o otra.
            case "1":
                name = input("Introduce el nombre del contacto: ")
                if name in agenda:
                    print(
                        f"El número de teléfono de {name} es {agenda[name]}.")#Introducir un nombre 
                else:
                    print(f"El contacto {name} no existe.")#Si el nombre no tiene ningún número guardado, no funcionará y aparecerá este mensaje.
            case "2":
                name = input("Introduce el nombre del contacto: ")#Introduces un nombre al contacto para agregarlo
                insert_contact()
            case "3":
                name = input("Introduce el nombre del contacto a actualizar: ")#Contacto a actualizar introducido
                if name in agenda:
                    insert_contact()
                else:
                    print(f"El contacto {name} no existe.")#Si el contacto no existe, saldrá este print
            case "4":
                name = input("Introduce el nombre del contacto a a eliminar: ")#Introduces el nombre del contacto para eliminarlo
                if name in agenda:
                    del agenda[name]
                else:
                    print(f"El contacto {name} no existe.")#Si el contrato introducido no existe, saldrá este print
            case "5":
                print("Saliendo de la agenda.")
                break#La opción de salir la conseguimos con este "break", el cual sale del bucle
            case _:
                print("Opción no válida. Elige una opción del 1 al 5.")#Si la opción no es válida, sale este print


my_agenda()