import time

name = None
acount = None
newacount = None
check = None
newpassword = None
contraseña = None

passwords = {'admin':'admin',
            'Eloy':'Alicante'}


 while acount == None:
    acount = input ("Do you have an acount: (Y/N)")
    if acount == "Y":
        while name == None:
            name = input("Enter your name: ")
            if name in passwords.keys():
                while contraseña == None:
                    contraseña = input("Enter your password: ")
                    if contraseña != None and contraseña == passwords.get(name):
                            print("Welcome "+name)
                    else:
                        print("Incorrect password.")
                        contraseña = None
            else:
                print("User not authorised, please try again")
                time.sleep(1)
                name = None
    elif acount == "N":
        while check == None:
            check = input("Do you want to create an acount: (Y/N)")
            if check == "Y":
                while  newacount == None:
                    newacount = input("Insert your name: ")
                    if newacount != None:
                        while newpassword == None:
                            newpassword = input("Create your password: ")
                            if newpassword != None:
                                passwords.update({newacount: newpassword})
                                while name == None:
                                    name = input("Enter your name: ")
                                    if name in passwords.keys():
                                        while contraseña == None:
                                            contraseña = input("Enter your password: ")
                                            if contraseña != None and contraseña == passwords.get(name):
                                                print("Welcome " + name)
                                            else:
                                                print("Incorrect password.")
                                                contraseña = None
            else:
                print("Thank you for your time.")
                exit(0)

    else:
        exit(0)





