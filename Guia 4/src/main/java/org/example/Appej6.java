package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Appej6 extends Application {

    private ListView<String> taskListView;
    private TextField taskInputField;
    private List<String> tasks;
    private Label instructionLabel;

    @Override
    public void start(Stage primaryStage) {
        // Inicializar la lista de tareas
        tasks = new ArrayList<>();

        // Crear el campo de texto para ingresar el título de la tarea
        taskInputField = new TextField();
        taskInputField.setPromptText("Ingresa una tarea");

        // Crear el botón para agregar tareas
        Button addTaskButton = new Button("Agregar tarea");
        addTaskButton.setOnAction(event -> addTask());

        // Crear el botón para eliminar tareas
        Button deleteTaskButton = new Button("Eliminar tarea"); //setonaction registra un listener
        deleteTaskButton.setOnAction(event -> deleteTask()); //event -> el codigo que se va a ejecutar cuando s reciba el evento

        // Crear la lista de tareas (ListView)
        taskListView = new ListView<>();
        taskListView.setOnMouseClicked(event -> markTaskAsCompleted());

        // Crear la etiqueta de instrucciones
        instructionLabel = new Label("Haz clic en una tarea para completarla.");

        // Crear el contenedor (VBox) y agregar los elementos
        VBox layout = new VBox(10);
        layout.getChildren().addAll(taskInputField, addTaskButton, deleteTaskButton, instructionLabel, taskListView);

        // Crear la escena y configurar la ventana
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Lista de Tareas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para agregar una tarea a la lista
    private void addTask() {
        String task = taskInputField.getText().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            updateTaskList();
            taskInputField.clear();
        }
    }

    // Método para eliminar una tarea seleccionada
    private void deleteTask() {
        String selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            tasks.remove(selectedTask);
            updateTaskList();
        }
    }

    // Método para actualizar la lista de tareas en el ListView
    private void updateTaskList() {
        taskListView.getItems().clear();
        taskListView.getItems().addAll(tasks);
    }

    // Método para marcar una tarea como completada (al hacer clic sobre ella)
    private void markTaskAsCompleted() {
        String selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null && !selectedTask.contains("(Completada)")) {
            tasks.remove(selectedTask);
            tasks.add(selectedTask + " (Completada)");
            updateTaskList();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}