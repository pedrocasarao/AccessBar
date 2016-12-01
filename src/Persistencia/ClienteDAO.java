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
            ResultSet resultado = state.executeQuery("SELECT * FROM CLIENTE WHERE =" + cpf);
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
            
            Cliente cliente = new Cliente(rNome, rCpf, rGenero, rIdade, rStatus == 1 ? Categorias.Silver : rStatus == 2 ? Categorias.Gold : rStatus == 2 ? Categorias.Platinum : null);
            System.out.println("Operation done successfully");
            return cliente;
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
    

    public static void createConnection() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:cliente.ClienteDb.sqlite");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }

    public boolean insert(Cliente cliente) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO cliente ()"
                    + "VALUES (,'Pedro de Oaca' ,'01585840023', 'M', 23, 'gold' );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
        return true;
    }

    public void updateDB(int posicaoDb) {
        Cliente cli = new Cliente();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE cliente set" + cli.getIdade() + "= 50 where ID=" + posicaoDb + ";";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente;");
            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                char genero = rs.getString("genero").charAt(0);
                int idade = rs.getInt("idade");
                String status = rs.getString("status");
                System.out.println("id_cliente= " + id);
                System.out.println("nome= " + nome);
                System.out.println("cpf = " + cpf);
                System.out.println("genero = " + genero);
                System.out.println("idade = " + idade);
                System.out.println("status" + status);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public boolean remove(Cliente cliente) {
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

    public void carregaCliente(Cliente cliente) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "SELECT FROM * cliente  ;";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("remove with successfully");
    }

}
