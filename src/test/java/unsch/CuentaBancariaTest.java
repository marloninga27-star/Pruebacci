package unsch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    @Test
    void retirarConSaldoSuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(200);
        assertEquals(800, cuenta.getSaldo());
    }

    @Test
    void retirarConSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(500);
        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void retirarMontoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(-200);
        assertEquals(1000, cuenta.getSaldo());
    }

    @Test
    void depositarMontoValido() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.getSaldo());
    }

    @Test
    void depositarMontoInvalido() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(-200);
        assertEquals(1000, cuenta.getSaldo());
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
    void transferirMontoInvalido() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);
        origen.transferir(destino, -100);
        assertEquals(1000, origen.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void transferirSaldoInsuficiente() {
        CuentaBancaria cuentaOrigen = new CuentaBancaria(100);
        CuentaBancaria cuentaDestino = new CuentaBancaria(500);
        cuentaOrigen.transferir(cuentaDestino, 800);
        assertEquals(100, cuentaOrigen.getSaldo());
        assertEquals(500, cuentaDestino.getSaldo());
    }

    @Test
    void transferirCuentaDestinoNull() { // <--- Esta prueba cubre el camino que te faltaba
        CuentaBancaria origen = new CuentaBancaria(1000);
        origen.transferir(null, 200);
        assertEquals(1000, origen.getSaldo());
    }

    @Test
    void cobrarComisionExitoso() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.cobrarComision(50);
        assertEquals(950, cuenta.getSaldo());
    }

    @Test
    void cobrarComisionMontoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.cobrarComision(-20);
        assertEquals(1000, cuenta.getSaldo());
    }

    @Test
    void cobrarComisionSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.cobrarComision(200);
        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void obtenerSaldoCorrecto() {
        CuentaBancaria cuenta = new CuentaBancaria(500);
        assertEquals(500.0, cuenta.obtenerSaldo());
    }
}