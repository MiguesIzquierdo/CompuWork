package interfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends Application {

    // Lista de empleados registrados
    private List<String> empleados = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Empleados");

        // Crear campos de formulario
        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();

        Label apellidoLabel = new Label("Apellido:");
        TextField apellidoField = new TextField();

        Label cedulaLabel = new Label("Cédula:");
        TextField cedulaField = new TextField();

        Label tipoLabel = new Label("Tipo de Empleado:");
        ComboBox<String> tipoCombo = new ComboBox<>();
        tipoCombo.getItems().addAll("Permanente", "Temporal");

        Label departamentoLabel = new Label("Departamento:");
        ComboBox<String> departamentoCombo = new ComboBox<>();
        departamentoCombo.getItems().addAll("Recursos Humanos", "Finanzas", "Tecnología", "Marketing");

        Button registrarBtn = new Button("Registrar");
        registrarBtn.setOnAction(e -> {
            String nombre = nombreField.getText().trim();
            String apellido = apellidoField.getText().trim();
            String cedula = cedulaField.getText().trim();
            String tipo = tipoCombo.getValue();
            String departamento = departamentoCombo.getValue();

            if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || tipo == null || departamento == null) {
                mostrarAlerta("Error", "Todos los campos deben estar llenos.");
                return;
            }

            String empleado = String.format("Nombre: %s %s | Cédula: %s | Tipo: %s | Departamento: %s",
                    nombre, apellido, cedula, tipo, departamento);

            empleados.add(empleado);

            mostrarAlerta("Registro Exitoso", "Empleado registrado:\n" + nombre + " " + apellido);

            // Limpiar campos
            nombreField.clear();
            apellidoField.clear();
            cedulaField.clear();
            tipoCombo.getSelectionModel().clearSelection();
            departamentoCombo.getSelectionModel().clearSelection();
        });

        Button generarReporteBtn = new Button("Generar Reporte de Desempeño");
        generarReporteBtn.setOnAction(e -> generarReporteDesempeno());

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(nombreLabel, 0, 0);
        grid.add(nombreField, 1, 0);

        grid.add(apellidoLabel, 0, 1);
        grid.add(apellidoField, 1, 1);

        grid.add(cedulaLabel, 0, 2);
        grid.add(cedulaField, 1, 2);

        grid.add(tipoLabel, 0, 3);
        grid.add(tipoCombo, 1, 3);

        grid.add(departamentoLabel, 0, 4);
        grid.add(departamentoCombo, 1, 4);

        grid.add(registrarBtn, 0, 5);
        grid.add(generarReporteBtn, 1, 5);

        Scene scene = new Scene(grid, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void generarReporteDesempeno() {
        if (empleados.isEmpty()) {
            mostrarAlerta("Sin Datos", "No hay empleados registrados para generar el reporte.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reporte_desempeno.txt"))) {
            for (String emp : empleados) {
                writer.write(emp);
                writer.newLine();
            }
            mostrarAlerta("Reporte Generado", "El reporte se ha guardado como 'reporte_desempeno.txt'.");
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo generar el reporte: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
