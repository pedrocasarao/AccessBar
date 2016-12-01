/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class CadastroClientesTest {
    
    public CadastroClientesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of adicionarCliente method, of class CadastroClientes.
     */
    @Test
    public void testAdicionarCliente() {
        System.out.println("adicionarCliente");
        Cliente cliente = null;
        CadastroClientes instance = new CadastroClientes();
        boolean expResult = false;
        boolean result = instance.adicionarCliente(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class CadastroClientes.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Cliente cliente = null;
        CadastroClientes instance = new CadastroClientes();
        boolean expResult = false;
        boolean result = instance.remove(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaClienteDeterminadoVIP method, of class CadastroClientes.
     */
    @Test
    public void testListaClienteDeterminadoVIP() {
        System.out.println("listaClienteDeterminadoVIP");
        String status = "";
        CadastroClientes instance = new CadastroClientes();
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = instance.listaClienteDeterminadoVIP(status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of porcentagemDetiposDeVipNoBar method, of class CadastroClientes.
     */
    @Test
    public void testPorcentagemDetiposDeVipNoBar() {
        System.out.println("porcentagemDetiposDeVipNoBar");
        String status = "";
        CadastroClientes instance = new CadastroClientes();
        double expResult = 0.0;
        double result = instance.porcentagemDetiposDeVipNoBar(status);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of porcemtagemDeHomemeMulher method, of class CadastroClientes.
     */
    @Test
    public void testPorcemtagemDeHomemeMulher() {
        System.out.println("porcemtagemDeHomemeMulher");
        char tipoGerenro = ' ';
        CadastroClientes instance = new CadastroClientes();
        double expResult = 0.0;
        double result = instance.porcemtagemDeHomemeMulher(tipoGerenro);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaClientedeDeterminadoCPF method, of class CadastroClientes.
     */
    @Test
    public void testRetornaClientedeDeterminadoCPF() {
        System.out.println("retornaClientedeDeterminadoCPF");
        String cpf = "";
        CadastroClientes instance = new CadastroClientes();
        Cliente expResult = null;
        Cliente result = instance.retornaClientedeDeterminadoCPF(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BarNoMomento method, of class CadastroClientes.
     */
    @Test
    public void testBarNoMomento() {
        System.out.println("BarNoMomento");
        CadastroClientes instance = new CadastroClientes();
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = instance.BarNoMomento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
