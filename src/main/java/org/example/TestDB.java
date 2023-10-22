package org.example;

import javax.swing.*;
import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Carregar o driver SQLite JDBC
            Class.forName("org.sqlite.JDBC");

            // Estabelecer a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:db\\db_estoque.db");

            // Estabelecer comandos para criar tabelas
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set tempo de execução

            //COMANDOS PARA DEFINIÇÃO DO BANCO E TABELA
//            statement.executeUpdate("DROP TABLE IF EXISTS person"); //deleta um banco de dados se ele já existir
//            statement.executeUpdate("CREATE TABLE person(per_id INTERGER, per_nome VARCHAR(100))"); // criando a tabela person
//            statement.executeUpdate("INSERT INTO person VALUES(1, 'leandro soares')");
//            statement.executeUpdate("INSERT INTO person VALUES(2, 'anderson andrade')");

//            ResultSet rs = statement.executeQuery("SELECT * FROM person inner join produto on per_id = prod_id");
            ResultSet rs = statement.executeQuery("SELECT * FROM tbl_produto");

            while (rs.next()){
                //lendo os resultados da base de dados
                System.out.println("ID: " + rs.getInt("pk_pro_id"));
                System.out.println("PRODUTO: " + rs.getString("pro_descricao"));
                System.out.println("_______________________________________");


            }





            // Se chegou até aqui, a conexão foi estabelecida com sucesso
            System.out.println("Conexão estabelecida!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // Fechar a conexão
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
