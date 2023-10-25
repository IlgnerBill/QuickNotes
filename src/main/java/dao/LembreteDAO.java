package dao;

import model.Lembrete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LembreteDAO {
    private Connection connection;

    public void inserir(String data_hora, int anotacao_id) throws SQLException {
        String sql = "INSERT INTO lembrete VALUES(null,?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, data_hora);
            statement.setInt(2, anotacao_id);
            statement.executeUpdate();
        }
    }
    public LembreteDAO() throws SQLException {
        this.connection = DBConnection.getConnection();
    }
    public List<Lembrete> listar() throws SQLException {
        List<Lembrete> lembretes = new ArrayList<>();
        String sql = "SELECT * FROM lembrete";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Lembrete lembrete = new Lembrete();
                lembrete.setId(resultSet.getInt("id"));
                lembrete.setDataHora(resultSet.getString("data_hora"));
                lembrete.setAnotacao(resultSet.getInt("anotacao_id"));
                lembretes.add(lembrete);
            }
        }
        DBConnection.closeConnection();
        return lembretes;

    }
}
