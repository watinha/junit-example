package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FrutaModel {

    private static Connection conn = null;

    private void connect () throws Exception {
        if (FrutaModel.conn == null) {
            FrutaModel.conn = DriverManager.getConnection(
                    "jdbc:mysql://abobrinha.com:3306/jdbc01", "root", "");
        }
    }

    public List <String> get () throws Exception {
        List <String> lista = new ArrayList <> ();
        this.connect();
        PreparedStatement ps = FrutaModel.conn.prepareStatement(
                "SELECT nome FROM Cidades;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(rs.getString("nome"));
        }
        return lista;
    }

    public void insert (String nome) throws Exception {
        this.connect();
        PreparedStatement ps = FrutaModel.conn.prepareStatement(
                "INSERT INTO Cidades(nome) VALUES (?);");
        ps.setString(1, nome);
        ps.executeUpdate();
    }
}
