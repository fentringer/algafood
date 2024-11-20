package com.algaworks.algafood.exception;

public class EntidadeEmUsoException extends RuntimeException{

    public static final long serialVersionUID= 1L;

    public EntidadeEmUsoException(String msg){
        super(msg);
    }
}
