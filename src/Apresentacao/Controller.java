/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Negocio.CadastroClientes;
import Negocio.Categorias;
import Negocio.Cliente;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Controller {

    private CadastroClientes cadastro;

    public Controller() {
        cadastro = new CadastroClientes();
    }

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

    public ClienteModel consultaCliente(String cpf) {
        Cliente cliente = cadastro.retornaClientedeDeterminadoCPF(cpf);
        if (cliente == null) {
            return null;
        }
        ClienteModel clienteModel = new ClienteModel(cliente.getNome(), cliente.getCpf(), cliente.getGenero(), String.valueOf(cliente.getIdade()), (cliente.getStatus() == Categorias.Silver ? "Silver" : cliente.getStatus() == Categorias.Gold ? "Gold" : cliente.getStatus() == Categorias.Platinum ? "Platinum" : "Normal"), cliente.getHorarioEntrada(), cliente.getHorarioSaida());
        return clienteModel;
    }

    public ArrayList<ClienteModel> listarClientes() {
        ArrayList<ClienteModel> clientesModel = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes = cadastro.listaClientes();
  
            for (Cliente c : clientes) {
                ClienteModel model = new ClienteModel(c.getNome(), c.getCpf(), c.getGenero(), String.valueOf(c.getIdade()), (c.getStatus() == Categorias.Silver ? "Silver" : c.getStatus() == Categorias.Gold ? "Gold" : c.getStatus() == Categorias.Platinum ? "Platinum" : "Normal"), c.getHorarioEntrada(), c.getHorarioSaida());
                clientesModel.add(model);
            }

        return clientesModel;
    }
    
    public String relatorioClientes(){
         ArrayList<ClienteModel> clientes;
        String resultado = "";
        clientes = this.listarClientes();

            for (ClienteModel c : clientes) {

                resultado = resultado + c.toString() + "\n\n";
            }
     
        return resultado;
    }
    
    public String getPercentualMulher(){
        return String.valueOf(cadastro.porcemtagemDeHomemeMulher('F'));
    }
    
    public String getPercentualHomem(){
        return String.valueOf(cadastro.porcemtagemDeHomemeMulher('M'));
    }
    
    public String getSilver(){
        return String.valueOf(cadastro.porcentagemDeDeVipNoBar(1));
    }
        
    public String getGold(){
        return String.valueOf(cadastro.porcentagemDeDeVipNoBar(2));
    }
    
    public String getPlatinum(){
        return String.valueOf(cadastro.porcentagemDeDeVipNoBar(3));
    }
    
    public String getTotal(){
        return String.valueOf(cadastro.getNumeroClientes());
    }
}
