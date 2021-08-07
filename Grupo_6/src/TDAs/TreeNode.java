/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.List;

public class TreeNode<T> {
    //Estado estado;
    private T contenido;
    TreeNode padre;
    List<TreeNode> hijos;
    private Tree<T> left;
    private Tree<T> right;
    
    public TreeNode(TreeNode padre, List<TreeNode> hijos) {
        this.padre = padre;
        this.hijos = hijos;
    }
    public TreeNode() {
        this.contenido=null;
        this.left=null;
        this.right=null;
    }
    public TreeNode getPadre() {
        return padre;
    }
    
     public TreeNode(T contenido) {
        this.contenido=contenido;
        left=null;
        right=null;
    }

    public List<TreeNode> getHijos() {
        return hijos;
    }

    public void setPadre(TreeNode padre) {
        this.padre = padre;
    }

    public void setHijos(List<TreeNode> hijos) {
        this.hijos = hijos;
    }
    
    
    //Ver si gano

    public T getContenido() {
        return contenido;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public Tree<T> getRight() {
        return right;
    }
}
