package com.example.aname;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.control.*;
import java.io.File;
import javafx.stage.FileChooser;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Files;

public class HelloApplication extends Application {
    public static double scoreARI;
    @Override

    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 168);
        stage.setTitle("are u sure");
        ImageView background = new ImageView(new Image("file:download.jfif"));
        root.getChildren().add(background);
        Label label = new Label("no file open.");
        root.getChildren().add(label);
        label.setTextFill(Color.DARKGOLDENROD);
        label.setTranslateX(100);
        label.setTranslateY(10);
        Button button = new Button();
        button.setTranslateX(150);
        button.setTranslateY(84);
        FileChooser dumb = new FileChooser();
        dumb.setTitle("pick a file that has text you wanna know the readability of");
        FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("Text Files", "*.txt");
        dumb.getExtensionFilters().add(ex1);
        EventHandler<ActionEvent> event =
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        File file = dumb.showOpenDialog(stage);
                        String filePath = null;
                        if (file != null){
                            System.out.println("Open File");
                            try {
                                filePath = new Scanner(file).nextLine();
                            } catch (FileNotFoundException e) {
                            }

                        }
                        label.setText(file.getAbsolutePath()+ "   selected");
                        runReadabilityCalculator(filePath);

                        }

                };
        button.setOnAction(event);
        Button button1 = new Button("read tuah");
        root.getChildren().add(button1);
        button1.setTranslateY(84);
        Label read = new Label();
        root.getChildren().add(read);
        read.setText("score: ");
        read.setTextFill(Color.RED);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                read.setText("score: " + scoreARI);
                System.out.println("button pressed");

            }
        });
        root.getChildren().add(button);
        button.setText("Add a file");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:download.jfif"));
        stage.show();
    }
    public static void runReadabilityCalculator(String text) {
        try {
            int sentenceCount = text.split("[\\.\\?!][\\s]+").length;
            int wordCount = text.split("[\\s]+").length;
            int charCount = text.replaceAll("[\\s]+", "").length();
            System.out.println(sentenceCount + " " + wordCount + " " + charCount);

            // Assigning to the global static variable instead of creating a new local variable
            scoreARI = (4.71 * charCount / wordCount) +
                    (0.5 * wordCount / sentenceCount) - 21.43;

            System.out.println(scoreARI); // Printing the score for debugging
        } catch (ArithmeticException exception) {
            System.out.println("The code encountered an error!");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}