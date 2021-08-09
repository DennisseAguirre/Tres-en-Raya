/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo_6;

import TDAs.Tree;
import TDAs.TreeNode;
import static Tablero.IA.*;
import Tablero.Tablero;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Grupo_6 extends Application {

    Button b1 = new Button("JUGAR");
    Button b2 = new Button("EMPEZAR");
    Button b3 = new Button("OK");
    Button b4 = new Button("COMENZAR");
    Label l2 = new Label("Modo");
    Label l3 = new Label("Tres en Raya");
    Label l4 = new Label("Seleccione si va a ser X o O: ");
    Label l5 = new Label("Seleccione si va a ser el 1 o 2 jugador: ");
    Label l6 = new Label("Seleccione modo: ");
    Label aviso2 = new Label("Usuario seleccione los datos que se le pida, por favor: ");
    Label aviso = new Label("Usuario tiene que seleccionar una opción, por favor: ");
    VBox panel1 = new VBox();
    VBox panel2 = new VBox();
    VBox panel3 = new VBox();
    ComboBox combo1 = new ComboBox();
    ComboBox combo2 = new ComboBox();
    ComboBox combo3 = new ComboBox();
    VBox panelxo = new VBox();
    VBox panel12 = new VBox();
    VBox paneljuego = new VBox();
    VBox panelmodo = new VBox();
    HBox fila1 = new HBox();
    HBox fila2 = new HBox();
    HBox fila3 = new HBox();
    ObservableList list2 = panel2.getChildren();
    ObservableList list3 = panel3.getChildren();
    ObservableList list4 = fila1.getChildren();
    ObservableList list5 = fila2.getChildren();
    ObservableList list6 = fila3.getChildren();
    ObservableList list7 = paneljuego.getChildren();
    ObservableList list8 = panelmodo.getChildren();

    Tree treeTablero = new Tree();
    ArrayList compara1 = new ArrayList();

    int ficha1 = 1;
    int ficha2 = 2;
    int turno = 7;
    boolean fin = false;

    @Override
    public void start(Stage primaryStage) {
        panel1.setStyle("-fx-background-color: BEIGE;");
        panel1.setAlignment(Pos.CENTER);
        Label bienvenido = new Label("BIENVENIDO");
        bienvenido.setStyle("-fx-alignment: center ");
        bienvenido.setStyle("-fx-font: normal bold 30px 'serif' ");
        b1.setAlignment(Pos.CENTER);
        l3.setStyle("-fx-alignment: center ");
        l3.setStyle("-fx-font: normal bold 30px 'serif' ");
        ObservableList list = panel1.getChildren();
        panel1.setSpacing(20);
        list.addAll(bienvenido, b1);
        Scene scene = new Scene(panel1, 500, 500);
        primaryStage.setTitle("Tres en Raya");
        primaryStage.setScene(scene);
        primaryStage.show();
        ventanaSeleccion(primaryStage, b1);
    }

    public void ventanaSeleccion(Stage s, Button b) {
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                s.close();
                llenarCombo3();
                panelmodo.setSpacing(40);
                panelmodo.setAlignment(Pos.CENTER);
                aviso.setVisible(false);
                list8.addAll(l6, combo3, b3, aviso);
                panelmodo.setStyle("-fx-background-color: BEIGE;");
                Scene scene4 = new Scene(panelmodo, 500, 500);
                Stage s4 = new Stage();
                s4.setScene(scene4);
                s4.show();
                ventanaModo(s4, b3);
            }
        });

    }

    public void ventanaModo(Stage s, Button b) {
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (combo3.getValue() == null) {
                    aviso.setVisible(true);
                } else if (combo3.getValue() == "Computadora vs Computadora") {
                    turno = 1;
                    s.close();
                    panelJuego();
                    panel3.setStyle("-fx-background-color: BEIGE;");
                    Scene scene3 = new Scene(panel3, 1100, 700);
                    Stage s3 = new Stage();
                    s3.setScene(scene3);
                    s3.show();
                } else if (combo3.getValue() == "Jugador vs Jugador") {
                    s.close();
                    llenarCombo1();
                    panel2.setSpacing(10);
                    panel2.setAlignment(Pos.CENTER);
                    panelxo.getChildren().addAll(l4);
                    panelxo.getChildren().addAll(combo1);
                    panelxo.setSpacing(20);
                    panelxo.setAlignment(Pos.CENTER);
                    aviso2.setVisible(false);
                    list2.addAll(panelxo, b4, aviso2);
                    panel2.setStyle("-fx-background-color: BEIGE;");
                    panel2.setSpacing(40);
                    Scene scene2 = new Scene(panel2, 500, 500);
                    Stage s2 = new Stage();
                    s2.setScene(scene2);
                    s2.show();
                    ventanaUsuario2(s2, b4);

                } else {
                    s.close();
                    llenarCombo1();
                    llenarCombo2();
                    panel2.setSpacing(10);
                    panel2.setAlignment(Pos.CENTER);
                    panelxo.getChildren().addAll(l4);
                    panelxo.getChildren().addAll(combo1);
                    panelxo.setSpacing(20);
                    panelxo.setAlignment(Pos.CENTER);
                    panel12.getChildren().addAll(l5);
                    panel12.getChildren().addAll(combo2);
                    panel12.setSpacing(20);
                    panel12.setAlignment(Pos.CENTER);
                    aviso2.setVisible(false);
                    list2.addAll(panelxo, panel12, b2, aviso2);
                    panel2.setStyle("-fx-background-color: BEIGE;");
                    panel2.setSpacing(40);
                    Scene scene2 = new Scene(panel2, 500, 500);
                    Stage s2 = new Stage();
                    s2.setScene(scene2);
                    s2.show();
                    ventanaUsuario(s2, b2);
                }
            }
        });
    }

    public void ventanaUsuario(Stage s, Button b) {
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (/*combo1.getValue() == null && combo2.getValue() == null ||*/combo1.getValue() == null || combo2.getValue() == null) {
                    aviso2.setVisible(true);

                } else {
                    if (combo1.getValue().equals("O")) {
                        ficha1 = 2;
                        ficha2 = 1;
                    }
                    if (combo2.getValue().equals("jugador 1")) {
                        turno = 1;
                    } else if (combo2.getValue().equals("jugador 2")) {
                        turno = 2;
                    }
                    s.close();
                    panel3.setStyle("-fx-background-color: BEIGE;");
                    panelJuego();
                    Scene scene3 = new Scene(panel3, 1100, 700);
                    Stage s3 = new Stage();
                    s3.setScene(scene3);
                    s3.show();
                }

            }
        });
    }

    public void ventanaUsuario2(Stage s, Button b) {
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (combo1.getValue() == null) {
                    aviso2.setVisible(true);

                } else {
                    if (combo1.getValue().equals("O")) {
                        ficha1 = 2;
                        ficha2 = 1;
                    }
                    s.close();
                    panel3.setStyle("-fx-background-color: BEIGE;");
                    panelJuego();
                    Scene scene5 = new Scene(panel3, 1100, 700);
                    Stage s5 = new Stage();
                    s5.setScene(scene5);
                    s5.show();
                }

            }
        });
    }

    public void llenarCombo1() {
        combo1.getItems().add(("X"));
        combo1.getItems().add(("O"));

    }

    public void llenarCombo2() {
        combo2.getItems().add(("jugador 1"));
        combo2.getItems().add(("jugador 2"));

    }

    public void llenarCombo3() {
        combo3.getItems().add(("Jugador vs Computadora"));
        combo3.getItems().add(("Jugador vs Jugador"));
        combo3.getItems().add(("Computadora vs Computadora"));

    }

    public void panelJuego() {
        Button bo1 = new Button(" ");
        Button bo2 = new Button(" ");
        Button bo3 = new Button(" ");
        Button bo4 = new Button(" ");
        Button bo5 = new Button(" ");
        Button bo6 = new Button(" ");
        Button bo7 = new Button(" ");
        Button bo8 = new Button(" ");
        Button bo9 = new Button(" ");
        panel3.setSpacing(50);
        panel3.setAlignment(Pos.CENTER);
        paneljuego.setAlignment(Pos.CENTER);
        fila1.setAlignment(Pos.CENTER);
        fila2.setAlignment(Pos.CENTER);
        fila3.setAlignment(Pos.CENTER);
        fila1.setSpacing(10);
        fila2.setSpacing(10);
        fila3.setSpacing(10);
        list4.addAll(bo1, bo2, bo3);
        list5.addAll(bo4, bo5, bo6);
        list6.addAll(bo7, bo8, bo9);
        list7.addAll(fila1, fila2, fila3);
        paneljuego.setSpacing(20);
        list3.addAll(l3, paneljuego);
        if (turno == 2) {
            turnoMaquina();
            System.out.println("Compara 1 " + compara1);
            actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
            System.out.println(treeTablero.getRoot().getContent());
        }
        bo1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(0) == 0&& fin == false) {
                    if (ficha1 == 1) {
                        bo1.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(0, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo1.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(0, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        bo2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(1) == 0&& fin == false) {
                    if (ficha1 == 1) {
                        bo2.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(1, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo2.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(1, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        bo3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(2) == 0 && fin == false) {
                    if (ficha1 == 1) {
                        bo3.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(2, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo3.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(2, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        bo4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(3) == 0 && fin == false) {
                    if (ficha1 == 1) {
                        bo4.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(3, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo4.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(3, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        bo5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(4) == 0 && fin == false) {
                    if (ficha1 == 1) {
                        bo5.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(4, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo5.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(4, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        bo6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(5) == 0 && fin == false) {
                    if (ficha1 == 1) {
                        bo6.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(5, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo6.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(5, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        bo7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(6) == 0 && fin == false) {
                    if (ficha1 == 1) {
                        bo7.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(6, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo7.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(6, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        bo8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(7) == 0 && fin == false) {
                    if (ficha1 == 1) {
                        bo8.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(7, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo8.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(7, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        bo9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(8) == 0 && fin == false) {
                    if (ficha1 == 1) {
                        bo9.setText("X");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(8, 1);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    } else if (ficha1 == 2) {
                        bo9.setText("O");
                        ArrayList ar = new ArrayList();
                        ar.addAll(treeTablero.getRoot().getContent());
                        ar.set(8, 2);
                        TreeNode tn1 = new TreeNode(ar);
                        treeTablero = new Tree(tn1);
                    }
                    System.out.println(treeTablero.getRoot().getContent());
                    checkWin(treeTablero.getRoot().getContent());
                    if (fin == false) {
                        System.out.println("Turno Maquina");
                        turnoMaquina();
                        System.out.println("Compara 1 " + compara1);
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                        System.out.println(treeTablero.getRoot().getContent());
                    }
                }
            }
        });
        
    }

    public void checkWin(ArrayList<Integer> ar) { //REVISAR
        Tablero tabla = new Tablero(ar);
        int win = tabla.ganadorTabla();
        String mensaje="";
        if (win == 1) {
            if (ficha1 == 1) {
                mensaje="GANASTE";
                
            } else {
                mensaje="PERDISTE";
                
            }
            fin=true;
        } else if (win == 2) {
            if (ficha1 == 2) {
                 mensaje="GANASTE";
            } else {
                 mensaje="PERDISTE";
            }
            fin=true;
        } else if (win == 0) {
            mensaje="EMPATE";
            fin=true;
        } else {
            mensaje="El juego sigue";
        }
        if(mensaje!="El juego sigue"){
            Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
                dialogo.setTitle("Resultado");
                dialogo.setHeaderText("Resultado");
                dialogo.setContentText(mensaje);
                dialogo.initStyle(StageStyle.UTILITY);
                dialogo.showAndWait();
        
        }
         
    }

    public void turnoMaquina() {
        TreeNode tn1 = calificarUtilidadMaxima(generarTreeGeneral(treeTablero.getRoot().getContent(), ficha2), ficha2);
        compara1.clear();
        compara1.addAll(treeTablero.getRoot().getContent());
        System.out.println("Compara1: " + compara1);
        treeTablero = new Tree(tn1);
        System.out.println("Tree tras Turno maquina" + treeTablero.getRoot().getContent());
        checkWin(treeTablero.getRoot().getContent());

    }

    public void actualizacionForzada(Button bo1, Button bo2, Button bo3, Button bo4, Button bo5, Button bo6, Button bo7, Button bo8, Button bo9, ArrayList compara1) {
        System.out.println(compara1);
        if (compara1.get(0) != treeTablero.getRoot().getContent().get(0)) {
            if (ficha1 == 1) {
                bo1.setText("O");
            } else if (ficha1 == 2) {
                bo1.setText("X");
            }
        }
        if (compara1.get(1) != treeTablero.getRoot().getContent().get(1)) {
            if (ficha1 == 1) {
                bo2.setText("O");
            } else if (ficha1 == 2) {
                bo2.setText("X");
            }
        }
        if (compara1.get(2) != treeTablero.getRoot().getContent().get(2)) {
            if (ficha1 == 1) {
                bo3.setText("O");
            } else if (ficha1 == 2) {
                bo3.setText("X");
            }
        }
        if (compara1.get(3) != treeTablero.getRoot().getContent().get(3)) {
            if (ficha1 == 1) {
                bo4.setText("O");
            } else if (ficha1 == 2) {
                bo4.setText("X");
            }
        }
        if (compara1.get(4) != treeTablero.getRoot().getContent().get(4)) {
            if (ficha1 == 1) {
                bo5.setText("O");
            } else if (ficha1 == 2) {
                bo5.setText("X");
            }
        }
        if (compara1.get(5) != treeTablero.getRoot().getContent().get(5)) {
            if (ficha1 == 1) {
                bo6.setText("O");
            } else if (ficha1 == 2) {
                bo6.setText("X");
            }
        }
        if (compara1.get(6) != treeTablero.getRoot().getContent().get(6)) {
            if (ficha1 == 1) {
                bo7.setText("O");
            } else if (ficha1 == 2) {
                bo7.setText("X");
            }
        }
        if (compara1.get(7) != treeTablero.getRoot().getContent().get(7)) {
            if (ficha1 == 1) {
                bo8.setText("O");
            } else if (ficha1 == 2) {
                bo8.setText("X");
            }
        }
        if (compara1.get(8) != treeTablero.getRoot().getContent().get(8)) {
            if (ficha1 == 1) {
                bo9.setText("O");
            } else if (ficha1 == 2) {
                bo9.setText("X");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Tablero tabl1= new Tablero();
//        ArrayList ar1= new ArrayList();
//        ar1.add(1);ar1.add(2);ar1.add(3);ar1.add(4);ar1.add(5);ar1.add(6);ar1.add(7);ar1.add(8);ar1.add(9);

        launch(args);

        //Estacion  de pruebas, no molestar
        ArrayList l1 = new ArrayList();
        l1.add(1);
        l1.add(2);
        l1.add(1);
        l1.add(0);
        l1.add(1);
        l1.add(2);
        l1.add(0);
        l1.add(1);
        l1.add(0);

        Tree tre1 = generarTreeGeneral(l1, 1);

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
        /*ArrayList ar = listaUtilidadesMinimas(tre1, 1);

        System.out.println(ar.toString());
        TreeNode tn3 = calificarUtilidadMaxima(tre1, 1);
        System.out.println(tn3.getContent().toString());*/
    }

}
