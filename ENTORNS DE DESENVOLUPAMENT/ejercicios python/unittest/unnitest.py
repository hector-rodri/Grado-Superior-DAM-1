import unittest
from biblioteca import Biblioteca, Llibre

class TestBiblioteca(unittest.TestCase):

    def setUp(self):
        self.biblioteca = Biblioteca()
        self.biblioteca.afegir_llibre("El cementerio de animales", "Stephen King", 1983)
        self.biblioteca.afegir_llibre("Watchmen", "Alan Moore", 1986)

    def test_afegir_llibre(self):
        self.biblioteca.afegir_llibre("El arte de la guerra", "Sun Tzu", 1700)
        llibre = self.biblioteca.cercar_llibre("El arte de la guerra")
        self.assertIsNotNone(llibre)
        self.assertEqual(llibre.autor, "Sun Tzu")

    def test_cercar_llibre(self):
        llibre = self.biblioteca.cercar_llibre("Watchmen")
        self.assertIsNotNone(llibre)
        self.assertEqual(llibre.autor, "Alan Moore")

    def test_eliminar_llibre(self):
        resultat = self.biblioteca.eliminar_llibre("Watchmen")
        self.assertTrue(resultat)
        llibre = self.biblioteca.cercar_llibre("Watchmen")
        self.assertIsNone(llibre)

    def test_llistar_llibres(self):
        llistat = self.biblioteca.llistar_llibres()
        self.assertEqual(len(llistat), 2)
        self.assertIn("El cementerio de animales - Stephen King (1983)", llistat)
        self.assertIn("Watchmen - Alan Moore (1986)", llistat)

if __name__ == "__main__":
    unittest.main()
    



