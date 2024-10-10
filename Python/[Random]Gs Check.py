name = None
clase = None
raza = None
spec = None
gs = None
discord = None



while not name:
    name = input("Nombre: ")
while not discord:
    discord = input("Discord: ")
while not raza:
    raza = input("Raza: ")
while not clase:
    clase = input("Clase: ")
while not spec:
    spec = input("Spec: ")
while not gs:
    gs = input("Gear Score actual: ")

if int(gs) < 4200:
    print("Te falta algo de Gs para acceder a la raid")
else:
    print("Te contactaremos cuanto antes")

