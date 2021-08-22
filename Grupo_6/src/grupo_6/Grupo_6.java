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
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JOptionPane;

public class Grupo_6 extends Application {
    // Algunos elementos importantes para los paneles
    Button b1 = new Button("JUGAR");
    Button b2 = new Button("EMPEZAR");
    Button b3 = new Button("OK");
    Button b4 = new Button("COMENZAR");
    Button tablerocomp = new Button("mostrar tableros");
    Button salir = new Button("Salir");
    Button reiniciar = new Button("Reiniciar");
    Button comodin = new Button("Comodin");
    Button verTiradas = new Button("Ver tiradas");
    Label l2 = new Label("Modo");
    Label l3 = new Label("Tres en Raya");
    Label l4 = new Label("Seleccione si va a ser X o O: ");
    Label l5 = new Label("Seleccione si va a ser el 1 o 2 jugador: ");
    Label l6 = new Label("Seleccione modo: ");
    Label aviso2 = new Label("Usuario seleccione los datos que se le pida, por favor: ");
    Label aviso = new Label("Usuario tiene que seleccionar una opciÃ³n, por favor: ");
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
    HBox hbox1 = new HBox();
    HBox hbox2 = new HBox();
    VBox supraBox = new VBox();
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
    boolean contadorTurno = true;
    boolean pvpON = false;
    boolean cpuvcpuON = false;

    ArrayList utilidades = new ArrayList();

    @Override
    public void start(Stage primaryStage) {
        panel1.setStyle("-fx-background-color: BEIGE;");
        ventanatablero();
        verTiradasON();
        comodinON();
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
        // Esceneario de la ventana principal
        Scene scene = new Scene(panel1, 500, 500);
        primaryStage.setTitle("Tres en Raya");
        primaryStage.setScene(scene);
        primaryStage.show();
        ventanaSeleccion(primaryStage, b1, salir);
        supraBox.setSpacing(30);
    }
   
