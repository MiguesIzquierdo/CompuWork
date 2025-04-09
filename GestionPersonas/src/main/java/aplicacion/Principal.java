package aplicacion;

import modelo.*;

/**
 * Clase principal que ejecuta la aplicación de gestión de personas.
 */
public class Principal {
    public static void main(String[] args) {
        // Crear departamentos
        Departamento desarrollo = new Departamento(1, "Desarrollo");
        Departamento rrhh = new Departamento(2, "Recursos Humanos");

        // Crear empleados
        Empleado e1 = new EmpleadoPermanente(101, "Carlos", "García", 5);
        Empleado e2 = new EmpleadoTemporal(102, "Ana", "López", 8);
        Empleado e3 = new EmpleadoPermanente(103, "Luis", "Martínez", 2);

        // Asignar empleados a departamentos
        desarrollo.agregarEmpleado(e1);
        desarrollo.agregarEmpleado(e2);
        rrhh.agregarEmpleado(e3);

        // Generar reportes individuales
        System.out.println("\n*** Reporte individual de un empleado ***");
        ReporteDesempeno.generarReporteEmpleado(e1);

        // Generar reportes por departamento
        System.out.println("\n*** Reporte del Departamento de Desarrollo ***");
        ReporteDesempeno.generarReporteDepartamento(desarrollo);

        System.out.println("\n*** Reporte del Departamento de RRHH ***");
        ReporteDesempeno.generarReporteDepartamento(rrhh);
    }
}
