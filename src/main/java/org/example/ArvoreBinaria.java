package org.example;

public class ArvoreBinaria {

    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Arvore plantada");
    }

    public void add(Integer conteudo) {
        No novoNo = new No(conteudo);

        if (is_empty()) {
            this.raiz = novoNo;
        } else {
            No aux = this.raiz;
            while (true) {
                if (aux.getConteudo() > novoNo.getConteudo()) {
                    if (aux.getNoEsquerda() == null) {
                        aux.setNoEsquerda(novoNo);
                    } else {
                        aux = aux.getNoEsquerda();
                    }
                } else if (aux.getConteudo() == novoNo.getConteudo()) {
                    System.out.println("Nao gera repetido pae");
                } else {
                    if (aux.getNoDireita() == null) {
                        aux.setNoDireita(novoNo);
                    } else {
                        aux = aux.getNoDireita();
                    }
                }
            }
        }
    }

    public boolean is_empty() {
        return raiz == null;
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getNoEsquerda());
        preOrdem(no.getNoDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getNoEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getNoDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getNoEsquerda());
        posOrdem(no.getNoDireita());
        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {
        switch (percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }
    }

}