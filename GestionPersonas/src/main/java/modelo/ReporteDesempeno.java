package modelo;

import java.util.List;

/**
 * Clase utilitaria para generar reportes de desempeño de empleados y departamentos.
 */
public class ReporteDesempeno {

    /**
     * Genera e imprime en consola un reporte de desempeño para un empleado.
     *
     * @param empleado El empleado del cual se genera el reporte.
     */
    public static void generarReporteEmpleado(Empleado empleado) {
        System.out.println("== Reporte de Desempeño del Empleado ==");
        System.out.println("Nombre:       " + empleado.getNombreCompleto());
        System.out.println("ID:           " + empleado.getId());
        System.out.println("Departamento: " + (empleado.getDepartamento() != null 
            ? empleado.getDepartamento().getNombre() 
            : "Sin asignar"));
        System.out.println("Desempeño:    " + empleado.calcularDesempeno());
        System.out.println("-----------------------------------------\n");
    }

    /**
     * Genera e imprime en consola un reporte de desempeño para todos los empleados de un departamento.
     *
     * @param depto El departamento del cual se genera el reporte.
     */
    public static void generarReporteDepartamento(Departamento depto) {
        System.out.println("=========================================");
        System.out.println("== Reporte del Departamento: " + depto.getNombre() + " ==");
        System.out.println("ID del Departamento: " + depto.getId());
        System.out.println("Cantidad de empleados: " + depto.getEmpleados().size());
        System.out.println("-----------------------------------------");

        List<Empleado> empleados = depto.getEmpleados();
        for (Empleado e : empleados) {
            generarReporteEmpleado(e);
        }

        System.out.println("== Fin del Reporte del Departamento ==\n");
    }
}
