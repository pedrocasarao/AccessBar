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
    
    public boolean validarCampos(String nome, String cpf, int idade) {
        return !nome.equals("") && (idade > 0 || idade < 120) && (cpf.length() == 14);
    }
    
    public boolean realizarCadastro(String nome, String cpf, int idade, String status, char genero) {
        Categorias categoria = null;
        switch (status) {
            case "Silver":
                categoria = Categorias.Silver;
                break;
            case "Gold":
                categoria = Categorias.Gold;
                break;
            case "Platinum":
                categoria = Categorias.Platinum;
                break;
        }
        
        Cliente cliente = new Cliente(nome, cpf, genero, idade, categoria);
        return cadastro.adicionarCliente(cliente);
    }
}
