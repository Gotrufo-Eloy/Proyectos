import random
import time

start = time.time()
x = 1000000

macro = set()
while x != 0:
    number = random.randint(1,10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000)
    lista = [number]
    while number != 1:

        if number not in macro:
            macro.add(number)
            if (number / 2).is_integer():
                number = number / 2
                lista.append(number)

            else:
                number = (number * 3) + 1
                lista.append(number)
        else:
            number = 1
    print(x,"",lista[-1])
    #print(lista)



    x = x - 1
end = time.time()
print (sorted(macro))
print(end - start)

