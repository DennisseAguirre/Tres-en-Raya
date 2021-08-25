package TDAs;
//Implementacion del TDA Tree, con los metodos que se van a necesitar.

import java.util.ArrayList;
//c

public class Tree {

    TreeNode root;

    //
    public Tree() {
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
        TreeNode tn = new TreeNode(l1);
        this.root = tn;

    }

    //cosntructor de Tree a partir de un nodo como raiz
    public Tree(TreeNode root) {
        this.root = root;
    }

    //Getters y setters
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public ArrayList<TreeNode> getHijosLista() {
        return root.getHijos();
    }

    //Verificasr si la raiz del arbol es null
    public boolean isEmpty() {
        return this.root == null;
    }

    //verificar si el arbol no tienehijos, por ende es una hoja
    public boolean isLeaf() {
        if (this.root.hijos == null || this.root.hijos.isEmpty()) {
            return true;
        }
        return false;
    }

    //Inicializador de hijos, crea una lisra vacia para que  se pueda anadir
    //hijos al arbol
    public void iniHijos() {
        if (this.root.hijos == null) {
            this.root.hijos = new ArrayList<TreeNode>();
        }
    }

    // Agregar un nodo al árbol
    public void adddNodoHijo(TreeNode treeNode) {
        iniHijos();
        this.root.hijos.add(treeNode);
    }
    
    //Obtener el contenido del root del arbol
    public ArrayList<Integer> getContent() {
        return root.getContent();
    }
}