    // Metodo que abre otra ventana que le permite al usuario elegir el modo de juego 
    public void ventanaSeleccion(Stage s, Button b, Button salir) {
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
        });
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                s.close();
                llenarCombo3();
                panelmodo.setSpacing(40);
                panelmodo.setAlignment(Pos.CENTER);
                aviso.setVisible(false);
                list8.addAll(l6, combo3, b3, salir, aviso);
                panelmodo.setStyle("-fx-background-color: BEIGE;");
                Scene scene4 = new Scene(panelmodo, 500, 500);
                Stage s4 = new Stage();
                s4.setScene(scene4);
                s4.show();
                ventanaModo(s4, b3);
            }
        });

    }
    // Metodo que abre una ventana , dependiendo del modo que eligio el cliente
    public void ventanaModo(Stage s, Button b) {
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
        });
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (combo3.getValue() == null) {
                    aviso.setVisible(true);
                } else if (combo3.getValue() == "Computadora vs Computadora") {
                    cpuvcpuON = true;
                    turno = 47;
                    s.close();
                    panelJuego();
                    panel3.setStyle("-fx-background-color: BEIGE;");
                    Scene scene3 = new Scene(panel3, 1100, 700);
                    Stage s3 = new Stage();
                    s3.setScene(scene3);
                    s3.show();
                } else if (combo3.getValue() == "Jugador vs Jugador") {
                    //pvpON=true;
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
                    list2.addAll(panelxo, panel12, b2, salir, aviso2);
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
    
    // Metodo que abre otra ventana, en donde el usuario señala si es el 1 o 2 jugador y también si es O o X
    public void ventanaUsuario(Stage s, Button b) {
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
        });

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
                        contadorTurno = true;
                    } else if (combo2.getValue().equals("jugador 2")) {
                        turno = 2;
                        contadorTurno = false;
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
    // Metodo que abre otra ventana de usuario parecida a la anterior, pero solo si eligio la opcion jugador vs jugador
    public void ventanaUsuario2(Stage s, Button b) {
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
        });
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

    // Método que llenar el combo 1 con las dos opciones de letras que acepta el juego
    public void llenarCombo1() {
        combo1.getItems().add(("X"));
        combo1.getItems().add(("O"));

    }

    // Método que llena el combo 2 para que el usuario decida que jugador es.
    public void llenarCombo2() {
        combo2.getItems().add(("jugador 1"));
        combo2.getItems().add(("jugador 2"));

    }
    // Método que llena el combo 3 , con los modos de juegos que existen en el programa
    public void llenarCombo3() {
        combo3.getItems().add(("Jugador vs Computadora"));
        combo3.getItems().add(("Jugador vs Jugador"));
        combo3.getItems().add(("Computadora vs Computadora"));

    }
    // Método que abre la ventana en donde se desarrolla el juego Tres en Raya
    public void panelJuego() {
        rellenarVBox();
        reiniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Volvamos a empezar");
                try {
                    restartApplication();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Grupo_6.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Grupo_6.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
        // Agregando botones a las filas para formar el tres en raya
        list4.addAll(bo1, bo2, bo3);
        list5.addAll(bo4, bo5, bo6);
        list6.addAll(bo7, bo8, bo9);
        list7.addAll(fila1, fila2, fila3);
        paneljuego.setSpacing(20);
        HBox paneloption = new HBox();
        paneloption.getChildren().addAll(comodin, reiniciar, verTiradas);
        paneloption.setAlignment(Pos.CENTER);
        paneloption.setSpacing(10);
        list3.addAll(l3, tablerocomp, paneljuego, salir, paneloption, hbox1, hbox2);
        //Si el jugador va segundo la maquina empieza
        if (turno == 2) {
            turnoMaquina();
            actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
        }
        //Las acciones de los botones al presionarlos para que estos cambien por X u O.
        bo1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(0) == 0 && fin == false) {
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);

                    }
                }
            }
        });
        bo2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().getContent().get(1) == 0 && fin == false) {
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
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
                    rellenarVBox();
                    checkWin(treeTablero.getRoot().getContent());
                    if (turno == 7) {
                        if (ficha1 == 1) {
                            ficha1 = 2;
                            ficha2 = 1;
                        } else if (ficha1 == 2) {
                            ficha1 = 1;
                            ficha2 = 2;
                        }
                        pvpON = true;
                    } else if (fin == false) {
                        turnoMaquina();
                        actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
                    }
                }
            }
        });
        //Metodo que se ejectua cuando se esta en modo computadora vs computadora
        if (turno == 47) {
            while (fin == false) {
                if (ficha1 == 2) {
                    ficha2 = 2;
                    ficha1 = 1;
                } else if (ficha1 == 1) {
                    ficha2 = 1;
                    ficha1 = 2;
                }
                turnoMaquina();
                actualizacionForzada(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9, compara1);
            }
        }
    }

    //Metodo que revisa si la partida ha terminado, y si ya aha terminado revisa
    //quien es el ganador
    public void checkWin(ArrayList<Integer> ar) { //REVISAR
        Tablero tabla = new Tablero(ar);
        int win = tabla.ganadorTabla();
        String mensaje = "";

        if (turno == 7) {
            if (win == 1) {
                if (ficha1 == 1) {
                    mensaje = "GANARON LAS X";

                } else {
                    mensaje = "GANARON LAS O";

                }
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else if (win == 2) {
                if (ficha1 == 2) {
                    mensaje = "GANARON LAS O";
                } else {
                    mensaje = "GANARON LAS X";
                }
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else if (win == 0) {
                mensaje = "EMPATE";
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else {
                mensaje = "El juego sigue";
            }
            if (mensaje
                    != "El juego sigue") {
                Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
                dialogo.setTitle("Resultado");
                dialogo.setHeaderText("Resultado");
                dialogo.setContentText(mensaje);
                dialogo.initStyle(StageStyle.UTILITY);
                dialogo.showAndWait();

            }
        } else if (turno == 47) {
            if (win == 1) {
                if (ficha2 == 1) {
                    mensaje = "GANARON LAS X";

                } else {
                    mensaje = "GANARON LAS O";
                }
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else if (win == 2) {
                if (ficha2 == 2) {
                    mensaje = "GANARON LAS O";
                } else {
                    mensaje = "GANARON LAS X";
                }
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else if (win == 0) {
                mensaje = "EMPATE";
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else {
                mensaje = "El juego sigue";
            }
            if (mensaje
                    != "El juego sigue") {
                Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
                dialogo.setTitle("Resultado");
                dialogo.setHeaderText("Resultado");
                dialogo.setContentText(mensaje);
                dialogo.initStyle(StageStyle.UTILITY);
                dialogo.showAndWait();

            }
        } else {
            if (win == 1) {
                if (ficha1 == 1) {
                    mensaje = "GANASTE";

                } else {
                    mensaje = "PERDISTE";

                }
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else if (win == 2) {
                if (ficha1 == 2) {
                    mensaje = "GANASTE";
                } else {
                    mensaje = "PERDISTE";
                }
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else if (win == 0) {
                mensaje = "EMPATE";
                fin = true;
                comodin.setVisible(false);
                verTiradas.setVisible(false);
                hbox1.setVisible(false);
                hbox2.setVisible(false);
            } else {
                mensaje = "El juego sigue";
            }
            if (mensaje
                    != "El juego sigue") {
                Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
                dialogo.setTitle("Resultado");
                dialogo.setHeaderText("Resultado");
                dialogo.setContentText(mensaje);
                dialogo.initStyle(StageStyle.UTILITY);
                dialogo.showAndWait();

            }
        }
    }

    //Las acciones que la maquina realizara durante su turno
    public void turnoMaquina() {
        if (treeTablero.getRoot().contarCeros() == 1) {
            ArrayList ar = new ArrayList();
            for (int i = 0; i < treeTablero.getContent().size(); i++) {
                if (treeTablero.getContent().get(i) == 0) {
                    if (ficha2 == 1) {
                        ar.add(1);
                    } else {
                        ar.add(2);
                    }
                } else {
                    ar.add(treeTablero.getContent().get(i));
                }
            }
            utilidades.clear();
            posiblesJugadas(generarTreeGeneral(treeTablero.getRoot().getContent(), ficha2));
            TreeNode tn1 = new TreeNode(ar);

            compara1.clear();
            compara1.addAll(treeTablero.getRoot().getContent());
            treeTablero = new Tree(tn1);
            rellenarVBox();
        } else {
            TreeNode tn1 = calificarUtilidadMaxima(generarTreeGeneral(treeTablero.getRoot().getContent(), ficha2), ficha2);
            utilidades = listaUtilidadesMinimas(generarTreeGeneral(treeTablero.getRoot().getContent(), ficha2), ficha2);
            posiblesJugadas(generarTreeGeneral(treeTablero.getRoot().getContent(), ficha2));
            compara1.clear();
            compara1.addAll(treeTablero.getRoot().getContent());

            treeTablero = new Tree(tn1);
            rellenarVBox();
        }

    }

    //Metodo que sirve para actualizar los botones que componen el 3 en raya, 
    //para que simpre se aprecie en la interfaz como se ve el tablero.
    public void actualizacionForzada(Button bo1, Button bo2, Button bo3, Button bo4, Button bo5, Button bo6, Button bo7, Button bo8, Button bo9, ArrayList compara1) {
        if (turno == 47) {
            if (compara1.get(0) != treeTablero.getRoot().getContent().get(0)) {
                if (ficha2 == 1) {
                    bo1.setText("O");
                } else if (ficha2 == 2) {
                    bo1.setText("X");
                }
            }
            if (compara1.get(1) != treeTablero.getRoot().getContent().get(1)) {
                if (ficha2 == 1) {
                    bo2.setText("O");
                } else if (ficha2 == 2) {
                    bo2.setText("X");
                }
            }
            if (compara1.get(2) != treeTablero.getRoot().getContent().get(2)) {
                if (ficha2 == 1) {
                    bo3.setText("O");
                } else if (ficha2 == 2) {
                    bo3.setText("X");
                }
            }
            if (compara1.get(3) != treeTablero.getRoot().getContent().get(3)) {
                if (ficha2 == 1) {
                    bo4.setText("O");
                } else if (ficha2 == 2) {
                    bo4.setText("X");
                }
            }
            if (compara1.get(4) != treeTablero.getRoot().getContent().get(4)) {
                if (ficha2 == 1) {
                    bo5.setText("O");
                } else if (ficha2 == 2) {
                    bo5.setText("X");
                }
            }
            if (compara1.get(5) != treeTablero.getRoot().getContent().get(5)) {
                if (ficha2 == 1) {
                    bo6.setText("O");
                } else if (ficha2 == 2) {
                    bo6.setText("X");
                }
            }
            if (compara1.get(6) != treeTablero.getRoot().getContent().get(6)) {
                if (ficha2 == 1) {
                    bo7.setText("O");
                } else if (ficha2 == 2) {
                    bo7.setText("X");
                }
            }
            if (compara1.get(7) != treeTablero.getRoot().getContent().get(7)) {
                if (ficha2 == 1) {
                    bo8.setText("O");
                } else if (ficha2 == 2) {
                    bo8.setText("X");
                }
            }
            if (compara1.get(8) != treeTablero.getRoot().getContent().get(8)) {
                if (ficha2 == 1) {
                    bo9.setText("O");
                } else if (ficha2 == 2) {
                    bo9.setText("X");
                }
            }
        }
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
        checkWin(treeTablero.getRoot().getContent());
    }

    //Metodo que muestra en la interfaz los posibles movimientos que podria 
    //hacer la computadora, junto con el numero de utilidad de cada escenario.
    public void posiblesJugadas(Tree tre1) {
        hbox1.getChildren().clear();
        hbox2.getChildren().clear();
        ObservableList a = hbox1.getChildren();
        ObservableList b = hbox2.getChildren();
        hbox1.setSpacing(30);
        Label lista = new Label();
        ArrayList<TreeNode> ar = tre1.getRoot().getHijos();
        for (int i = 0; i < ar.size(); i++) {
            Label c = tablerolabel(ar.get(i).getContent());
            a.addAll(c);
        }
        lista.setText(utilidades.toString());
        Label c2=new Label();
        c2.setText("La lista de utilidades es la siguiente: ");
        b.addAll(c2, lista);
    }
    // Método que agrega los tableros que usa la computadora al momento de jugar.
    public void rellenarVBox() {
        HBox hbox = new HBox();
        hbox.setSpacing(30);
        Label c1 = tablerolabel(treeTablero.getRoot().getContent());
        c1.setStyle("-fx-background-color: aqua;");
        hbox.getChildren().add(c1);
        Tree tre1 = new Tree();
        if (contadorTurno == true && pvpON == false && cpuvcpuON == false) {
            tre1 = generarTreeGeneral(treeTablero.getRoot().getContent(), ficha1);
            contadorTurno = false;
        } else if (contadorTurno == false && pvpON == false && cpuvcpuON == false) {
            tre1 = generarTreeGeneral(treeTablero.getRoot().getContent(), ficha2);
            contadorTurno = true;
        } else if (pvpON == true && cpuvcpuON == false) {
            tre1 = generarTreeGeneral(treeTablero.getRoot().getContent(), ficha2);

        } else if (contadorTurno == true && cpuvcpuON == true) {
            tre1 = generarTreeGeneral(treeTablero.getRoot().getContent(), 1);
            contadorTurno = false;
        } else {
            tre1 = generarTreeGeneral(treeTablero.getRoot().getContent(), 2);
            contadorTurno = true;
        }

        ArrayList<TreeNode> ar = tre1.getRoot().getHijos();
        for (int i = 0; i < ar.size(); i++) {
            Label c2 = tablerolabel(ar.get(i).getContent());
            hbox.getChildren().add(c2);
        }
        supraBox.getChildren().add(hbox);
    }

    //FUNCIONALIDAD EXTRA: Metodo que permita, al tocar el boton verTiradas, 
    //visualizar las posibles jugadas que puede hacer el jugador, junto a su
    //numero de utilidad.
    public void verTiradasON() {
        verTiradas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hbox1.getChildren().clear();
                hbox2.getChildren().clear();
                ObservableList a = hbox1.getChildren();
                ObservableList b = hbox2.getChildren();
                hbox1.setSpacing(30);
                Label lista = new Label();
                ArrayList<TreeNode> ar = generarTreeGeneral(treeTablero.getRoot().getContent(), ficha1).getRoot().getHijos();
                for (int i = 0; i < ar.size(); i++) {
                    Label c = tablerolabel(ar.get(i).getContent());
                    a.addAll(c);
                }
                ArrayList utilidadesTemp = listaUtilidadesMinimas(generarTreeGeneral(treeTablero.getRoot().getContent(), ficha1), ficha1);
                lista.setText(utilidadesTemp.toString());
                Label c2=new Label();
                c2.setText("La lista de utilidades es la siguiente: ");
                b.addAll(c2, lista);
            }
        });
    }

    //Metodo que permite que cuandos e presione el boton comodin se vea en la 
    //interfaz el mejor tablero segun su utilidad
    public void comodinON() {
        comodin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treeTablero.getRoot().contarCeros() != 1) {
                    hbox1.getChildren().clear();
                    hbox2.getChildren().clear();
                    ObservableList a = hbox1.getChildren();
                    ObservableList b = hbox2.getChildren();
                    hbox1.setSpacing(30);
                    Label lista = new Label();
                    TreeNode tn1 = calificarUtilidadMaxima(generarTreeGeneral(treeTablero.getRoot().getContent(), ficha1), ficha1);
                    Label c = tablerolabel(tn1.getContent());
                    Label c2 = new Label();
                    c2.setText("El tablero con mayor utilidad es este: ");
                    a.addAll(c2, c);
                    lista.setText("Buena suerte!");
                    b.addAll(lista);
                } else {
                    hbox1.getChildren().clear();
                    hbox2.getChildren().clear();
                    ObservableList a = hbox1.getChildren();
                    ObservableList b = hbox2.getChildren();
                    hbox1.setSpacing(30);
                    Label lista = new Label();
                    ArrayList ar = new ArrayList();
                    for (int i = 0; i < treeTablero.getContent().size(); i++) {
                        if (treeTablero.getContent().get(i) == 0) {
                            if (ficha1 == 1) {
                                ar.add(1);
                            } else {
                                ar.add(2);
                            }
                        } else {
                            ar.add(treeTablero.getContent().get(i));
                        }
                    }
                    Label c = tablerolabel(ar);
                    Label c2 = new Label();
                    c2.setText("El tablero con mayor utilidad es este: ");
                    a.addAll(c2, c);
                    lista.setText("Buena suerte!");
                    b.addAll(lista);
                }

            }
        });
    }
    // Método que abre una ventana al aplastar el boton "Mostrar Tableros",en donde se puede ver los tableros que generó la máquina.
    public void ventanatablero() {
        tablerocomp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox layout = supraBox;
                layout.setSpacing(10);
                ObservableList panelt = layout.getChildren();
                Stage sta = new Stage();
                layout.setStyle("-fx-background-color: BEIGE;");
                Scene escena = new Scene(layout, 900, 700);
                sta.setScene(escena);
                sta.show();
                tablerocomp.setVisible(false);
            }
        });
    }

    //Metodo que genera una label que representa el tablero de tres en raya
    public Label tablerolabel(ArrayList<Integer> a) {
        String cadena1 = "";
        String cadena2 = "";
        String cadena3 = "";
        Label l = new Label("");
        for (int i = 0; i < a.size(); i++) {
            if (i >= 0 && i <= 2) {
                if (a.get(i) == 0) {
                    cadena1 += " |_| ";
                }
                if (a.get(i) == 1) {
                    cadena1 += " |X| ";
                }
                if (a.get(i) == 2) {
                    cadena1 += " |O| ";
                }
            }
            if (i >= 3 && i <= 5) {
                if (a.get(i) == 0) {
                    cadena2 += " |_| ";
                }
                if (a.get(i) == 1) {
                    cadena2 += " |X| ";
                }
                if (a.get(i) == 2) {
                    cadena2 += " |O| ";
                }
            }
            if (i >= 6) {
                if (a.get(i) == 0) {
                    cadena3 += " |_| ";
                }
                if (a.get(i) == 1) {
                    cadena3 += " |X| ";
                }
                if (a.get(i) == 2) {
                    cadena3 += " |O| ";
                }
            }
        }
        l.setText(cadena1 + "\n" + cadena2 + "\n" + cadena3);
        return l;
    }

    // Metodo que reinicia la aplicacion
    public static void restartApplication() throws URISyntaxException, IOException {
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        final File currentJar = new File(Grupo_6.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        if (!currentJar.getName().endsWith(".jar")) {
            return;
        }
        final ArrayList<String> command = new ArrayList<String>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        final ProcessBuilder builder = new ProcessBuilder((List<String>) command);
        builder.start();
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       

        launch(args);

        
    }

}
