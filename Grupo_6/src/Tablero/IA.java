/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

import TDAs.Tree;
import TDAs.TreeNode;
import java.util.ArrayList;

/**
 *
 * @author Juan Pisco
 */
public class IA {

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
