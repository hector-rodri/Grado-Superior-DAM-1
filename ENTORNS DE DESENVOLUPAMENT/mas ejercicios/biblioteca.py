class Llibre:
    def __init__(self, titol, autor, any_publicacio):
        self.titol = titol
        self.autor = autor
        self.any_publicacio = any_publicacio
    
    def __str__(self):
        return f"{self.titol}, {self.autor}, {self.any_publicacio}"

class Biblioteca:
    def __init__(self):
        self.llibres = []

    def afegir_llibre(self, titol, autor, any_publicacio):
        llibre = Llibre(titol, autor, any_publicacio)
        self.llibres.append(llibre)

    def cercar_llibre(self, titol):
        for llibre in self.llibres:
            if llibre.titol.lower() == titol.lower():
                return llibre
        return None

    def eliminar_llibre(self, titol):
        llibre = self.cercar_llibre(titol)
        if llibre:
            self.llibres.remove(llibre)
            return True
        return False

    def llistar_llibres(self):
        for llibre in self.llibres:
            print(llibre)
