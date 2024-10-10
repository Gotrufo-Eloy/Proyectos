#list = used to store multiple items in a single variable
food = ["pizza","hamburgers","nachos","hotdog"]
food[0] = "sushi"
print(food
      )

food.append("ice cream")
food.remove("hotdog")
food.pop()
food.insert(0,"cake")
food.sort()

for x in food:
    print(x.capitalize()+" ", end="")