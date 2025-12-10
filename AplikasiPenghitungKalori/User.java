/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiPenghitungKalori;
import java.util.Arrays;
/**
 *
 * @author Nazwajafni
 */
public class User {
    private String nama;        // atribut (enkapsulation)
    private int usia;           //primitive types
    private double beratBadan;  //primitive types
    private double tinggiBadan; //primitive types
    private String aktivitas;
    private double kebutuhanKalori; //

    private Schedule[] schedule;
    
    public User(String nama, int usia, double beratBadan, double tinggiBadan, String aktivitas) {
        this.nama = nama;
        this.usia = usia;
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.aktivitas = aktivitas;
        hitungKebutuhanKalori();
        
         schedule = new Schedule[]{
            new Schedule("Pagi"),
            new Schedule("Siang"),
            new Schedule("Malam"),
            new Schedule("Snack")
        };
    }

    public void hitungKebutuhanKalori() {
        double bmr = 10 * beratBadan + 6.25 * tinggiBadan - 5 * usia + 5;

        double faktorAktivitas;
        switch (aktivitas.toLowerCase()) {
            case "ringan": faktorAktivitas = 1.375; break;
            case "sedang": faktorAktivitas = 1.55; break;
            case "berat": faktorAktivitas = 1.725; break;
            default: faktorAktivitas = 1.2;
        }
        kebutuhanKalori = bmr * faktorAktivitas;
    }

    public void tampilkanProfil() {
        System.out.println("=== PROFIL PENGGUNA ===");
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia);
        System.out.println("Berat badan: " + beratBadan + " kg");
        System.out.println("Tinggi badan: " + tinggiBadan + " cm");
        System.out.println("Aktivitas: " + aktivitas);
        System.out.println("Kebutuhan kalori harian: " + kebutuhanKalori + " kkal");
        System.out.println("=========================");
    }
    
    String getNama() { return nama; } //getter (enkapsulation)
    public int getUsia() { return usia; }
    public double getBeratBadan() { return beratBadan; }
    public double getTinggiBadan() { return tinggiBadan; }
    public String getAktivitas() { return aktivitas; }
    public double getKebutuhanKalori() { return kebutuhanKalori; }
    
    public void setJadwalSelesai(String waktu) { //setter(enkapsulation)
        for (Schedule s : schedule) {
            if (s.getWaktuMakan().equalsIgnoreCase(waktu)) {
                s.setSelesai();
                System.out.println("Jadwal " + waktu + " telah ditandai selesai.");
                return;
            }
        }
        System.out.println("Waktu makan tidak ditemukan.");
    }

    public void tampilkanJadwal() {
        System.out.println("=== JADWAL MAKAN ===");
        for (Schedule s : schedule) {
            s.tampilkanJadwal();
        }
    } 
}
