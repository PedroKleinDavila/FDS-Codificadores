/*Cifra de vigenere funciona assim:
 * Definimos uma mensagem e uma pallavra chave, ex: Mensagem= Policia Chave=Pilha
 * depois repetimos a chave dentro relatico ao tamanho da mensagem, ex: pilhapi
 * transformanmos as letras em numeros relativos a suas posições no alfabeto, fazemos isso para a chave e para a mensagem
 * e por fim somamos os valores das posições das letras da chave e da mensagem
 * Mensagem = P(15), O(14), L(11), I(8), C(2), I(8), A(0)
 * Chave = P(15), I(8), L(11), H(7), A(0), P(15), I(8)
 * Mensagem cifrada= EWWPCXI
 */
package com.codificadores;

import java.time.LocalDate;

public class CodificadorVigenere implements Codificador {

    private final String chave;

    public CodificadorVigenere(String chave) {
        this.chave = chave.toUpperCase();
    }

    @Override
    public String getNome() {
        return "Codificador Vigenere";
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
        StringBuilder resultado = new StringBuilder();
        str = str.toUpperCase();
        int chaveIndex = 0;

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                int letra = c - 'A';
                int deslocamento = chave.charAt(chaveIndex % chave.length()) - 'A';
                char cifrado = (char) ((letra + deslocamento) % 26 + 'A');
                resultado.append(cifrado);
                chaveIndex++;
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    @Override
    public String decodifica(String str) {
        StringBuilder resultado = new StringBuilder();
        str = str.toUpperCase();
        int chaveIndex = 0;

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                int letra = c - 'A';
                int deslocamento = chave.charAt(chaveIndex % chave.length()) - 'A';
                char decifrado = (char) ((letra - deslocamento + 26) % 26 + 'A');
                resultado.append(decifrado);
                chaveIndex++;
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }
}
