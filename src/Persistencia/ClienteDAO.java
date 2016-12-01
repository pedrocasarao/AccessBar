/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author 05200189
 */
import Negocio.Categorias;
import Negocio.Cliente;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    public Cliente consultarCliente(String cpf) {
        Connection conn = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            state = conn.createStatement();
            ResultSet resultado = state.executeQuery("SELECT * FROM CLIENTE WHERE =" + cpf + ";");
            //while (resultado.next()) { utilizado para pegar todos os resultados, neste caso pegaremos o primeiro pois estamos buscando pela Primary Key
            resultado.next();
            String rCpf = resultado.getString("cpf");
            String rNome = resultado.getString("nome");
            int rIdade = resultado.getInt("idade");
            char rGenero = resultado.getString("genero").charAt(0);
            int rStatus = resultado.getInt("status");

            //DEBUG
            System.out.println("CPF = " + rCpf);
            System.out.println("Nome = " + rNome);
            System.out.println("Idade = " + rIdade);
            System.out.println("Genero = " + rGenero);
            System.out.println("status = " + rStatus);
            System.out.println();
            // }
            resultado.close();
            state.close();
            conn.close();

            Cliente cliente = new Cliente(rNome, rCpf, rGenero, rIdade, rStatus == 1 ? Categorias.Silver : rStatus == 2 ? Categorias.Gold : rStatus == 3 ? Categorias.Platinum : null);
            System.out.println("Operation done successfully");
            return cliente;

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public ArrayList<Cliente> consultarTodosClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Connection conn = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            state = conn.createStatement();
            ResultSet resultado = state.executeQuery("SELECT * FROM CLIENTE;");
            while (resultado.next()) { //utilizado para pegar todos os resultados.
                resultado.next();
                String rCpf = resultado.getString("cpf");
                String rNome = resultado.getString("nome");
                int rIdade = resultado.getInt("idade");
                char rGenero = resultado.getString("genero").charAt(0);
                int rStatus = resultado.getInt("status");

                Cliente cliente = new Cliente(rNome, rCpf, rGenero, rIdade, rStatus == 1 ? Categorias.Silver : rStatus == 2 ? Categorias.Gold : rStatus == 3 ? Categorias.Platinum : null);
                clientes.add(cliente);
                //DEBUG
                System.out.println("CPF = " + rCpf);
                System.out.println("Nome = " + rNome);
                System.out.println("Idade = " + rIdade);
                System.out.println("Genero = " + rGenero);
                System.out.println("status = " + rStatus);
                System.out.println();
            }
            resultado.close();
            state.close();
            conn.close();

            System.out.println("Operation done successfully");
            return clientes;

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public boolean gravarCliente(Cliente cliente) {
        Connection conn = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            state = conn.createStatement();
            String sql = "INSERT INTO cliente "
                    + "VALUES(" + cliente.getCpf() + "," + cliente.getNome() + "," + cliente.getGenero() + "," + cliente.getIdade() + "," + (cliente.getStatus() == Categorias.Silver ? 1 : cliente.getStatus() == Categorias.Gold ? 2 : cliente.getStatus() == Categorias.Platinum ? 3 : 0) + ");";
            state.executeUpdate(sql);

            state.close();
            conn.commit();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
        return true;
    }

    public boolean removerCliente(Cliente cliente) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DELETE FROM cliente WHERE" + cliente.getCpf() + " ;";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("remove with successfully");
        return true;
    }

}
