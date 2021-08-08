/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.ArrayList;

public class Tree {
    TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public ArrayList<TreeNode> getHijosLista() {
        return root.getHijos();
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public boolean isLeaf(){
        if(this.root.hijos==null||this.root.hijos.isEmpty()){
            return true;
        }
        return false;
    }
    
    public void iniHijos() {
        if (this.root.hijos == null)
            this.root.hijos = new ArrayList<TreeNode>();
    }
    
    public void adddNodoHijo(TreeNode treeNode) {
        iniHijos();
        this.root.hijos.add(treeNode);
    }
    
    //Largest Value
    //find
    //lvl
}
