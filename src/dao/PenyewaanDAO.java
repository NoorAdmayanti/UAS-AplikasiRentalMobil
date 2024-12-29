package dao;

import model.Penyewaan;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenyewaanDAO {
    private final Connection connection;

    public PenyewaanDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPenyewaan(Penyewaan penyewaan) throws SQLException {
        String query = "INSERT INTO penyewaan (id_mobil, nama_penyewa, lama_sewa, total_harga, tanggal_sewa) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, penyewaan.getIdMobil());
            statement.setString(2, penyewaan.getNamaPenyewa());
            statement.setInt(3, penyewaan.getLamaSewa());
            statement.setDouble(4, penyewaan.getTotalHarga());
            statement.setString(5, penyewaan.getTanggalSewa());
            statement.executeUpdate();
        }
    }

   public List<Penyewaan> getAllPenyewaan() throws SQLException {
    List<Penyewaan> list = new ArrayList<>();
    String query = "SELECT * FROM penyewaan";
    PreparedStatement statement = connection.prepareStatement(query);
    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()) {
        Penyewaan penyewaan = new Penyewaan(
            resultSet.getInt("id_penyewaan"),
            resultSet.getInt("id_mobil"),
            resultSet.getString("nama_penyewa"),
            resultSet.getInt("lama_sewa"),
            resultSet.getDouble("total_harga"),
            resultSet.getString("tanggal_sewa") // Ambil tanggal sebagai string
        );
        list.add(penyewaan);
    }
    return list;
}

    public void updatePenyewaan(Penyewaan penyewaan) throws SQLException {
    String query = "UPDATE penyewaan SET id_mobil = ?, nama_penyewa = ?, lama_sewa = ?, total_harga = ?, tanggal_sewa = ? WHERE id_penyewaan = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, penyewaan.getIdMobil());
        statement.setString(2, penyewaan.getNamaPenyewa());
        statement.setInt(3, penyewaan.getLamaSewa());
        statement.setDouble(4, penyewaan.getTotalHarga());
        statement.setString(5, penyewaan.getTanggalSewa());
        statement.setInt(6, penyewaan.getIdPenyewaan());
        statement.executeUpdate();
    }
}
    
    public void deletePenyewaan(int idPenyewaan) throws SQLException {
        String query = "DELETE FROM penyewaan WHERE id_penyewaan = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPenyewaan);
            statement.executeUpdate();
        }
    }
}