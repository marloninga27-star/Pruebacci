package unsch;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }

    public int getSaldo() {
        return (int) saldo;
    }

    // NUEVA FUNCIONALIDAD DE LA ACTIVIDAD 4
    public void transferir(CuentaBancaria cuentaDestino, double monto) {
        if (monto > 0 && monto <= this.saldo && cuentaDestino != null) {
            this.retirar(monto);
            cuentaDestino.depositar(monto);
        }
    }
}



