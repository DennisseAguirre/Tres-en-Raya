package TDAs;

import java.util.ArrayList;
import java.util.List;
//Implementacion del TDA Tree Node, con los metodos que van a ser usados

public class TreeNode {

    //El contenido de los nodes es siempre un ArrayList pues es mas conveniente
    //para el programa, en ningun momento se encesita contenido de otro tipo
    //de dato
    ArrayList<Integer> content;
    ArrayList<TreeNode> hijos;

    //Constructor del TreeNode
    public TreeNode() {
        content = null;
        hijos = new ArrayList<TreeNode>();
    }

    public TreeNode(ArrayList<Integer> cont) {
        content = cont;
        hijos = new ArrayList<TreeNode>();
    }

    public TreeNode(ArrayList<Integer> content, ArrayList<TreeNode> hijos) {
        this.content = content;
        this.hijos = hijos;
    }

    //Getters y Setters
    public ArrayList<TreeNode> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<TreeNode> hijos) {
        this.hijos = hijos;
    }

    //Anadir un nodo a la lista de hijos del nodo
    public void addNodoHijo(TreeNode hijo) {
        this.hijos.add(hijo);
    }

    public ArrayList<Integer> getContent() {
        return content;
    }

    public void setContent(ArrayList<Integer> content) {
        this.content = content;
    }

    //Metodos para el juego
    // Metodo que sirve para gener hijos del arbol tres en raya dependiendo de si es X o O
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

    //Metodo que permite obtener la cantidad de ceros que hay en el contenido de
    //un nodo. Creado con el objetivo de conocer la cantidad de espacios vacios 
    //que hay en un tablero de 3 en raya.
    public int contarCeros() {
        int numeroDeCeros = 0;
        for (int inte : this.content) {
            if (inte == 0) {
                numeroDeCeros++;
            }
        }
        return numeroDeCeros;
    }
}
