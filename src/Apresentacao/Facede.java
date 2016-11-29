/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

/**
 *
 * @author admin
 */
public class Facede {
    
    
    
    private static Facede instance=null;

    public static Facede getInstance(){
        if (instance == null) {
            instance = new Facede();
        }
        return instance;
    }  
    
  
    public boolean verificaNome(String nome)
    {
        if(!nome.equals(""))
        {
            return true;
            
        }
        return false;
        
    }
            
    public boolean verificacpf(String cpf)
    {
        if(cpf.length()==11)
        {
            return true;
        }
        return false;
    }
    public boolean verificaGenero(char genero)
    {
        if(genero=='M'|| genero=='F')
        {
            return true;
            
        }
        return false;
       
    }
            
    public boolean verificaIdade(int idade)
    {
       if(idade>0 || idade<120)
       {
           return true;
       } 
       return false;
    }
    
  
}