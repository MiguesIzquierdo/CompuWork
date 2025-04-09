package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un departamento dentro de la organización.
 * Cada departamento puede tener múltiples empleados.
 */
public class Departamento {
    private final int id;
    private final String nombre;
    private final List<Empleado> empleados;

    /**
     * Constructor para crear un nuevo departamento.
     * 
     * @param id     Identificador único del departamento
     * @param nombre Nombre del departamento
     */
    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Agrega un empleado al departamento.
     * 
     * @param empleado El empleado a agregar
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepartamento(this);
    }

    /**
     * Elimina un empleado del departamento.
     * 
     * @param empleado El empleado a eliminar
     */
    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    /**
     * Retorna la lista de empleados del departamento.
     * 
     * @return Lista de empleados
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Retorna el nombre del departamento.
     * 
     * @return Nombre del departamento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el ID del departamento.
     * 
     * @return ID del departamento
     */
    public int getId() {
        return id;
    }
}
