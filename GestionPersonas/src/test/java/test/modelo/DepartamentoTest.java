package test.modelo;

import modelo.Departamento;
import modelo.EmpleadoTemporal;
import modelo.EmpleadoPermanente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DepartamentoTest {

    @Test
    public void testAgregarEmpleado() {
        Departamento depto = new Departamento(1, "Desarrollo");
        EmpleadoTemporal emp = new EmpleadoTemporal(100, "Sofía", "Ramírez", 6);

        depto.agregarEmpleado(emp);

        assertTrue(depto.getEmpleados().contains(emp));
        assertEquals("Desarrollo", emp.getDepartamento().getNombre());
    }

    @Test
    public void testEliminarEmpleado() {
        Departamento depto = new Departamento(2, "Recursos Humanos");
        EmpleadoPermanente emp = new EmpleadoPermanente(101, "Iván", "Díaz", 3);

        depto.agregarEmpleado(emp);
        depto.eliminarEmpleado(emp);

        assertFalse(depto.getEmpleados().contains(emp));
    }

    @Test
    public void testGetNombreYId() {
        Departamento depto = new Departamento(3, "Marketing");
        assertEquals("Marketing", depto.getNombre());
        assertEquals(3, depto.getId());
    }
}

