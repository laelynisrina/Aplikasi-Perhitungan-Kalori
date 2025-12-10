/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiPenghitungKalori;

/**
 *
 * @author Nazwajafni
 */
public class Schedule {
    private String waktuMakan;
    private boolean selesai;

    public Schedule(String waktuMakan) {
        this.waktuMakan = waktuMakan;
        this.selesai = false;
    }

    public void setPengingat() {
        System.out.println("Pengingat makan: " + waktuMakan);
    }

    public void tampilkanJadwal() {
        System.out.println("Waktu makan: " + waktuMakan + " | Status: "
                + (selesai ? "Selesai" : "Belum"));
    }

    public void setSelesai() {
        this.selesai = true;
    }
    
    public String getWaktuMakan() {
        return waktuMakan;
    }
}
