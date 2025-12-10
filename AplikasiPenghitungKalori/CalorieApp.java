package AplikasiPenghitungKalori;

import java.util.*;

public class CalorieApp {

    static class UserInfo {
        String nama;
        int usia;
        double berat;
        double tinggi;
        String aktivitas;
        double kebutuhanKalori;
    }

    static class JadwalMakan {
        String namaMakanan;
        double kalori;
        boolean selesai;

        JadwalMakan(String n, double k) {
            namaMakanan = n;
            kalori = k;
            selesai = false;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static UserInfo user = new UserInfo();
    static ArrayList<JadwalMakan> daftar = new ArrayList<>();

    public static void main(String[] args) {
        inputUser();
        hitungKalori();
        menuUtama();
    }

    static void inputUser() {
        System.out.print("Masukkan Nama: ");
        user.nama = sc.nextLine();
        System.out.print("Usia: ");
        user.usia = sc.nextInt();
        System.out.print("Berat (kg): ");
        user.berat = sc.nextDouble();
        System.out.print("Tinggi (cm): ");
        user.tinggi = sc.nextDouble();
        sc.nextLine();
        System.out.print("Aktivitas (ringan/sedang/berat): ");
        user.aktivitas = sc.nextLine();
    }

    static void hitungKalori() {
        double bmr = 447.6 + (9.2 * user.berat) + (3.1 * user.tinggi) - (4.3 * user.usia);
        double faktor = 1.2;
        if (user.aktivitas.equalsIgnoreCase("sedang")) faktor = 1.55;
        else if (user.aktivitas.equalsIgnoreCase("berat")) faktor = 1.725;
        user.kebutuhanKalori = bmr * faktor;

        System.out.println("\n==============================");
        System.out.println("DATA USER");
        System.out.println("==============================");
        System.out.printf("Nama      : %s%n", user.nama);
        System.out.printf("Usia      : %d%n", user.usia);
        System.out.printf("Berat     : %.1f kg%n", user.berat);
        System.out.printf("Tinggi    : %.1f cm%n", user.tinggi);
        System.out.printf("Aktivitas : %s%n", user.aktivitas);
        System.out.println("\nKebutuhan Kalori Harian:");
        System.out.printf("%.2f kkal%n", user.kebutuhanKalori);
        System.out.println("==============================\n");
    }

    static void menuUtama() {
        while (true) {
            System.out.println("========== MENU ==========");
            System.out.println("1. Tambah Jadwal Makan");
            System.out.println("2. Tandai Makan Selesai");
            System.out.println("3. Lihat Jadwal Makan");
            System.out.println("4. Total Kalori & Warning");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            int p = sc.nextInt();
            sc.nextLine();

            switch (p) {
                case 1 -> tambahMakan();
                case 2 -> selesaiMakan();
                case 3 -> lihatJadwal();
                case 4 -> cekKalori();
                case 5 -> {
                    System.out.println("Keluar...");
                    return;
                }
                default -> System.out.println("Pilihan salah!");
            }
        }
    }

    static void tambahMakan() {
        System.out.print("Nama makanan: ");
        String n = sc.nextLine();
        System.out.print("Kalori: ");
        double k = sc.nextDouble();
        sc.nextLine();
        daftar.add(new JadwalMakan(n, k));
        System.out.println("Makanan berhasil ditambahkan!\n");
    }

    static void selesaiMakan() {
        lihatJadwal();
        System.out.print("Pilih nomor makanan yang selesai: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        if (idx >= 0 && idx < daftar.size()) {
            daftar.get(idx).selesai = true;
            System.out.println("Ditandai selesai!\n");
        } else {
            System.out.println("Nomor tidak valid!\n");
        }
    }

    static void lihatJadwal() {
        System.out.println("\n===== JADWAL MAKAN =====");
        if (daftar.isEmpty()) {
            System.out.println("(Belum ada jadwal)");
            return;
        }
        int i = 1;
        for (JadwalMakan jm : daftar) {
            System.out.printf("%d. %s - %.1f kkal [%s]%n", i++, jm.namaMakanan, jm.kalori, jm.selesai ? "Selesai" : "Belum");
        }
        System.out.println();
    }

    static void cekKalori() {
        double total = 0;
        for (JadwalMakan j : daftar) {
            if (j.selesai) total += j.kalori;
        }
        System.out.printf("Total kalori yang sudah dikonsumsi: %.2f kkal%n", total);
        System.out.printf("Kebutuhan harian: %.2f kkal%n", user.kebutuhanKalori);

        if (total > user.kebutuhanKalori) {
            System.out.println("WARNING!!! Kalori melebihi kebutuhan harian!\n");
        } else if (total > user.kebutuhanKalori * 0.8) {
            System.out.println("Hampir mencapai batas harian, hati-hati!\n");
        } else {
            System.out.println("Masih dalam batas aman.\n");
        }
    }
}
