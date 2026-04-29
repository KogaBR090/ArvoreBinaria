package org.example;

import lombok.Data;

@Data

public class No {

    No noEsquerda;
    No noDireita;
    Integer conteudo;

    public No(Integer conteudo){
        this.conteudo = conteudo;
        noEsquerda = null;
        noDireita = null;
    }

}
