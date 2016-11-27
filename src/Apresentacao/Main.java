/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Negocio.Cliente;
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
        Cliente cliente = new Cliente("Pedro", "123123123120", 'M', 22);
        ClienteDAO clidb  = new  ClienteDAO();
        clidb.createConnection();
        System.out.println("---teste  insert----");
        clidb.insert(cliente);
              
      
        
    }
    
}
