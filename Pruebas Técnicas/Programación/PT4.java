import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PT4 {
    static final Scanner scannerString = new Scanner(System.in);

    static final String[] signosZodiaco = {"ARIES", "LEO", "SAGITARIO", "TAURO", "VIRGO", "CAPRICORNIO", "GÉMINIS", "LIBRA", "ACUARIO", "CÁNCER", "ESCORPIO", "PISCIS"};
    static final ArrayList<String> signosZodiacoDinamico = new ArrayList<>(Arrays.asList(signosZodiaco));

    static final String[] elementosZodiaco = {"Fuego","Tierra","Aire","Agua"};
    static final ArrayList<String> elementosZodiacoDinamico = new ArrayList<>(Arrays.asList(elementosZodiaco));

    //Este array lo que hace es comprobar las compatibilidades si returnea 0 cuando elijamos frase entara a frases parejas [0] que son las frases de parejas compatibles si returnea [1] neutrales y [2] incompatibles
    static final Integer[][] elementos = {{1,1,0,2},{1,1,2,0},{0,2,1,1},{2,0,1,1}};

    static final String[][] frasesParejas = {{"Si fueras una función, serías private porque solo yo puedo acceder a ti.","Nuestra química no es solo molecular, es pura fusión nuclear de deseo.","Cuando estamos juntos, ni la Segunda Ley de la Termodinámica puede detener el aumento de la entropía en nuestras sábanas."},{"Podríamos ser como dos partículas cuánticas en entrelazamiento… o tal vez solo estamos en superposición.","Podríamos ser amigos con beneficios, o algo más… solo que aún no hemos tirado el d20 de Persuasión.","Podríamos ser como el código espagueti… enredados, caóticos, pero funcionando al final del día."},{"Eres un error 404 en mi servidor del amor… pero aún así, intentemos refrescar la conexión.","Si esto fuera un roguelike, ya habríamos muerto varias veces… pero hey, restart?","Nuestro amor es como un pixel muerto en una pantalla OLED… notamos su ausencia, pero no podemos arreglarlo."}};
    
    public static void main(String[] args) {
        
        System.out.println("Introduce el nombre de la Primera Persona");
        String nombreUsuario1 = scannerString.nextLine();
        System.out.println("Introduce el nombre de la Segunda Persona");
        String nombreUsuario2 = scannerString.nextLine();
        
        String signoUsuario1 = obtenerSignoZodiacal(nombreUsuario1);
        String elementoUsuario1 = obtenerElementoZodiacal(signoUsuario1);
        String signoUsuario2 = obtenerSignoZodiacal(nombreUsuario2);
        String elementoUsuario2 = obtenerElementoZodiacal(signoUsuario2);

        System.out.println(frasesParejas[comprobarCompatibilidad(elementoUsuario1, elementoUsuario2)][numeroAleatorio(0, 2)]);

    }
    public static String obtenerSignoZodiacal(String nombreUsuario){
        String opcionUsuario="";
        while (!signosZodiacoDinamico.contains(opcionUsuario)) {
            System.out.println("Introduce el Signo Zodiacal de: "+nombreUsuario);
            opcionUsuario = scannerString.nextLine().toUpperCase();
        }
        return opcionUsuario;
    }
    public static String obtenerElementoZodiacal(String signoUsuario){
        return elementosZodiacoDinamico.get(signosZodiacoDinamico.indexOf(signoUsuario)/3);
    }
    public static int comprobarCompatibilidad(String elementoUsuario1,String elementoUsuario2){
        return elementos[elementosZodiacoDinamico.indexOf(elementoUsuario1)][elementosZodiacoDinamico.indexOf(elementoUsuario2)];
    }
    public static int numeroAleatorio(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
}