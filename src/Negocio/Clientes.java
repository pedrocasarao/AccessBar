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
public class Clientes {
    private String nome, cpf, genero;
    private int idade;
    private Categorias Status;
    
    public Clientes(String nome, String cpf, String genero, int idade){
        validaDados(nome, cpf, genero, idade);
        this.nome=nome;
        this.cpf=cpf;
        this.genero=genero;
        this.idade=idade;
        
    }
    private String getNome(){
        return nome;
    }
    private String getCpf(){
        return cpf;
    }
    private String getGenero(){
        return genero;
    }
 
    public String toString(){
        return "Cliente{ nome=" +nome+ ",cpf=" + cpf + ",genero=" + genero + ",idade=" + idade + '}';
    }
    private void validaDados(String nome, String cpf, String genero, int idade) {
        
    }
}
