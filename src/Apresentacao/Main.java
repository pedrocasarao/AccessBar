/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Negocio.Clientes;
import Persistencia.ClienteDAO;
/**
 *
 * @author 08203013
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clientes cliente = new Clientes("Pedro", "12312312312", "M", 22);
        ClienteDAO clidb  = new  ClienteDAO();
        clidb.createConnection();
        System.out.println("----------");
        clidb.insert(cliente);
              
      
        
    }
    
}
