package com.vinyl_management.vinyl_management.dao;

import com.vinyl_management.vinyl_management.model.Vinyl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VinylDAO {

    public VinylDAO() {
        createTable();
    }

    private void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS vinyls (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT,
                    artist TEXT,
                    genre TEXT,
                    year INTEGER,
                    condition TEXT,
                    price REAL
                );
                """;

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addVinyl(Vinyl v) {
        String sql = "INSERT INTO vinyls(title, artist, genre, year, condition, price) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getTitle());
            ps.setString(2, v.getArtist());
            ps.setString(3, v.getGenre());
            ps.setInt(4, v.getYear());
            ps.setString(5, v.getCondition());
            ps.setDouble(6, v.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vinyl> getAll() {
        List<Vinyl> list = new ArrayList<>();
        String sql = "SELECT * FROM vinyls";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vinyl v = new Vinyl(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("artist"),
                        rs.getString("genre"),
                        rs.getInt("year"),
                        rs.getString("condition"),
                        rs.getDouble("price")
                );
                list.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
