/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.List;

/**
 *
 * @author Juan Pisco
 */
public class TreeNode {
    //Estado estado;
    TreeNode padre;
    List<TreeNode> hijos;

    public TreeNode(TreeNode padre, List<TreeNode> hijos) {
        this.padre = padre;
        this.hijos = hijos;
    }

    public TreeNode getPadre() {
        return padre;
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
}
