/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author 08203013
 */
public class Cliente {
    private String nome, cpf;
    private char genero;
    private int idade;
    private Categorias status;
    
    public Cliente(String nome, String cpf, char genero, int idade){
        if(validaDados(nome, cpf, genero, idade)) throw new IllegalArgumentException("Dados inválidos");
        this.nome=nome;
        this.cpf=cpf;
        this.genero=genero;
        this.idade=idade;
        this.status = null;
        
    }
    private String getNome(){
        return nome;
    }
    private String getCpf(){
        return cpf;
    }
    private char getGenero(){
        return genero;
    }
 
    public String toString(){
        return "Cliente{ nome=" +nome+ ",cpf=" + cpf + ",genero=" + genero + ",idade=" + idade + '}';
    }
    private boolean validaDados(String nome, String cpf, char genero, int idade) {
        return(!nome.equals("")) && (cpf.length() == 11) &&(genero == 'M' || genero == 'F') && (idade > 0 || idade < 120); 
    }
}
