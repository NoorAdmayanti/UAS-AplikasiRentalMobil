package ui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import utils.DatabaseConnection;

public class MainFrame extends JFrame {
    private Connection connection;

    public MainFrame() {
        initializeDatabase();
        initializeFrame();
        createComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initializeDatabase() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal terhubung ke database: " + e.getMessage(),
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void initializeFrame() {
        setTitle("Sistem Manajemen Rental Mobil");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        setResizable(false);
        setLayout(new BorderLayout());
    }

    private void createComponents() {
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        JPanel menuPanel = createMenuPanel();
        add(menuPanel, BorderLayout.CENTER);

        JPanel footerPanel = createFooterPanel();
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(51, 51, 51));
        headerPanel.setPreferredSize(new Dimension(600, 80));
        headerPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("SISTEM MANAJEMEN RENTAL MOBIL");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        return headerPanel;
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(240, 240, 240));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        menuPanel.setLayout(new GridLayout(2, 1, 0, 20));

        JButton btnTambahMobil = createStyledButton("Kelola Data Mobil", "resources/car-icon.png");
        JButton btnTambahPenyewaan = createStyledButton("Kelola Data Penyewaan", "resources/rental-icon.png");

        btnTambahMobil.addActionListener(e -> openMobilForm());
        btnTambahPenyewaan.addActionListener(e -> openPenyewaanForm());

        menuPanel.add(btnTambahMobil);
        menuPanel.add(btnTambahPenyewaan);

        return menuPanel;
    }

    private JButton createStyledButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(new Color(51, 51, 51));
        button.setBackground(new Color(255, 255, 255));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(230, 230, 230));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 255, 255));
            }
        });

        return button;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(51, 51, 51));
        footerPanel.setPreferredSize(new Dimension(600, 40));
        
        JLabel footerLabel = new JLabel("© 2024 Sistem Manajemen Rental Mobil");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);

        return footerPanel;
    }

    private void openMobilForm() {
        try {
            TambahMobil mobilForm = new TambahMobil(connection);
            mobilForm.setLocationRelativeTo(this);
            mobilForm.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal membuka form mobil: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openPenyewaanForm() {
        try {
            TambahPenyewaan penyewaanForm = new TambahPenyewaan();
            penyewaanForm.setLocationRelativeTo(this);
            penyewaanForm.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal membuka form penyewaan: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}