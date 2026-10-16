package unsch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {
    @Test
    void depositoDebeIncrementarSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.obtenerSaldo());
    }

    //AGREGANDO RETIRO
    @Test
    void retiroDebeDisminuirSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(40);
        assertEquals(60, cuenta.obtenerSaldo());
    }
}
