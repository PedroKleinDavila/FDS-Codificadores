package com.codificadores;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;


public class CodificadorBase64 implements Codificador{
    @Override
    public String getNome() {
        return "Base64 Encoder";
    }
    
    @Override
    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 8, 15);
    }
    
    @Override
    public int getNivelSeguranca() {
        return 5; 
    }
    
    @Override
    public String codifica(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao codificar string em Base64", e);
        }
    }
    
    @Override
    public String decodifica(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        
        try {
            byte[] decoded = Base64.getDecoder().decode(str);
            return new String(decoded, StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("String Base64 inválida para decodificação", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao decodificar string Base64", e);
        }
    }
    
   
    
    


}
