/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo_6;

import TDAs.Tree;
import TDAs.TreeNode;
import static Tablero.IA.generarTreeGeneral;
import static Tablero.IA.listaUtilidadesMinimas;
import Tablero.Tablero;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author demera
 */
public class Grupo_6 extends Application {
    Button b1=new Button("JUGAR");
    Button b2=new Button("EMPEZAR");
    Label l2=new Label("Modo");
    Label l3=new Label("Tres en Raya");
    VBox panel1 = new VBox();
    VBox panel2 = new VBox();
    VBox panel3 = new VBox();
    ComboBox combo1=new ComboBox();
    ObservableList list2 = panel2.getChildren();
    
    @Override
    public void start(Stage primaryStage) {
        panel1.setAlignment(Pos.CENTER);
        Label bienvenido=new Label("BIENVENIDO");
        b1.setAlignment(Pos.CENTER);
        ObservableList list = panel1.getChildren();
        panel1.setSpacing(10);
        list.addAll(bienvenido,b1);
        Scene scene = new Scene(panel1, 1100, 700);
        primaryStage.setTitle("Tres en Raya");
        primaryStage.setScene(scene);
        primaryStage.show();
        ventanaModo(primaryStage,b1);
    }
    
    public void ventanaModo(Stage s,Button b){
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                s.close();
                panel2.setSpacing(10);
                panel2.setAlignment(Pos.CENTER);
                list2.addAll(l2,b2);
                Scene scene2 = new Scene(panel2, 1100, 700);
                Stage s2=new Stage();
                s2.setScene(scene2);
                s2.show();
                ventanaUsuario(s2,b2);
            }
        });
    }
    
    public void ventanaUsuario(Stage s,Button b){
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                s.close();
                ObservableList list3 = panel3.getChildren();
                list3.addAll(l3);
                Scene scene3 = new Scene(panel3, 1100, 700);
                Stage s3=new Stage();
                s3.setScene(scene3);
                s3.show();
            }
        });
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Tablero tabl1= new Tablero();
//        ArrayList ar1= new ArrayList();
//        ar1.add(1);ar1.add(2);ar1.add(3);ar1.add(4);ar1.add(5);ar1.add(6);ar1.add(7);ar1.add(8);ar1.add(9);
        
        launch(args);

        ArrayList l1=new ArrayList();
        l1.add(1);l1.add(2);l1.add(1);l1.add(0);l1.add(1);l1.add(2);l1.add(0);l1.add(1);l1.add(0);
        
        Tree tre1= generarTreeGeneral(l1,  1);
        
//        System.out.println("PADRE");
//        System.out.println(tre1.getRoot().getContent());
//        
//        for(int i=0; i<tre1.getHijosLista().size(); i++){
//            System.out.println("HIJO"+(i+1));
//            System.out.println(tre1.getHijosLista().get(i).getContent());
//            
//            for(int e=0; e<tre1.getHijosLista().get(i).getHijos().size(); e++){
//                System.out.println("NIETO " +(e+1));
//                System.out.println(tre1.getHijosLista().get(i).getHijos().get(e).getContent());
//            }
//        }
        ArrayList ar=listaUtilidadesMinimas(tre1, 1);
        System.out.println(ar.toString());
    }
    
    
    
    
}
