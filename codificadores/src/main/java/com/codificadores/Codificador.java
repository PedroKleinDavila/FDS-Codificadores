import java.time.LocalDate;
package com.codificadores;

public class CodificadorDeslocamentoChave implements Codificador {
private final int deslocamento;
private final LocalDate dataCriacao = LocalDate.now();

public CodificadorDeslocamentoChave(int deslocamento) {
this.deslocamento = deslocamento;
}

@Override
public String getNome() {
return "Deslocamento com chave numérica (" + deslocamento + ")";
}

@Override
public LocalDate getDataCriacao() {
return dataCriacao;
}

@Override
public int getNivelSeguranca() {
return 5;
}

@Override
public String codifica(String str) {
if (str == null) return null;
StringBuilder sb = new StringBuilder(str.length());
for (char c : str.toCharArray()) {
sb.append((char) (c + deslocamento)); // desloca pelo valor da chave
}
return sb.toString();
}

@Override
public String decodifica(String str) {
if (str == null) return null;
StringBuilder sb = new StringBuilder(str.length());
for (char c : str.toCharArray()) {
sb.append((char) (c - deslocamento)); // volta deslocamento
}
return sb.toString();
}
}