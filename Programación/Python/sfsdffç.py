import time
num1= 0
num2= 1
nextnumber= num2
start = time.time()
while nextnumber < 10000000000000000000000000000000000000000000000000000000000:
    print(nextnumber)
    num1, num2 = num2, nextnumber
    nextnumber = num1+num2

end = time.time()
print(end - start)