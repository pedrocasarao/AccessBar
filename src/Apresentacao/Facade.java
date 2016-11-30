/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Negocio.CadastroClientes;
import Negocio.Categorias;
import Negocio.Cliente;

/**
 *
 * @author admin
 */
public class Facade {
    private CadastroClientes cadastro;
    
    public boolean validarCampos(String nome, String cpf, int idade){
        return cadastro.validaDados(nome, cpf, idade);
    }
   
    public boolean realizarCadastro(String nome, String cpf, int idade, String status, char genero){
        
        
        return cadastro.validaDados(nome, cpf, idade, genero, status);
    }
    
}
