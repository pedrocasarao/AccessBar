/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Persistencia.ClienteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CadastroClientes {

    private ClienteDAO clienteDAO;
    private ArrayList<Cliente> listaCliente;

    public CadastroClientes() {
        this.clienteDAO = new ClienteDAO();
        this.listaCliente = clienteDAO.consultarTodosClientes();
    }

    public boolean adicionarCliente(Cliente cliente) {
        return listaCliente.add(cliente) && clienteDAO.gravarCliente(cliente);
    }

    public boolean remove(Cliente cliente) {
        return clienteDAO.removerCliente(cliente) && listaCliente.remove(cliente);
    }

    public ArrayList<Cliente> listaClientesVip() {
        ArrayList<Cliente> aux = new ArrayList<>();
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getStatus()!= null) {
                aux.add(listaCliente.get(i));
            }
        }
        return aux;
    }

    public double porcentagemDeDeVipNoBar(int status) {
        ArrayList<Cliente> listaVip = listaClientesVip();
        int cont=0;
        Categorias atual = null;
        if(status == 1){
                atual = Categorias.Silver;
            }else if(status == 2){
                atual = Categorias.Gold;
            }else if(status == 3){
                atual = Categorias.Platinum;
            }
        
        for(Cliente c: listaVip){
            if(c.getStatus().equals(atual)){
                cont++;
            }
        }
        
        //double resultado = tamanhodaLista / listaCliente.size();
        return  (cont * 100) / listaVip.size();
    }

    public double porcemtagemDeHomemeMulher(char tipoGenero) {
        int cont = 0;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getGenero() == tipoGenero) {
                cont++;
            }
        }
        return (cont * 100) / listaCliente.size();
    }

    public Cliente retornaClientedeDeterminadoCPF(String cpf) {

        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getCpf().equals(cpf)) {
                return listaCliente.get(i);
            }
        }
        return null;
    }

    public ArrayList<Cliente> listaClientes() {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        for (int i = 0; i < listaCliente.size(); i++) {
            lista.add(listaCliente.get(i));
        }

        return lista;
    }
    
    public int getNumeroClientes(){
        return listaCliente.size();
    }
}
