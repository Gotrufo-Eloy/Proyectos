/*
1. Encuentra el Elemento Más Largo
Dado un array de palabras, escribe una función que encuentre la palabra más larga.
Ejemplo: ["apple", "banana", "kiwi", "watermelon"] debería devolver "watermelon". 
*/
package PruebasPropias.Java;

public class ud2ej2 {
    public static void main(String[] args){
        String[] palabras = {"apple", "banana", "kiwi", "watermelon"};
        String palabraMasLarga = "";
        String palabraActual;

        for (int i = 0; i < palabras.length; i++) {
            palabraActual=palabras[i];
            if (palabraActual.length()>palabraMasLarga.length()){
                palabraMasLarga=palabraActual;
            }
        }
        System.out.println("La palabra mas larga es: "+palabraMasLarga);
    }
}
