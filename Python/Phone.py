class Phone:

    def __init__(self,marca,modelo,año,color):
        self.marca = marca
        self.modelo = modelo
        self.año = año
        self.color = color

    def enciende(self):
        print("Este "+self.marca+" del "+self.año+" enciende")

    def noenciende(self):
        print("Este movil no enciende")