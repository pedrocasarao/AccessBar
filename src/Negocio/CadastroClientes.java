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

    private ClienteDAO clienteDAO = new ClienteDAO();
    private ArrayList<Cliente> listaCliente = new ArrayList<>();

    public boolean adicionarCliente(Cliente cliente) {
        return listaCliente.add(cliente) && clienteDAO.insert(cliente);
    }

    public boolean remove(Cliente cliente) {
        return clienteDAO.remove(cliente) && listaCliente.remove(cliente);
    }

    public ArrayList<Cliente> listaClienteDeterminadoVIP(String status) {
        ArrayList<Cliente> aux = new ArrayList<>();
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getStatus().equals(status)) {
                aux.add(listaCliente.get(i));

            }
        }
        return aux;
    }

    public double porcentagemDetiposDeVipNoBar(String status) {
        double resultado = 0;
        int tamanhodaLista = listaClienteDeterminadoVIP(status).size();
        resultado = tamanhodaLista / listaCliente.size();
        return resultado * 100;
    }

    public double porcemtagemDeHomemeMulher(char tipoGerenro) {
        int cont = 0;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getGenero() == 'M') {
                cont++;
            }
        }
        return cont / listaCliente.size();
    }

    public Cliente retornaClientedeDeterminadoCPF(String cpf) {

        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getCpf().equals(cpf)) {
                return listaCliente.get(i);
            }
        }
        return null;
    }
    public ArrayList<Cliente>     BarNoMomento()
    {
        ArrayList<Cliente>  lista  = new ArrayList<Cliente>();
            for(int i =0; i< listaCliente.size(); i++)
            {
                lista.add(listaCliente.get(i));
            }
            
            return lista;
    }
}
