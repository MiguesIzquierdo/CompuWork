package test.modelo;

import modelo.EmpleadoPermanente;
import modelo.EmpleadoTemporal;
import modelo.Departamento;
import modelo.ReporteDesempeno;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ReporteDesempenoTest {

    @Test
    public void testGenerarReporteEmpleado() {
        EmpleadoTemporal emp = new EmpleadoTemporal(200, "Laura", "Gómez", 4);
        Departamento depto = new Departamento(10, "TI");
        depto.agregarEmpleado(emp);

        // Capturar la salida del sistema
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ReporteDesempeno.generarReporteEmpleado(emp);

        String salida = outContent.toString();

        assertTrue(salida.contains("Laura Gómez"));
        assertTrue(salida.contains("TI"));
        assertTrue(salida.contains("66.0")); // 60 + (4 * 1.5)

        // Restaurar salida estándar
        System.setOut(System.out);
    }

    @Test
    public void testGenerarReporteDepartamento() {
        EmpleadoPermanente emp1 = new EmpleadoPermanente(201, "Pedro", "Santos", 5);
        EmpleadoTemporal emp2 = new EmpleadoTemporal(202, "Carmen", "Zapata", 3);
        Departamento depto = new Departamento(11, "Soporte");

        depto.agregarEmpleado(emp1);
        depto.agregarEmpleado(emp2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ReporteDesempeno.generarReporteDepartamento(depto);

        String salida = outContent.toString();

        assertTrue(salida.contains("Pedro Santos"));
        assertTrue(salida.contains("Carmen Zapata"));
        assertTrue(salida.contains("Soporte"));

        System.setOut(System.out);
    }
}
