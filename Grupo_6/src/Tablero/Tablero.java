/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

import java.util.ArrayList;

public class Tablero {

    ArrayList<Integer> tabla = new ArrayList<>();

    public Tablero() {
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
    }

    public Tablero(ArrayList<Integer> tabla2) {
        tabla = tabla2;
    }

    public ArrayList<Integer> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Integer> tabla) {
        this.tabla = tabla;
    }

    //Edita un valor de la tabla
    public void editTabla(int posicion, int elemento) {
        tabla.set(posicion, elemento);
    }

    //Revisa si ha ganado 1 o 2 o si ya no se puede seguir jugando
    public int ganadorTabla() {
        if (this.tabla.get(0) == this.tabla.get(1) && this.tabla.get(1) == this.tabla.get(2) && this.tabla.get(0) != 0) {
            System.out.println("Los primeros son iguales");
            return this.tabla.get(0);
        }
        if (this.tabla.get(3) == this.tabla.get(4) && this.tabla.get(4) == this.tabla.get(5) && this.tabla.get(3) != 0) {
            System.out.println("Los segundos son iguales");
            return this.tabla.get(3);
        }
        if (this.tabla.get(6) == this.tabla.get(7) && this.tabla.get(7) == this.tabla.get(8) && this.tabla.get(6) != 0) {
            System.out.println("Los terceros son iguales");
            return this.tabla.get(6);
        }

        if (this.tabla.get(0) == this.tabla.get(3) && this.tabla.get(3) == this.tabla.get(6) && this.tabla.get(0) != 0) {
            System.out.println("Los primeros son iguales");
            return this.tabla.get(0);
        }
        if (this.tabla.get(1) == this.tabla.get(4) && this.tabla.get(4) == this.tabla.get(7) && this.tabla.get(1) != 0) {
            System.out.println("Los segundos son iguales");
            return this.tabla.get(1);
        }
        if (this.tabla.get(2) == this.tabla.get(5) && this.tabla.get(5) == this.tabla.get(8) && this.tabla.get(2) != 0) {
            System.out.println("Los terceros son iguales");
            return this.tabla.get(2);
        }

        if (this.tabla.get(0) == this.tabla.get(4) && this.tabla.get(4) == this.tabla.get(8) && this.tabla.get(0) != 0) {
            System.out.println("Los diagonales son iguales");
            return this.tabla.get(0);
        }
        if (this.tabla.get(2) == this.tabla.get(4) && this.tabla.get(4) == this.tabla.get(6) && this.tabla.get(2) != 0) {
            System.out.println("Los diagonales son iguales");
            return this.tabla.get(2);
        }

        if (!this.tabla.contains(0)) {
            return 0;
        }

        return 3;
    }

    //Regresa los valores de la tabla a su estado por defecto
    public void restTabla() {
        this.tabla.clear();
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);
        tabla.add(0);

    }

}
