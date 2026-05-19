package org.example;

public class Main {
    public static void main(String[] args) {

        ArvoreBinaria a = new ArvoreBinaria();

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        a.search( 3);

        a.exibir("Pre");

        a.remover(1);

        a.exibir("Pre");

    }
}