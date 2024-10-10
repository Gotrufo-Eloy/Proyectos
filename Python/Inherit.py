class Animal:

    alive = True

    def eat(self):
        print("This animal is eating")

    def sleep(self):
        print("This animal is sleeping")

class Rabbit(Animal):
    def jump(self):
        print("This animal is jumping")
    pass
class Fish(Animal):
    def swim(self):
        print("This fish is swimming")
    pass
class Hawk(Animal):
    def fly(self):
        print("This hawk is flying")
    pass

rabbit = Rabbit()
fish = Fish()
hawk = Hawk()

hawk.fly()