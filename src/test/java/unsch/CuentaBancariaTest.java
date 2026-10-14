package unsch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    @Test
    void retirarConSaldoSuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(200);
        // Si tu método de consulta se llama obtenerSaldo, cámbialo aquí a cuenta.obtenerSaldo()
        assertEquals(800, cuenta.getSaldo());
    }

    @Test
    void retirarConSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(500); // Intenta retirar más de lo que hay
        assertEquals(100, cuenta.getSaldo()); // El saldo no debería cambiar
    }

    @Test
    void retirarMontoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(-200); // Intenta retirar una cantidad inválida
        assertEquals(1000, cuenta.getSaldo()); // El saldo no debería cambiar
    }

    @Test
    void depositarMontoValido() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500); // Prueba el método depositar que faltaba
        assertEquals(1500, cuenta.getSaldo()); // El saldo debe incrementarse
    }

    @Test
    void transferirMontoValido() {
        CuentaBancaria cuentaOrigen = new CuentaBancaria(1000);
        CuentaBancaria cuentaDestino = new CuentaBancaria(500);
        cuentaOrigen.transferir(cuentaDestino, 300);
        assertEquals(700, cuentaOrigen.getSaldo());
        assertEquals(800, cuentaDestino.getSaldo());
    }

    @Test
    void transferirSaldoInsuficiente() {
        CuentaBancaria cuentaOrigen = new CuentaBancaria(100);
        CuentaBancaria cuentaDestino = new CuentaBancaria(500);
        cuentaOrigen.transferir(cuentaDestino, 800);
        assertEquals(100, cuentaOrigen.getSaldo());
        assertEquals(500, cuentaDestino.getSaldo());
    }

}
