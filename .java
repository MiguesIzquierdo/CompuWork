// Clase base Empleado
class Empleado {
    constructor(id, nombre, apellido, tipoEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoEmpleado = tipoEmpleado;
    }

    mostrarInfo() {
        return `ID: ${this.id}, Nombre: ${this.nombre} ${this.apellido}, Tipo: ${this.tipoEmpleado}`;
    }
}

// Clase para empleados permanentes
class EmpleadoPermanente extends Empleado {
    constructor(id, nombre, apellido, salario, beneficios) {
        super(id, nombre, apellido, "Permanente");
        this.salario = salario;
        this.beneficios = beneficios;
    }

    mostrarInfo() {
        return `${super.mostrarInfo()}, Salario: ${this.salario}, Beneficios: ${this.beneficios}`;
    }
}

// Clase para empleados temporales
class EmpleadoTemporal extends Empleado {
    constructor(id, nombre, apellido, horasTrabajadas, tarifaPorHora) {
        super(id, nombre, apellido, "Temporal");
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    calcularPago() {
        return this.horasTrabajadas * this.tarifaPorHora;
    }

    mostrarInfo() {
        return `${super.mostrarInfo()}, Pago: ${this.calcularPago()}`;
    }
}

// Clase Departamento
class Departamento {
    constructor(id, nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = [];
    }

    agregarEmpleado(empleado) {
        this.empleados.push(empleado);
    }

    eliminarEmpleado(idEmpleado) {
        this.empleados = this.empleados.filter(emp => emp.id !== idEmpleado);
    }

    listarEmpleados() {
        return this.empleados.map(emp => emp.mostrarInfo()).join("\n");
    }
}

// Clase ReporteDesempeño
class ReporteDesempeño {
    constructor(empleado, calificacion, comentarios) {
        this.empleado = empleado;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
    }

    generarReporte() {
        return `Reporte de ${this.empleado.nombre} ${this.empleado.apellido} - Calificación: ${this.calificacion}/10\nComentarios: ${this.comentarios}`;
    }
}

// Ejemplo de uso
const emp1 = new EmpleadoPermanente(1, "Juan", "Pérez", 50000, "Seguro médico");
const emp2 = new EmpleadoTemporal(2, "Ana", "Gómez", 40, 20);

const departamentoTI = new Departamento(101, "Tecnología");
departamentoTI.agregarEmpleado(emp1);
departamentoTI.agregarEmpleado(emp2);

console.log("Empleados en el Departamento de Tecnología:");
console.log(departamentoTI.listarEmpleados());

const reporte = new ReporteDesempeño(emp1, 9, "Excelente trabajo en equipo");
console.log(reporte.generarReporte());
