import java.util.ArrayList;
import java.util.Scanner;

public class CifradoCesar {
    public static final int DESPLAZAMIENTO = 3; // Número de posiciones de desplazamiento

    // Función que debes implementar
    public static ArrayList<Character> generarAlfabetoDesplazado(ArrayList<Character> alfabetoOriginal,int desplazamiento) {
        // Esta función debe devolver un nuevo ArrayList con el alfabeto desplazado.
        ArrayList<Character> alfabetoModificado = new ArrayList<>();
        for (int i = 0; i < alfabetoOriginal.size(); i++) {
            char letraModificandose = alfabetoOriginal.get(i);
            letraModificandose+=desplazamiento;
            if (letraModificandose>'Z'){
                letraModificandose-='Z'; 
                letraModificandose+=64; 
            }
            
            alfabetoModificado.add(letraModificandose);
        }
        return alfabetoModificado;
    }

    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int input = 0;

        ArrayList<Character> alfabeto = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            alfabeto.add(c);
        }

        // Aquí deberás llamar a tu función para generar el alfabeto desplazado
        ArrayList<Character> alfabetoDesplazado = generarAlfabetoDesplazado(alfabeto, DESPLAZAMIENTO);

        // Ejemplo de impresión
        System.out.println("Alfabeto original: " + alfabeto);
        System.out.println("Alfabeto desplazado: " + alfabetoDesplazado);

        while (input!=3) {
            System.out.println("1. Cifrar mensaje\r\n" + //
                                "2. Descifrar mensaje\r\n" + //
                                "3. Salir");
            input = scannerInt.nextInt();
            if (input==1){
                System.out.println("Ingresa el mensaje a cifrar:");
                ArrayList<Character> palabraUsuarioCifrar = new ArrayList<>();
                String palabraUsuarioString = scannerStr.nextLine().toUpperCase();
                for (int i = 0; i < palabraUsuarioString.length(); i++) {
                    palabraUsuarioCifrar.add(palabraUsuarioString.charAt(i));
                }
                ArrayList<Character> cifrar = generarAlfabetoDesplazado(palabraUsuarioCifrar, DESPLAZAMIENTO);
                System.out.println(cifrar);
            }else if(input==2){
                System.out.println("Ingresa el mensaje a cifrar:");
                ArrayList<Character> palabraUsuarioDescifrar = new ArrayList<>();
                String palabraUsuarioString = scannerStr.nextLine().toUpperCase();
                for (int i = 0; i < palabraUsuarioString.length(); i++) {
                    palabraUsuarioDescifrar.add(palabraUsuarioString.charAt(i));
                }
                ArrayList<Character> descifrar = generarAlfabetoDesplazado(palabraUsuarioDescifrar, (DESPLAZAMIENTO*-1));
                System.out.println(descifrar);
            }else if(input==3){
                System.out.println("Adiosssss <3");
            }else {
                System.out.println("Input Incorrecto");
            }
        }
    }

}