/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiPenghitungKalori;

/**
 *
 * @author Nazwajafni
 */
public class Food {
    private String namaMakanan;
    private double kaloriPerPorsi;
    private String waktuMakan;

    public Food(String namaMakanan, double kaloriPerPorsi, String waktuMakan) {
        this.namaMakanan = namaMakanan;
        this.kaloriPerPorsi = kaloriPerPorsi;
        this.waktuMakan = waktuMakan;
    }
    
   public double getKalori() { return kaloriPerPorsi; }
   public String getNamaMakanan() { return namaMakanan; }
   public String getWaktuMakan() { return waktuMakan; }

    public void tampilkanMakanan() {
        System.out.println(namaMakanan + " - " + kaloriPerPorsi + " kkal (" + waktuMakan + ")");
    }
}
