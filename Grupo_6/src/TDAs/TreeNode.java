/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    //Estado estado;
    ArrayList<Integer> content;
    //TreeNode padre;
    ArrayList<TreeNode> hijos;

    public TreeNode() {
        content = null;
        hijos = new ArrayList<TreeNode>();
        //padre = null;
    }

    public TreeNode(ArrayList<Integer> cont) {
        content = cont;
        hijos = new ArrayList<TreeNode>();
        //padre = null;
    }

//
//    public TreeNode getPadre() {
//        return padre;
//    }
    public ArrayList<TreeNode> getHijos() {
        return hijos;
    }

//    public void setPadre(TreeNode padre) {
//        this.padre = padre;
//    }
    public void setHijos(ArrayList<TreeNode> hijos) {
        this.hijos = hijos;
    }

    public void addNodoHijo(TreeNode hijo) {
        this.hijos.add(hijo);
    }

    public ArrayList<Integer> getContent() {
        return content;
    }

    public void setContent(ArrayList<Integer> content) {
        this.content = content;
    }

    public TreeNode(ArrayList<Integer> content, ArrayList<TreeNode> hijos) {
        this.content = content;
        this.hijos = hijos;
    }

    //Metodos para el juego
    public void generarHijos(int ficha1) {
        for (int i = 0; i <= this.getContent().size() - 1; i++) {
            if (this.getContent().get(i) == 0) {
                ArrayList<Integer> list2 = new ArrayList();
                list2.addAll(this.getContent());
                list2.set(i, ficha1);
                TreeNode nodo2 = new TreeNode(list2);
                this.addNodoHijo(nodo2);
            }
        }
    }
}
