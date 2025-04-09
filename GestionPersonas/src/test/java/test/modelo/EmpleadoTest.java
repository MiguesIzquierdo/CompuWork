package test.modelo;

import modelo.EmpleadoTemporal;
import modelo.Departamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void testGetNombreCompleto() {
        EmpleadoTemporal emp = new EmpleadoTemporal(1, "Laura", "Vega", 6);
        assertEquals("Laura Vega", emp.getNombreCompleto());
    }

    @Test
    public void testAsignarYObtenerDepartamento() {
        EmpleadoTemporal emp = new EmpleadoTemporal(2, "Mario", "Díaz", 3);
        Departamento depto = new Departamento(101, "Ventas");
        emp.setDepartamento(depto);

        assertNotNull(emp.getDepartamento());
        assertEquals("Ventas", emp.getDepartamento().getNombre());
    }

    @Test
    public void testGetId() {
        EmpleadoTemporal emp = new EmpleadoTemporal(5, "Sara", "Lopez", 2);
        assertEquals(5, emp.getId());
    }
}
