package sample;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;

// import java.awt.event.ActionEvent;
///

public class Main extends Application {

    private void writeHWMethod(ActionEvent actionEvent){
        System.out.println("Hallo World Method!");
    }

    private class hWWriter implements EventHandler<ActionEvent>{
        public void handle(ActionEvent actionEvent) {
            System.out.println("Hallo World Named Inner Class!");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // root.getChildrenUnmodifiable().add(button01);
        StackPane root = new StackPane();
        GridPane gridPane01 = new GridPane();
        gridPane01.setAlignment(Pos.CENTER);
        gridPane01.setHgap(50);
        gridPane01.setVgap(15);
        root.getChildren().add(gridPane01);
        // -----------------------------------------------------
        Button button01 = new Button();
        button01.setText("Write Hallo World Anonymous Inner Class");
        button01.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hallo World Anonymous Inner Class!");
            }
        });
        gridPane01.add(button01,0,0);
        // -----------------------------------------------------------------
        Button button02 = new Button();
        button02.setText("HW Lambda");
        button02.setOnAction(
                (ActionEvent actionEvent) -> {
                    System.out.println("Hallo World Lambda!");
                }
        );
        gridPane01.add(button02,0,4);
        // ----------------------------------------------------------------
        Button button03 = new Button();
        button03.setText("HW Method");
        button03.setOnAction(
                (ActionEvent aE) -> this.writeHWMethod(aE)
        );
        gridPane01.add(button03,0,8);
        // ----------------------------------------------------------------
        Button button04 = new Button();
        button04.setText("Write Hallo World Named Inner Class");
        button04.setOnAction(new hWWriter());
        gridPane01.add(button04,0,12);
        // -----------------------------------------------------------------
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
