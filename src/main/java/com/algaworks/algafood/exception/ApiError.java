package com.algaworks.algafood.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiError {
    private String mensagem;
    private int status;
    private String timestamp;

    public ApiError(String mensagem, int status, LocalDateTime timestamp) {
        this.mensagem = mensagem;
        this.status = status;
        this.timestamp = timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
