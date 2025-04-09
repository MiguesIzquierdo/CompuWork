package test.modelo;

import modelo.EmpleadoTemporal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTemporalTest {

    @Test
    public void testCalculoDesempeno() {
        EmpleadoTemporal emp = new EmpleadoTemporal(4, "Mario", "Ríos", 6);
        double desempenoEsperado = 60 + (6 * 1.5); // 69.0
        assertEquals(desempenoEsperado, emp.calcularDesempeno(), 0.01);
    }

    @Test
    public void testGetNombreCompleto() {
        EmpleadoTemporal emp = new EmpleadoTemporal(5, "Lucía", "Mendoza", 3);
        assertEquals("Lucía Mendoza", emp.getNombreCompleto());
    }

    @Test
    public void testGetId() {
        EmpleadoTemporal emp = new EmpleadoTemporal(6, "Pedro", "Torres", 4);
        assertEquals(6, emp.getId());
    }
}
