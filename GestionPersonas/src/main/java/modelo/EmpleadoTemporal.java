package modelo;

/**
 * Representa a un empleado temporal con un contrato por una cantidad de meses específica.
 */
public class EmpleadoTemporal extends Empleado {
    private final int mesesContrato;

    /**
     * Constructor del empleado temporal.
     * 
     * @param id             Identificador del empleado
     * @param nombre         Nombre del empleado
     * @param apellido       Apellido del empleado
     * @param mesesContrato  Duración del contrato en meses
     */
    public EmpleadoTemporal(int id, String nombre, String apellido, int mesesContrato) {
        super(id, nombre, apellido);
        this.mesesContrato = mesesContrato;
    }

    /**
     * Calcula el desempeño del empleado temporal.
     * 
     * @return Puntaje de desempeño basado en la duración del contrato
     */
    @Override
    public double calcularDesempeno() {
        return 60 + (mesesContrato * 1.5);
    }

    public int getMesesContrato() {
        return mesesContrato;
    }
}
