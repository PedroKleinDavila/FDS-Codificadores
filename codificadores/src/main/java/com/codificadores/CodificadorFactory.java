/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codificadores;

public class CodificadorFactory {

    public static Codificador createCodificador(TipoCodificador tipo) {
        switch (tipo) {
            case TipoCodificador.SIMPLES:
                return new CodificadorSimples();
            case TipoCodificador.VIGENERE:
                return new CodificadorVigenere("islandia");
            default:
                throw new IllegalArgumentException("Tipo de codificador desconhecido: " + tipo);
        }
    }
}
