temp =  int(input("what is the temperature outside?: "))

#if temp >= 0 and temp <= 30:
    #print("its fine outside")
#elif temp <0 or temp > 30:
    #-22print("the weather is crazy")

if not(temp >= 0 and temp <= 30):
    print("the weather is crazy")
elif not(temp <0 or temp > 30):
    print("its fine outside")