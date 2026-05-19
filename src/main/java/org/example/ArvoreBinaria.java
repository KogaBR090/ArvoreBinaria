package org.example;

import lombok.Data;

@Data

public class ArvoreBinaria {

    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
        System.out.println("Arvore plantada");
    }

    public void add(Integer conteudo) {
        No novoNo = new No(conteudo);

        if (is_empty()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {

        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo() == novoNo.getConteudo()) {
            System.out.println("Não é possivel informar nõs repetidos.");
            return;
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public boolean is_empty() {
        return raiz == null;
    }

    private void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {
        switch (percurso) {
            case ("Pre"):
                preOrdem(this.raiz);
                break;
            case ("Em"):
                emOrdem(this.raiz);
                break;
            case ("Pos"):
                posOrdem(this.raiz);
                break;
        }
    }

    public No search(Integer elemento) {
        if (is_empty()) {
            System.out.println("Árvore vazia");
            return null;
        }

        No no = this.raiz;

        while (no != null && !no.getConteudo().equals(elemento)) {
            if (no.getConteudo() < elemento) {
                no = no.getDireita();
            } else {
                no = no.getEsquerda();
            }
        }

        if (no == null) {
            System.out.println("Nó não encontrado");
            return null;
        }

        System.out.println("o nó " + no.getConteudo() + " é igual a " + elemento);
        return no;
    }

    public No searchBefore(Integer elemento) {
        if (is_empty()) {
            System.out.println("Árvore vazia");
            return null;
        }

        No no = this.raiz;

        if (no.getConteudo().equals(elemento)) {
            return no;
        }

        while (no != null && !no.getConteudo().equals(elemento)) {
            if (no.getDireita() != null && no.getDireita().getConteudo() < elemento) {
                no = no.getDireita();
            } else {
                no = no.getEsquerda();
            }
        }

        if (no != null) {
            System.out.println("o nó " + no.getConteudo() + " é igual a " + elemento);
        } else {
            System.out.println("Nó não encontrado");
        }
        return no;
    }

    public void remover(Integer elemento) {
        if (is_empty()) {
            System.out.println("Árvore vazia, não é possível remover.");
            return;
        }
        this.raiz = removerRecursivo(this.raiz, elemento);
    }

    private No removerRecursivo(No no, Integer elemento) {
        if (no == null) {
            System.out.println("Elemento " + elemento + " não encontrado na árvore.");
            return null;
        }

        if (elemento < no.getConteudo()) {
            no.setEsquerda(removerRecursivo(no.getEsquerda(), elemento));
        } else if (elemento > no.getConteudo()) {
            no.setDireita(removerRecursivo(no.getDireita(), elemento));
        } else {
            // remove folha
            if (no.getEsquerda() == null && no.getDireita() == null) {
                System.out.println("nózinho = " + elemento);
                return null;
            }
            // remove 1 filho
            else if (no.getEsquerda() == null) {
                System.out.println("nó 1 fio = " + elemento);
                return no.getDireita();
            } else if (no.getDireita() == null) {
                System.out.println("nó 1 fio = " + elemento);
                return no.getEsquerda();
            }
            // remove com varios fio
            else {
                System.out.println("nó 2 fio = " + elemento);
                No sucessor = encontrarSucessor(no.getDireita());
                no.setConteudo(sucessor.getConteudo());
                no.setDireita(removerRecursivo(no.getDireita(), sucessor.getConteudo()));
            }
        }
        return no;
    }

    // acha menor dos maiores
    private No encontrarSucessor(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
}