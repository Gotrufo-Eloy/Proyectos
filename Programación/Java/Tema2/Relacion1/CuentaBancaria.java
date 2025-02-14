public class CuentaBancaria {
    String titular ;
    double saldo; 
    double depositar(double cantidad){
        return saldo += cantidad;
    }
    double retirar(double cantidad){
        double saldoModificado;
        if (saldo-cantidad>0){
            saldoModificado = saldo-=cantidad;
        }else {
            System.out.println("No hay saldo suficiente");
            saldoModificado = saldo;
        }
        saldo = saldoModificado;
        return saldo;
    }
}
