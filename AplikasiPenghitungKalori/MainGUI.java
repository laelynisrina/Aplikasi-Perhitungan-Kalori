package AplikasiPenghitungKalori;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.io.FileWriter;

public class MainGUI extends JFrame {

    // ===== DATA MODEL =====
    private User user;                                                 //reference types
    private MealLog mealLog = new MealLog(LocalDate.now().toString()); //

    // ===== LAYOUT UTAMA =====
    private JPanel cards;
    private CardLayout cl;

    // ===== WARNA TEMA PASTEL =====
    private final Color pastelPink = new Color(255, 204, 213); //Constanta
    private final Color pastelBlue = new Color(187, 222, 251);
    private final Color pastelGreen = new Color(200, 230, 201);
    private final Color pastelYellow = new Color(255, 249, 196);
    private final Color pastelPurple = new Color(224, 201, 255);
    private final Color textDark = new Color(60, 60, 60);

    public MainGUI() {
        setTitle("FitByte - Healthy Tracking App");
        setSize(900, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(850, 520));

        // ===== SIDEBAR =====
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(170, 560));
        sidebar.setBackground(pastelPurple);
        sidebar.setLayout(new GridLayout(6, 1, 5, 5)); 

        JButton profBtn = createMenuButton("Profil");
        JButton addBtn = createMenuButton("Tambah Makanan");
        JButton logBtn = createMenuButton("Log Makan");
        JButton jadwalBtn = createMenuButton("Jadwal Makan");
        JButton keluarBtn = createMenuButton("Keluar");

        sidebar.add(profBtn);
        sidebar.add(addBtn);
        sidebar.add(logBtn);
        sidebar.add(jadwalBtn);
        sidebar.add(keluarBtn);

        // ===== CARD PANEL =====
        cl = new CardLayout();
        cards = new JPanel(cl);

