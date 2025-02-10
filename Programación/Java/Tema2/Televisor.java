public class Televisor {
    String canalActual;
    int volumen;
    int subirVolumen(int cantidad){
        return volumen+=cantidad;
    }
    int bajarVolumen(int cantidad){
        return volumen+=cantidad;
    }
    String cambiarCanal(String canalCambiado){
        return canalActual=canalCambiado;
    }
    String mostrarInfo(){
        return "El canal actual es:"+canalActual+" y el volumen es: "+volumen;
    }
}
