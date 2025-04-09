package modelo;

public class EmpleadoPermanente extends Empleado {
    private int aniosExperiencia;
    private double salarioBase;
    private double bono;

    // Constructor compatible con las pruebas (5 argumentos)
    public EmpleadoPermanente(int id, String nombre, String apellido, double salarioBase, double bono) {
        super(id, nombre, apellido);
        this.salarioBase = salarioBase;
        this.bono = bono;
        this.aniosExperiencia = 0; // opcional
    }

    // Constructor original (por si lo querés seguir usando)
    public EmpleadoPermanente(int id, String nombre, String apellido, int aniosExperiencia) {
        super(id, nombre, apellido);
        this.aniosExperiencia = aniosExperiencia;
    }

    public double calcularSalario() {
        return salarioBase + bono;
    }

    @Override
    public double calcularDesempeno() {
        return 80 + aniosExperiencia * 2;
    }
}
