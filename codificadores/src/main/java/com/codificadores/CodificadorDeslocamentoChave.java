package com.codificadores;

import java.time.LocalDate;

public class CodificadorDeslocamentoChave implements Codificador {

    private final int deslocamento;

    public CodificadorDeslocamentoChave(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    @Override
    public String getNome() {
        return "Deslocamento com chave numérica (" + deslocamento + ")";
    }

    @Override
    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 3, 17);
    }

    @Override
    public int getNivelSeguranca() {
        return 1;
    }

    @Override
    public String codifica(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            sb.append((char) (c + deslocamento));
        }
        return sb.toString();
    }

    @Override
    public String decodifica(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            sb.append((char) (c - deslocamento));
        }
        return sb.toString();
    }
}
