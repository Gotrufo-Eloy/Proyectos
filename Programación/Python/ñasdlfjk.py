import random
i=0
x=0
list=[]
sortedlist=[]

while i < 10 :
    i = i+1
    list.append(random.randint(0,9))
f=0
print(list)
while f < 10 :
    if list[x]> list[x-1]:
        sortedlist.append(list[x-1])
    else: sortedlist.insert(0,list[x])
    x=x+1

    f = f+1



print(sortedlist)