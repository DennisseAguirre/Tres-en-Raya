/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

import TDAs.Tree;
import TDAs.TreeNode;
import java.util.ArrayList;
import java.util.Collections;

public class IA {

    //Mini Max
    // Metodo que genera el arbol general de tres en raya.
    public static Tree generarTreeGeneral(ArrayList<Integer> list1, int ficha1) {
        int ficha2 = 1;
        if (ficha1 == 1) {
            ficha2 = 2;
        } else {
            ficha2 = 1;
        }
        TreeNode nodo1 = new TreeNode(list1);
        nodo1.generarHijos(ficha1);
        for (int i = 0; i <= nodo1.getHijos().size() - 1; i++) {
            nodo1.getHijos().get(i).generarHijos(ficha2);
        }
        Tree tre1 = new Tree(nodo1);

        return tre1;
    }

    //Metodo que sirve para escoger al tablero que garantiza la mayor utilidad
    public static TreeNode calificarUtilidadMaxima(Tree tre1, int ficha1) {
        ArrayList<Integer> listaUtilidad = listaUtilidadesMinimas(tre1, ficha1);
        if (listaUtilidad.isEmpty()) {
            return null;
        }

        int index = 0;
        int a = listaUtilidad.get(0);
        for (int i = 0; i < listaUtilidad.size(); i++) {
            if (a < listaUtilidad.get(i)) {
                a = listaUtilidad.get(i);
                index = i;
            }
        }
        return (tre1.getHijosLista().get(index));
    }
    // Metodo que devuelve un ArrayList con la lista de utilidades minimas
    public static ArrayList listaUtilidadesMinimas(Tree tre1, int ficha1) {
        ArrayList listaUti = new ArrayList();
        for (int i = 0; i < tre1.getHijosLista().size(); i++) {
            ArrayList<Integer> UtiTemp = new ArrayList();
            for (int e = 0; e < tre1.getHijosLista().get(i).getHijos().size(); e++) {
                int temp = calcularUtilidades(tre1.getHijosLista().get(i).getHijos().get(e).getContent(), ficha1);
                UtiTemp.add(temp);
            }
            if (!UtiTemp.isEmpty()) {
                Integer min = UtiTemp.get(0);
                for (int e = 1; e < UtiTemp.size(); e++) {
                    if (UtiTemp.get(e) < min) {
                        min = UtiTemp.get(e);
                    }
                }
                listaUti.add(min);
            }
        }
        return listaUti;
    }
    // Metodo que calcula la utilidad de un tablero
    public static int calcularUtilidades(ArrayList lista1, int ficha1) {
        int ficha2 = 1;
        if (ficha1 == 1) {
            ficha2 = 2;
        }

        int utiCasa = 0;

        utiCasa = +calcularUtilidadesPeroEstaVezSi(lista1, ficha1);

        int utiVisita = 0;

        utiVisita = +calcularUtilidadesPeroEstaVezSi(lista1, ficha2);

        int utiTot = utiCasa - utiVisita;
        return utiTot;
    }
    // Metodo que calcula el  número total de filas, columnas y diagonales disponibles en el tablero para el jugador correspondiente.
    public static int calcularUtilidadesPeroEstaVezSi(ArrayList<Integer> lista1, int ficha1) {
        int ficha2 = 1;
        if (ficha1 == 1) {
            ficha2 = 2;
        }

        int uti = 0;

        if (lista1.get(0) != ficha2 && lista1.get(1) != ficha2 && lista1.get(2) != ficha2) {
            uti = uti + 1;
        }
        if (lista1.get(3) != ficha2 && lista1.get(4) != ficha2 && lista1.get(5) != ficha2) {
            uti = uti + 1;
        }
        if (lista1.get(6) != ficha2 && lista1.get(7) != ficha2 && lista1.get(8) != ficha2) {
            uti = uti + 1;
        }

        if (lista1.get(0) != ficha2 && lista1.get(3) != ficha2 && lista1.get(6) != ficha2) {
            uti = uti + 1;
        }
        if (lista1.get(1) != ficha2 && lista1.get(4) != ficha2 && lista1.get(7) != ficha2) {
            uti = uti + 1;
        }
        if (lista1.get(2) != ficha2 && lista1.get(5) != ficha2 && lista1.get(8) != ficha2) {
            uti = uti + 1;
        }

        if (lista1.get(0) != ficha2 && lista1.get(4) != ficha2 && lista1.get(8) != ficha2) {
            uti = uti + 1;
        }
        if (lista1.get(2) != ficha2 && lista1.get(4) != ficha2 && lista1.get(6) != ficha2) {
            uti = uti + 1;
        }
        return uti;
    }
    
    //public static ArrayList intermediosDeArbol 
/*
    public static Tree generarSuperTree(Tree treeTablero, int ficha1, int turno) {
        
        if (turno == 1) {
            int ficha2 = 1;
            if (ficha1 == 1) {
                ficha2 = 2;
            } else {
                ficha2 = 1;
            }
        }else{
            
        }

        TreeNode nodo1 = new TreeNode(list1);
        nodo1.generarHijos(ficha1);
        for (int i = 0; i <= nodo1.getHijos().size() - 1; i++) {
            System.out.println(i);
            nodo1.getHijos().get(i).generarHijos(ficha2);
        }
        Tree tre1 = new Tree(nodo1);

        return tre1;
    }*/
}
