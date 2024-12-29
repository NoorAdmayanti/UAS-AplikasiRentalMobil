package dao;

import model.Mobil;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MobilDAO {
    private final Connection connection;

    // Konstruktor menerima Connection
    public MobilDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Mobil> getAllMobil() throws SQLException {
        List<Mobil> mobilList = new ArrayList<>();
        String query = "SELECT * FROM mobil";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Mobil mobil = new Mobil(
                        rs.getInt("id_mobil"),
                        rs.getString("nama_mobil"),
                        rs.getString("jenis_mobil"),
                        rs.getDouble("harga_per_hari")
                );
                mobilList.add(mobil);
            }
        }
        return mobilList;
    }

    public void addMobil(Mobil mobil) throws SQLException {
        String query = "INSERT INTO mobil (nama_mobil, jenis_mobil, harga_per_hari) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, mobil.getNamaMobil());
            stmt.setString(2, mobil.getJenisMobil());
            stmt.setDouble(3, mobil.getHargaPerHari());
            stmt.executeUpdate();
        }
    }

    public void updateMobil(Mobil mobil) throws SQLException {
        String query = "UPDATE mobil SET nama_mobil = ?, jenis_mobil = ?, harga_per_hari = ? WHERE id_mobil = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, mobil.getNamaMobil());
            stmt.setString(2, mobil.getJenisMobil());
            stmt.setDouble(3, mobil.getHargaPerHari());
            stmt.setInt(4, mobil.getIdMobil());
            stmt.executeUpdate();
        }
    }

    public void deleteMobil(int id) throws SQLException {
        String query = "DELETE FROM mobil WHERE id_mobil = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
