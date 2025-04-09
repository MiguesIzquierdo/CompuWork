package test.modelo;

import modelo.EmpleadoPermanente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoPermanenteTest {

    @Test
    public void testCalculoDesempeno() {
        EmpleadoPermanente emp = new EmpleadoPermanente(1, "Juan", "Pérez", 5);
        double desempenoEsperado = 80 + 5 * 2; // 90
        assertEquals(desempenoEsperado, emp.calcularDesempeno(), 0.01);
    }

    @Test
    public void testGetNombreCompleto() {
        EmpleadoPermanente emp = new EmpleadoPermanente(2, "Laura", "Gómez", 3);
        assertEquals("Laura Gómez", emp.getNombreCompleto());
    }

    @Test
    public void testGetId() {
        EmpleadoPermanente emp = new EmpleadoPermanente(3, "Carlos", "Díaz", 4);
        assertEquals(3, emp.getId());
    }
}
