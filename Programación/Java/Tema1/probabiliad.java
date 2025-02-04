import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections; 

public class probabiliad {
    static final int numeroCaras = 6;
    static final int numeroDados = 2;
    static final int numeroTiradas = 1000;

    public static int lanzarDados(int numeroDados, int numeroCaras){
        int sumaDados = 0;

        for (int i = 0; i < numeroDados; i++) {
            Random randomGenerator = new Random();
            sumaDados += randomGenerator.nextInt(6)+1;
        }
        return sumaDados;
    }

    public static void main(String[] args) {
        ArrayList<Integer> resultados = new ArrayList<>();

        for (int i = -1; i < numeroCaras*numeroDados; i++) {
            resultados.add(0);
        }
        for (int j = 0; j < numeroTiradas; j++) {
            int resultadoTirada = lanzarDados(numeroDados, numeroCaras);
            int resultadoActual = resultados.get(resultadoTirada)+1;
            resultados.set(resultadoTirada,resultadoActual);
        }

        String line = "";  
        int multiplicador = Collections.max(resultados)/10;
        int size = 11;
        for (int i = 0; i < size; i++) {
            int lineaUwU = multiplicador*(size-i);
            line+="\n"+lineaUwU;
            for (int j = 0; j < resultados.size(); j++) {
                if (resultados.get(j)/(multiplicador*(size-i))>0) {
                    line+=". ";
                }else{
                    line+="  ";
                }
            }
            
        }
        line+="\n   0 1 2 3 4 5 6 7 8 9 10 11 12";

        System.out.println(resultados);
        System.out.println(line);
    }
}