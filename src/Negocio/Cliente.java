/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author 08203013
 */
public class Cliente implements tipoCliente{
    private String nome, cpf;
    private char genero;
    private int idade;
    private String horarioEntrada;
    private String horarioSaida;
    private Categorias status;
   
    public Cliente(){}
    
    public Cliente(String nome, String cpf, char genero, int idade, Categorias status){
       
        this.nome=nome;
        this.cpf=cpf;
        this.genero=genero;
        this.idade=idade;
        this.status = status;
        
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
	horarioEntrada = c.get(Calendar.HOUR_OF_DAY - 1) + "h:" + c.get(Calendar.MINUTE)+ "min de " + f.format(data);
        horarioSaida = c.get(Calendar.HOUR_OF_DAY) + "h:" + c.get(Calendar.MINUTE)+ "min de " + f.format(data);
        
        System.out.println(horarioEntrada);
        System.out.println(horarioSaida);
    }
   public String getNome(){
        return nome;
    }
   public String getCpf(){
        return cpf;
    }
   public  char getGenero(){
        return genero;
    }

    public Categorias getStatus() {
        return status;
    }

    public int getIdade() {
        return idade;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }
   
    
 
    public String toString(){
        return "Cliente{ nome=" +nome+ ",cpf=" + cpf + ",genero=" + genero + ",idade=" + idade + '}';
    }

    @Override
    public String tipostatus(String status) {
        return status;
    }
  
}
