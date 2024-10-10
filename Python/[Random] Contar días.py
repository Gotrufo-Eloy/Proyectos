meses = {'Enero':31,'Febrero':28,'Marzo':31,'Abril':30,'Mayo':31,'Junio':30,'Julio':31,'Agosto':31,'Septiembre':30,'Octubre':31,'Noviembre':30,'Diciembre':31}
año_1 = input("Año 1:")
mes_1 = input("Mes 1: ")
día_mes_1 = input("Día del mes 1: ")
año_2 = input("Año 2:")
mes_2 = input("Mes 2: ")
día_mes_2 = input("Dia del mes 2: ")

año_1 = int(año_1)+1
mes_1 = mes_1.capitalize()
día_mes_1 = int(día_mes_1)
año_2 = int(año_2)+1
mes_2 = mes_2.capitalize()
día_mes_2 = int(día_mes_2)

diferencia_años = año_2-año_1

index_1 = int(list(meses).index(mes_1))
index_2 = int(list(meses).index(mes_2))
if año_2 > año_1:
    index_2 = index_2 + (año_2-año_1) *12
    diferencia_años = diferencia_años -1
else:
    print("cant do reverse yet ")
differencia_indices = index_2-index_1
putos_bisiestos = 0
y = 0
año_x = año_1
while diferencia_años > y:
    if (año_x/4).is_integer():
        putos_bisiestos +=1
    año_x +=1
    y +=1
    # if año_x/100.isinteger()
    #   putos bisiestos -=1

diferencia_años = diferencia_años*365
if differencia_indices > 1:
    x = 0
    diasacum = 0

    while differencia_indices > x:
        diasacum = diasacum + list(meses.values())[index_1]
        index_1 = index_1 + 1
        x += 1
        if index_1 > 11:
            index_1 = 0

if mes_1 in meses and mes_2 in meses:
    if diasacum == 0 and diferencia_años == 0:
        print(meses.get(mes_1)-día_mes_1+día_mes_2)
    elif diferencia_años > 0 and diasacum == 0:
        print(meses.get(mes_1)-día_mes_1+día_mes_2+ diferencia_años+putos_bisiestos)
    else:
        print(diasacum + día_mes_2 - día_mes_1+putos_bisiestos )
else:
    print("Ese mes no existe")

// hola