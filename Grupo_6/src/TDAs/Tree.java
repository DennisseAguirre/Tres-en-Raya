
package TDAs;

import java.util.ArrayList;
//c
public class Tree {
    TreeNode root;
    //
    public Tree(){
        ArrayList l1 = new ArrayList();
        l1.add(0);
        l1.add(0);
        l1.add(0);
        l1.add(0);
        l1.add(0);
        l1.add(0);
        l1.add(0);
        l1.add(0);
        l1.add(0);
        TreeNode tn=new TreeNode(l1);
        this.root= tn;
        
    }
    //
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
    // Agregar un nodo al árbol
    public void adddNodoHijo(TreeNode treeNode) {
        iniHijos();
        this.root.hijos.add(treeNode);
    }
    
    public ArrayList<Integer> getContent() {
        return root.getContent();
    }
    
}
