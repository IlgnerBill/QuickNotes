package org.example;

import dao.CategoriaDAO;
import dao.AnotacaoDAO;
import dao.LembreteDAO;
import model.Anotacao;
import model.Categoria;
import model.Lembrete;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class QuickNotes {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
        LembreteDAO lembreteDAO = new LembreteDAO();

        int opcao;

        do {


            System.out.println("1-MENU CATEGORIAS\n2-MENU ANOTAÇÃO\n3-MENU LEMBRETE\n0 - SAIR");

            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("1-CADASTRAR CATEGORIA\n2-LISTAR CATEGORIA\n3-DELETAR\n0 - SAIR");
                opcao = sc.nextInt();

                if (opcao == 1) {

                    System.out.print("DIGITE A CATEGORIA: ");
                    sc.nextLine();
                    String categoria = sc.nextLine();
                    categoriaDAO.inserir(categoria);
                }

                if (opcao == 2) {
                    List<Categoria> categorias = categoriaDAO.listarTodos();
                    for (int i = 0; i < categorias.size(); i++) {
                        System.out.println(categorias.get(i));
                    }
                }
               if (opcao == 3){
                   System.out.print("DIGITE O ID PARA DELETAR: ");
                   int id = sc.nextInt();
                   categoriaDAO.deletar(id);
               }
                }



            if (opcao == 2) {
                System.out.println("1-CADASTRAR ANOTAÇÃO \n2-LISTAR ANOTAÇÃO \n0 - SAIR");
                opcao = sc.nextInt();

                if (opcao == 1) {
                    System.out.print("DIGITE O TITULO:");
                    sc.nextLine();
                    String titulo = sc.nextLine();
                    System.out.print("DIGITE O CONTEÚDO:");
                    sc.nextLine();
                    String conteudo = sc.nextLine();
                    System.out.print("DIGITE A DATA:");
                    sc.nextLine();
                    String data = sc.nextLine();
                    System.out.print("DIGITE O ID DA CATEGORIA:");
                    int categoriaId = sc.nextInt();
                    anotacaoDAO.inserir(titulo, conteudo, data, categoriaId);
                }
                if (opcao == 2) {
                    List<Anotacao> anotacao = anotacaoDAO.listar();
                    for (int i = 0; i < anotacao.size(); i++) {
                        System.out.println(anotacao.get(i));
                    }

                }
            }
            if (opcao == 3) {
                System.out.println("1-CADASTRAR LEMBRETE \n2-LISTAR LEMBRETE \n0-SAIR");
                opcao = sc.nextInt();

                if (opcao == 1) {
                    System.out.print("DIGITE A DATA:");
                    sc.nextLine();
                    String data_hora  = sc.nextLine();
                    System.out.print("DIGITE O ID DO LEMBRETE:");
                    int anotacao_id = sc.nextInt();
                    lembreteDAO.inserir(data_hora, anotacao_id);
                }
                if (opcao == 2) {
                    List<Lembrete> lembretes = lembreteDAO.listar();
                    for (int i = 0; i < lembretes.size(); i++) {
                        System.out.println(lembretes.get(i));
                    }

                }
            }
        }
                while (opcao != 0) ;


//AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
//        List<Anotacao> anotacao = anotacaoDAO.listar();
//        for (Anotacao a:anotacao) {
//            System.out.println("Nova anotação: ");
//
//        }

            }
}



