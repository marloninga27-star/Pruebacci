package unsch;

public class CuentaBancaria {
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
        public void retirar(double monto) {
            if (monto > 0 && monto <= saldo) {
                saldo -= monto;
            }
        }
        public double getSaldo() {
            return saldo;
        }

    }
}
