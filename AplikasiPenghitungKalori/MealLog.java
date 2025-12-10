package AplikasiPenghitungKalori;

import java.util.ArrayList;

public class MealLog {
    private ArrayList<Food> listMakanan = new ArrayList<>(); // materi Array dan collection
    private double totalKaloriHarian;
    private String tanggal;

    public MealLog(String tanggal) {
        this.tanggal = tanggal;
    }

    public void tambahMakanan(Food food) { //fungsi dari list array
        listMakanan.add(food);
        totalKaloriHarian += food.getKalori();
    }

    public void hapusMakanan(Food food) {
        if (listMakanan.remove(food)) {
            totalKaloriHarian -= food.getKalori();
        }
    }

    public void hitungTotalKalori() {
        double total = 0;
        for (Food f : listMakanan) {
            total += f.getKalori();
        }
        totalKaloriHarian = total;
    }

    public void tampilkanLog() {
        System.out.println("=== LOG MAKAN " + tanggal + " ===");
        for (Food f : listMakanan) {
            f.tampilkanMakanan();
        }
        System.out.println("Total kalori: " + totalKaloriHarian + " kkal");
    }

    public double getTotalKaloriHarian() { return totalKaloriHarian; }
    public ArrayList<Food> getListMakanan() { return listMakanan; }

    // ==== TAMBAHKAN METHOD INI UNTUK MAINGUI ====
    public double totalKalori() { // LOOPING
        double total = 0;
        for (Food f : listMakanan) {
            total += f.getKalori();
        }
        return total;
    }
}