        cards.add(menuProfil(), "profil");
        cards.add(menuTambahMakanan(), "tambah");
        cards.add(menuLog(), "log");
        cards.add(menuJadwal(), "jadwal");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sidebar, BorderLayout.WEST);
        getContentPane().add(cards, BorderLayout.CENTER);

        // ===== ACTION MENU =====
        profBtn.addActionListener(e -> cl.show(cards, "profil"));
        addBtn.addActionListener(e -> cl.show(cards, "tambah"));
        logBtn.addActionListener(e -> cl.show(cards, "log"));
        jadwalBtn.addActionListener(e -> cl.show(cards, "jadwal"));

        // ===== ACTION KELUAR =====
        keluarBtn.addActionListener(e -> {
            simpanDataKeFile();
            JOptionPane.showMessageDialog(this,
                    "Data berhasil disimpan ke file.\nTerima kasih, aplikasi ditutup.",
                    "Keluar Aplikasi",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
    }

    // =====================================================================
    //  COMPONENT: MENU BUTTON STYLE
    // =====================================================================
    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(pastelPink);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(textDark);
        return btn;
    }

    // =====================================================================
    //  PAGE: PROFIL PENGGUNA DENGAN HEADER
    // =====================================================================
    private JPanel menuProfil() {
        JPanel p = new JPanel();
        p.setBackground(pastelBlue);
        p.setLayout(null);

        // ===== HEADER =====
        JLabel appTitle = new JLabel("FIT BYTE", SwingConstants.CENTER);
        appTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        appTitle.setBounds(0, 20, 700, 40);
        appTitle.setForeground(textDark);

        JLabel subTitle = new JLabel("Please insert your data", SwingConstants.CENTER);
        subTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subTitle.setBounds(0, 70, 700, 25);
        subTitle.setForeground(textDark);

        // ===== TOMBOL BUAT PROFIL =====
        JButton buat = new JButton("Buat Profil Baru");
        buat.setBounds(240, 110, 200, 40);
        buat.setBackground(pastelGreen);

        // ===== PANEL INFO PROFIL =====
        JPanel infoPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        infoPanel.setBounds(150, 160, 400, 200);
        infoPanel.setBackground(new Color(255, 245, 230));
        infoPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // ===== ACTION BUAT PROFIL =====
        buat.addActionListener(e -> {
            JTextField n = new JTextField();
            JTextField u = new JTextField();
            JTextField bb = new JTextField();
            JTextField tb = new JTextField();
            JTextField ak = new JTextField();

            Object[] data = {
                    "Nama:", n,
                    "Usia:", u,
                    "Berat (kg):", bb,
                    "Tinggi (cm):", tb,
                    "Aktivitas (ringan/sedang/berat):", ak
            };

            int pilihan = JOptionPane.showConfirmDialog(this, data, "Isi Profil", JOptionPane.OK_CANCEL_OPTION);

            if (pilihan == JOptionPane.OK_OPTION) {
                user = new User(                       //object
                        n.getText(),
                        Integer.parseInt(u.getText()),
                        Double.parseDouble(bb.getText()),
                        Double.parseDouble(tb.getText()),
                        ak.getText()
                );

                infoPanel.removeAll();
                infoPanel.add(new JLabel("Nama:")); infoPanel.add(new JLabel(user.getNama()));
                infoPanel.add(new JLabel("Usia:")); infoPanel.add(new JLabel(String.valueOf(user.getUsia())));
                infoPanel.add(new JLabel("Berat:")); infoPanel.add(new JLabel(String.valueOf(user.getBeratBadan())));
                infoPanel.add(new JLabel("Tinggi:")); infoPanel.add(new JLabel(String.valueOf(user.getTinggiBadan())));
                infoPanel.add(new JLabel("Aktivitas:")); infoPanel.add(new JLabel(user.getAktivitas()));
                infoPanel.add(new JLabel("Kebutuhan Kalori:")); infoPanel.add(new JLabel(String.format("%.2f kkal", user.getKebutuhanKalori())));
                infoPanel.revalidate();
                infoPanel.repaint();
            }
        });

        // ===== TAMBAHKAN SEMUA KE PANEL =====
        p.add(appTitle);
        p.add(subTitle);
        p.add(buat);
        p.add(infoPanel);

        return p;
    }

    // =====================================================================
    //  PAGE: TAMBAH MAKANAN
    // =====================================================================
    private JPanel menuTambahMakanan() {
        JPanel p = new JPanel();
        p.setBackground(pastelPink);
        p.setLayout(null);

        JLabel title = new JLabel("Tambah Makanan", SwingConstants.CENTER);
        title.setBounds(0, 20, 700, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel nLabel = new JLabel("Nama Makanan:");
        JLabel kLabel = new JLabel("Kalori:");
        JLabel wLabel = new JLabel("Waktu Makan:");

        nLabel.setBounds(150, 100, 120, 30);
        kLabel.setBounds(150, 150, 120, 30);
        wLabel.setBounds(150, 200, 120, 30);

        JTextField nField = new JTextField();
        JTextField kField = new JTextField();
        JTextField wField = new JTextField();

        nField.setBounds(280, 100, 200, 30);
        kField.setBounds(280, 150, 200, 30);
        wField.setBounds(280, 200, 200, 30);

        JButton tambah = new JButton("Tambah");
        tambah.setBounds(260, 260, 150, 40);
        tambah.setBackground(pastelGreen);

        tambah.addActionListener(e -> {
            String nama = nField.getText();
            double kal = Double.parseDouble(kField.getText());
            String waktu = wField.getText();

            mealLog.tambahMakanan(new Food(nama, kal, waktu));
            JOptionPane.showMessageDialog(this, "Makanan berhasil ditambahkan!");

            cekKaloriBerlebih();
        });

        p.add(title);
        p.add(nLabel); p.add(kLabel); p.add(wLabel);
        p.add(nField); p.add(kField); p.add(wField);
        p.add(tambah);

        return p;
    }

    // =====================================================================
    //  PAGE: LOG MAKAN
    // =====================================================================
    private JPanel menuLog() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(pastelYellow);

        JLabel title = new JLabel("Log Makanan Harian", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        String[] cols = {"Makanan", "Kalori", "Waktu"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);

        JButton refresh = new JButton("Refresh Log");
        refresh.setBackground(pastelBlue);

        refresh.addActionListener(e -> {
            model.setRowCount(0);
            for (Food f : mealLog.getListMakanan()) {
                model.addRow(new Object[]{f.getNamaMakanan(), f.getKalori(), f.getWaktuMakan()});
            }
            cekKaloriBerlebih();
        });

        p.add(title, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        p.add(refresh, BorderLayout.SOUTH);

        return p;
    }

    // =====================================================================
    //  PAGE: JADWAL
    // =====================================================================
    private JPanel menuJadwal() {
        JPanel p = new JPanel();
        p.setBackground(pastelGreen);
        p.setLayout(null);

        JLabel title = new JLabel("Jadwal Makan", SwingConstants.CENTER);
        title.setBounds(0, 20, 700, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JPanel checkPanel = new JPanel();
        checkPanel.setBounds(150, 100, 400, 250);
        checkPanel.setLayout(new GridLayout(4, 1, 5, 5));
        checkPanel.setBackground(pastelYellow);

        Schedule[] s = {
                new Schedule("Pagi"),
                new Schedule("Siang"),
                new Schedule("Malam"),
                new Schedule("Snack")
        };

        for (Schedule sc : s) {
            JCheckBox cb = new JCheckBox(sc.getWaktuMakan() + " | Belum");
            cb.setBackground(pastelYellow);
            cb.addActionListener(ev -> {
                if (cb.isSelected()) {
                    cb.setText(sc.getWaktuMakan() + " | Sudah");
                } else {
                    cb.setText(sc.getWaktuMakan() + " | Belum");
                }
            });
            checkPanel.add(cb);
        }

        JButton lihat = new JButton("Tampilkan Jadwal");
        lihat.setBounds(250, 380, 180, 40);
        lihat.setBackground(pastelPink);

        p.add(title);
        p.add(checkPanel);
        p.add(lihat);

        return p;
    }

    // =====================================================================
    //  CEK KALORI BERLEBIH
    // =====================================================================
    private void cekKaloriBerlebih() {
        if (user != null && mealLog.totalKalori() > user.getKebutuhanKalori()) { //conditional if
            JOptionPane.showMessageDialog(this,
                    "Peringatan: Total kalori harian sudah melebihi batas!",
                    "Kalori Berlebih",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // =====================================================================
    //  SIMPAN DATA KE FILE
    // =====================================================================
    private void simpanDataKeFile() {
        if (mealLog != null && !mealLog.getListMakanan().isEmpty()) {
            try {
                FileWriter writer = new FileWriter("mealLog_" + LocalDate.now() + ".txt");
                writer.write("=== LOG MAKAN HARI INI ===\n");
                for (Food f : mealLog.getListMakanan()) {
                    writer.write(f.getNamaMakanan() + " | " + f.getKalori() + " kkal | " + f.getWaktuMakan() + "\n");
                }
                writer.write("Total Kalori: " + mealLog.totalKalori() + " kkal\n");
                writer.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Gagal menyimpan data: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // =====================================================================
    //  MAIN
    // =====================================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}