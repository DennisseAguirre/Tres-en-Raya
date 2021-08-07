/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {
    TreeNode<T> root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
     public Tree<T> getLeft() {
        return this.root.getLeft();
    }

    public Tree<T> getRight() {
        return this.root.getRight();
    }
    
    public Tree(T contenido) {
        this.root = new TreeNode<>(contenido);
    }
     public Tree() {
        this.root = new TreeNode<>();
    }
    
    public void largestValueOfEachLevelIterative(Tree<Integer> tree) {
        if (tree == null || tree.isEmpty())
            return;
        Queue<Tree<Integer>> elementos = new LinkedList<>();
        elementos.offer(tree);
        int nivel = 1;
        while (!elementos.isEmpty()){
            int initialSize = elementos.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < initialSize; i++) {
               Tree<Integer> arbol = elementos.poll();
               Tree<Integer> arbolizquierdo = arbol.getLeft(), arbolDerecho = arbol.getRight();
               TreeNode<Integer> raiz = arbol.root;
                if(raiz != null && max < raiz.getContenido())
                    max = raiz.getContenido();

                if (arbolizquierdo !=null)
                    elementos.offer(arbolizquierdo);
                if (arbolDerecho != null)
                    elementos.offer(arbolDerecho);
            }
            System.out.println("Valor mayor es: " + nivel + ": " + max);
            nivel++;
        }

    }
    //Largest Value
    //find
    //lvl
}
