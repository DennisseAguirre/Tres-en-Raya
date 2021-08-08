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
    public static Tree generarTreeGeneral(ArrayList<Integer> list1, int ficha1) {
        int ficha2 = 1;
        if (ficha1 == 1) {
            ficha2 = 2;
        }
        TreeNode nodo1 = new TreeNode(list1);
        nodo1.generarHijos(ficha1);
        for (int i = 0; i <= nodo1.getHijos().size() - 1; i++) {
            nodo1.getHijos().get(i).generarHijos(ficha2);
        }
        Tree tre1 = new Tree(nodo1);

        return tre1;
    }

    //UTILIDADES
    public static ArrayList listaUtilidadesMinimas(Tree tre1, int ficha1) {
        ArrayList listaUti = new ArrayList();
        for (int i = 0; i < tre1.getHijosLista().size(); i++) {
            ArrayList<Integer> UtiTemp = new ArrayList();
            for (int e = 0; e < tre1.getHijosLista().get(i).getHijos().size(); e++) {
                System.out.println(tre1.getHijosLista().get(i).getHijos().get(e).getContent());
                int temp = calcularUtilidades(tre1.getHijosLista().get(i).getHijos().get(e).getContent(), ficha1);
                UtiTemp.add(temp);
            }
            System.out.println(UtiTemp);
            Integer min = Collections.min(UtiTemp);
            listaUti.add(min);
        }
        return listaUti;
    }

//    public static int calcularUtilidadesMinimas(TreeNode nodo1, int ficha1) {
//        ArrayList<Integer> aList1 = new ArrayList();
//        System.out.println(nodo1.getContent());
//        for (int i = 0; i < nodo1.getContent().size(); i++) {
//            System.out.println("Xd");
//            int temp = calcularUtilidades(nodo1.getContent(), ficha1);
//            aList1.add(temp);
//        }
//        Integer min = aList1.get(0);
//        return min;
//    }

    public static int calcularUtilidades(ArrayList lista1, int ficha1) {
        int ficha2 = 1;
        if (ficha1 == 1) {
            ficha2 = 2;
        }

        int utiCasa = 0;
        for (int i = 0; i < lista1.size(); i++) {
            utiCasa = +calcularUtilidadesPeroEstaVezSi(lista1, ficha1);
        }
        int utiVisita = 0;
        for (int i = 0; i < lista1.size(); i++) {
            utiVisita = +calcularUtilidadesPeroEstaVezSi(lista1, ficha2);
        }
        System.out.println(utiCasa);
        System.out.println(utiVisita);
        int utiTot = utiCasa - utiVisita;
        System.out.println(utiTot);
        return utiTot;
    }

    public static int calcularUtilidadesPeroEstaVezSi(ArrayList<Integer> lista1, int ficha1) {
        int ficha2 = 1;
        if (ficha1 == 1) {
            ficha2 = 2;
        }

        int uti = 0;

        if (lista1.get(0) != ficha2 && lista1.get(1) != ficha2 && lista1.get(2) != ficha2) {
            uti = uti+1;
        }
        if (lista1.get(3) != ficha2 && lista1.get(4) != ficha2 && lista1.get(5) != ficha2) {
            uti = uti+1;
        }
        if (lista1.get(6) != ficha2 && lista1.get(7) != ficha2 && lista1.get(8) != ficha2) {
            uti = uti+1;
        }

        if (lista1.get(0) != ficha2 && lista1.get(3) != ficha2 && lista1.get(6) != ficha2) {
            uti = uti+1;
        }
        if (lista1.get(1) != ficha2 && lista1.get(4) != ficha2 && lista1.get(7) != ficha2) {
            uti = uti+1;
        }
        if (lista1.get(2) != ficha2 && lista1.get(5) != ficha2 && lista1.get(8) != ficha2) {
            uti = uti+1;
        }

        if (lista1.get(0) != ficha2 && lista1.get(4) != ficha2 && lista1.get(8) != ficha2) {
            uti = uti+1;
        }
        if (lista1.get(2) != ficha2 && lista1.get(4) != ficha2 && lista1.get(6) != ficha2) {
            uti = uti+1;
        }
        return uti;
    }

//    public Tree<ArrayList> generarTreeGeneral(ArrayList<Integer> list1, int ficha1) {
//        int ficha2 = 1;
//        if (ficha1 == 1) {
//            ficha2 = 2;
//        }
//        TreeNode nodo1 = new TreeNode(list1);
//        Tree tre1 = new Tree(nodo1);
//        for (int i = 0; i <= list1.size() - 1; i++) {
//            if (list1.get(i) == 0) {
//                ArrayList<Integer> list2 = new ArrayList();
//                list2.addAll(list1);
//                list2.set(i, ficha1);
//                TreeNode nodo2 = new TreeNode(list2);
//                tre1.adddNodoHijo(nodo2);
//            }
//        }
//        ArrayList<TreeNode> list3 = new ArrayList();
//        list3.addAll(tre1.getHijosLista());
//        for (int i = 0; i <= list3.size() - 1; i++) {
//            ArrayList<Integer> list4 = new ArrayList();
//            list4.addAll(list3.get(i).getHijos());
//            for (int e = 0; e < list4.size() - 1; e++) {
//                if (list1.get(i) == 0) {
//                    ArrayList<Integer> list5 = new ArrayList();
//                    list5.addAll(list4);
//                    list5.set(e, ficha2);
//                    TreeNode nodo3 = new TreeNode(list5);
//                    tre1.getHijosLista().get(i).addNodoHijo(nodo3);
//                }
//            }
//        }
//
//        return tre1;
//    }
}
