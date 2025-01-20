/*
1. Generar nombres de usuario
Crea una función que reciba un nombre y un apellido y genere un nombre de usuario único. 
Usa las tres primeras letras del nombre y del apellido, y agrega tres números aleatorios al final. 
Investiga el uso de toLowerCase(). 
*/
package PruebasPropias.Java;

public class ud3ej1 {
    static String generarUsuario(String nombre, String apellidos){
        String letrasDelNombre = "";
        String letrasDelApellido = "";
        String numerosDelFinal = "";
        String nombreUsuario;

        for (int i = 0; i < 3; i++) {
            letrasDelApellido += apellidos.charAt(i);
            letrasDelNombre += nombre.charAt(i);
            // numerosDelFinal += String.valueOf((int)((Math.random()*10)+1));
            numerosDelFinal += (int)((Math.random()*10)+1);
            
        }
        nombreUsuario = letrasDelNombre+letrasDelApellido+numerosDelFinal;
        // System.out.println("Nombre de Usuario: "+nombreUsuario);
        return nombreUsuario;
    }
    public static void main(String[] args){
        System.out.println(generarUsuario("Eloy", "Delgado"));
        System.out.println(generarUsuario("Lucia", "Garcia"));
        System.out.println(generarUsuario("Adela", "Delgado"));
    }
}
