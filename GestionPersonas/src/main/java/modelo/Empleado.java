package modelo;

public abstract class Empleado {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected Departamento departamento;

    public Empleado(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Métodos nuevos para compatibilidad con las pruebas
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getId() {
        return id;
    }

    public abstract double calcularDesempeno();
}
