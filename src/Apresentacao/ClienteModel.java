/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

/**
 *
 * @author 13111043
 */
public class ClienteModel {
    private String nome, cpf, idade;
    private char genero;
    private String status;
    private String horarioEntrada;
    private String horarioSaida;
    
    public ClienteModel(String nome, String cpf, char genero, String idade, String status, String horarioEntrada, String horarioSaida){
       
        this.nome=nome;
        this.cpf=cpf;
        this.genero=genero;
        this.idade=idade;
        this.status = status;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    @Override
    public String toString(){
        return "Nome: " + nome + ", CPF: " + cpf + ", Genero: " + genero + ", Idade: " + idade + ", Status: " + status + ",\n Horario de Entrada: " + horarioEntrada + "\n Horario de Saida: " + horarioSaida;
    }
}
