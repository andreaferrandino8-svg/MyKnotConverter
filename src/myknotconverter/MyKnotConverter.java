/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package myknotconverter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author andre
 */
public class MyKnotConverter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        TextField input = new TextField();
        
        Label symbols = new Label();
        
        Label display = new Label();
        
        Button reset = new Button();
        
        reset.setText("C");
        
        symbols.setText("km/h ---> kts");
        
        input.setPrefColumnCount(7);
        
        
        HBox root = new HBox();
        root.getChildren().addAll(input,symbols,display,reset);
        
        root.setSpacing(15);
        
        root.setAlignment(Pos.CENTER);
        
        DoubleProperty inputValue = new SimpleDoubleProperty();
        
        StringConverter dsc = new DoubleStringConverter();
        
        
        Bindings.bindBidirectional(input.textProperty(), inputValue,dsc);
        
        NumberBinding output = inputValue.divide(1.852);
        
        display.textProperty().bind(output.asString("%.2f"));
        
        reset.setOnAction(e -> {
            inputValue.set(0);
        });
        
        
        //root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("MyKnot Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
