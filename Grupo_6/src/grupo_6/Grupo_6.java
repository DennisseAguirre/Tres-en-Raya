/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo_6;

import Tablero.Tablero;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author demera
 */
public class Grupo_6 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox panel1 = new VBox();
        Scene scene = new Scene(panel1, 1100, 700);
        primaryStage.setTitle("Tres en Raya");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Tablero tabl1= new Tablero();
//        ArrayList ar1= new ArrayList();
//        ar1.add(1);ar1.add(2);ar1.add(3);ar1.add(4);ar1.add(5);ar1.add(6);ar1.add(7);ar1.add(8);ar1.add(9);
        
        launch(args);
        
//        System.out.println(tabl1.getTabla().toString());
//        
//        tabl1.setTabla(ar1);
//        System.out.println(tabl1.getTabla().toString());
//        System.out.println(tabl1.ganadorTabla());
    }
    
}
