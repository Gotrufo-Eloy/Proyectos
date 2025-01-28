import java.util.Scanner;
import java.util.Random;

/**
 * Juego del Número Secreto.
 * El jugador debe adivinar un número secreto generado aleatoriamente dentro de un rango.
 */
public class NumeroSecreto {

    /**
     * Genera un número secreto aleatorio entre dos límites inclusivos.
     *
     * @param limiteInferior el límite inferior del rango
     * @param limiteSuperior el límite superior del rango
     * @return un número entero aleatorio entre limiteInferior y limiteSuperior
     */
    public static int generarNumeroSecreto(int limiteInferior, int limiteSuperior) {
        // TO-DO
        Random randomGenerator = new Random();
        int numeroAleatorio = randomGenerator.nextInt(limiteSuperior)+limiteInferior;
        return numeroAleatorio;
    }

    /**
     * Verifica si el intento es mayor, menor o igual al número secreto.
     *
     * @param numeroSecreto el número secreto que el jugador intenta adivinar
     * @param intento el número ingresado por el jugador
     * @return "mayor" si el intento es mayor al número secreto,
     *         "menor" si el intento es menor al número secreto,
     *         "igual" si el intento es igual al número secreto
     */
    public static String verificarNumero(int numeroSecreto, int intento) {
        // TO-DO
        String comprobacionRealizada = "";
        if (numeroSecreto == intento){
            comprobacionRealizada = "igual";
        }else if (numeroSecreto > intento){
            comprobacionRealizada = "menor";
        }else {
            comprobacionRealizada = "mayor";
        }
        return comprobacionRealizada;
    }

    /**
     * Comprueba si un número está dentro de un rango especificado.
     *
     * @param numero el número a comprobar
     * @param limiteInferior el límite inferior del rango
     * @param limiteSuperior el límite superior del rango
     * @return true si el número está dentro del rango, false en caso contrario
     */
    public static boolean estaDentroDelRango(int numero, int limiteInferior, int limiteSuperior) {
        // TO-DO
        return (numero>=limiteInferior&&numero<=limiteSuperior);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limiteInferior = 1;
        int limiteSuperior = 100;
        int maxIntentos = 10;

        int numeroSecreto = generarNumeroSecreto(limiteInferior, limiteSuperior);
        int intentosRestantes = maxIntentos;
        boolean adivinado = false;

        System.out.println("Bienvenido al juego del Número Secreto");
        System.out.println("Adivina el número entre " + limiteInferior + " y " + limiteSuperior);
        System.out.println("Tienes " + maxIntentos + " intentos");

        while (intentosRestantes > 0 && !adivinado) {
            System.out.print("Introduce un número entre " + limiteInferior + " y " + limiteSuperior + ": ");
            int intento = scanner.nextInt();
            String mensaje = "";

            if (!estaDentroDelRango(intento, limiteInferior, limiteSuperior)) {
                mensaje = "Por favor, introduce un número válido entre " + limiteInferior + " y " + limiteSuperior;
            } else {
                String resultado = verificarNumero(numeroSecreto, intento);

                if (resultado.equals("igual")) {
                    mensaje = "¡Correcto! Has adivinado el número secreto";
                    adivinado = true;
                } else {
                    intentosRestantes = intentosRestantes - 1;
                    if (resultado.equals("mayor")) {
                        mensaje = "El número secreto es menor. ";
                    } else {
                        mensaje = "El número secreto es mayor. ";
                    }
                    mensaje = mensaje + "Te quedan " + intentosRestantes + " intentos";
                }
            }

            System.out.println(mensaje);
        }

        if (!adivinado) {
            System.out.println("Lo siento, te has quedado sin intentos. El número secreto era: " + numeroSecreto);
        }
    }
}