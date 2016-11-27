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
import Negocio.Cliente;
import java.sql.*;

public class ClienteDAO {

    public static void createConnection() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:cliente.ClienteDb.sqlite");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
     
  public void insert(Cliente cliente)
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "INSERT INTO cliente (id_cliente,"+cliente.getNome()+","+cliente.getCpf()+","+cliente.getGenero()+","+cliente.getIdade()+","+cliente.getStatus()+")" +
                   "VALUES (1,'+Pedro de Oaca' ,'01585840023', 'M', 23, 'gold' );"; 
      stmt.executeUpdate(sql);

      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
   public  void updateDB( Cliente cli , int posicaoDb)
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:ClienteDb.sqlite");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "UPDATE cliente set"+ cli.getIdade()+"= 50 where ID="+posicaoDb+";";
      stmt.executeUpdate(sql);
      c.commit();

      ResultSet rs = stmt.executeQuery( "SELECT * FROM cliente;" );
      while ( rs.next() ) {
         int id = rs.getInt("id_cliente");
         String  nome = rs.getString("nome");
         String cpf  = rs.getString("cpf");
         char  genero = rs.getString("genero").charAt(0);
         int idade = rs.getInt("idade");
         String status = rs.getString("status");
         System.out.println( "id_cliente= " + id );
         System.out.println( "nome= " + nome );
         System.out.println( "cpf = " + cpf );
         System.out.println( "genero = " + genero );
         System.out.println( "idade = " + idade );
          System.out.println("status"+status);
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }

   
}
