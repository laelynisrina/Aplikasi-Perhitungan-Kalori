# FitByte — Aplikasi Penghitungan Kalori & Pencatatan Makanan Sehat Sesuai Jadwal

FitByte adalah aplikasi Java yang membantu pengguna menghitung kebutuhan kalori harian, mencatat makanan yang dikonsumsi, dan melihat jadwal makan. Aplikasi tersedia dalam dua versi: **Console App** dan **GUI (Swing)**.

Project ini dibuat sebagai **Tugas Akhir Praktikum Pemrograman Berorientasi Objek**.

---

## 1. Tujuan Project

Aplikasi ini dibuat untuk:

- Menghitung kebutuhan kalori pengguna berdasarkan rumus BMR + Faktor Aktivitas.
- Mencatat makanan yang dikonsumsi beserta total kalorinya.
- Memberikan peringatan ketika pengguna melebihi batas kalori harian.
- Menyediakan jadwal makan terstruktur (pagi, siang, malam, snack).
- Menyediakan antarmuka GUI bertema pastel yang modern dan ramah pengguna.

---

## 2. Cara Menjalankan Program

### A. **Versi Console**

1. Pastikan Java (JDK) sudah terinstall dan dapat diakses melalui terminal/cmd. Cek dengan:

```bash
java -version
```

2. Buka folder project di terminal/cmd:

```bash
cd AplikasiPenghitunganKalori
```

3. Compile seluruh file .java:

```bash
javac *.java
```

4. Jalankan program:

```bash
java CalorieApp
```

**Setelah Program Berjalan**

Console akan meminta data seperti usia, berat, tinggi, dan aktivitas harian.

Setelah itu, pengguna bisa:

- Mencatat makanan,
- Melihat total kalori harian,
- Menyimpan log ke file,
- Keluar dari aplikasi.

Semua output muncul langsung di terminal.

---

### B. **Versi GUI**

1. Pastikan JDK sudah terinstall dan konfigurasi Swing tidak bermasalah.

2. Compile semua file Java:

```bash
javac *.java
```

3. Jalankan aplikasi GUI:

```bash
java MainGUI
```

**Setelah Program Berjalan**

Jendela GUI akan terbuka otomatis.

Pengguna dapat:

- Mengisi data profil,
- Menambah makanan ke tabel,
- Melihat total kalori,
- Menyimpan data ke file melalui tombol Save,
- Berpindah halaman menggunakan menu navigasi.

Semua aktivitas dilakukan lewat tombol dan input form, tanpa terminal.

---

## 3. Penjelasan GUI

### **Tampilan Utama**

GUI terdiri dari sidebar dan area konten utama.

### **Fitur Sidebar**

| Fitur          | Fungsi                                     |
| -------------- | ------------------------------------------ |
| Profil         | Input dan tampilkan data user              |
| Tambah Makanan | Form menambahkan makanan                   |
| Log Makan      | Melihat daftar makanan yang sudah dicatat  |
| Jadwal Makan   | Checklist status jadwal makan              |
| Keluar         | Menyimpan log ke file dan menutup aplikasi |

---

### **Halaman Profil**

![Halaman Profil](https://github.com/user-attachments/assets/3a964b8d-45eb-4a30-a0b7-4b2638845265)

Berfungsi untuk:

* Input data pengguna (berat, tinggi, umur, aktivitas).
* Menghitung kebutuhan kalori otomatis.
* Menampilkan ringkasan profil.

---

### **Halaman Tambah Makanan**

<img width="1107" height="691" alt="image" src="https://github.com/user-attachments/assets/137af45e-ff41-482d-9f85-5dc7eaeb5700" />

<img width="1105" height="699" alt="image" src="https://github.com/user-attachments/assets/5b2a3d6d-11a0-40ab-880e-1dcff99d94d7" />

<img width="1101" height="686" alt="image" src="https://github.com/user-attachments/assets/3ba3401b-3bfe-45af-b13b-bd898cdc52d9" />




* Input nama makanan, jumlah kalori, dan waktu makan.
* Menambahkan data ke `MealLog`.
* Memberikan peringatan ketika total kalori melewati batas harian.

---

### **Halaman Log Makan**

<img width="1107" height="687" alt="image" src="https://github.com/user-attachments/assets/c20b6762-b7ae-43a0-91a1-fdfe78c07fe5" />

<img width="1102" height="686" alt="image" src="https://github.com/user-attachments/assets/304fb7c1-84ce-4767-bd6b-a7798645b99e" />


* Menampilkan tabel berisi log makanan.
* Tersedia tombol **Refresh Log** untuk memuat ulang data.

---

### **Halaman Jadwal Makan**

<img width="1107" height="686" alt="image" src="https://github.com/user-attachments/assets/dc3e3194-aa2d-49a4-acc6-eed2c0bf731d" />


Memiliki empat jadwal default:

* Pagi
* Siang
* Malam
* Snack

Pengguna dapat memberi checklist pada setiap jadwal yang sudah dijalankan.

---

## 4. Implementasi Materi Sebelum UTS

Menggunakan konsep:

* Class
* Object
* Method
* Constructor
* Package

### **Contoh Implementasi Class & Constructor**

```java
public class Food {
    private String namaMakanan;
    private double kaloriPerPorsi;

    public Food(String nama, double kalori) {
        this.namaMakanan = nama;
        this.kaloriPerPorsi = kalori;
    }

    public double getKalori() {
        return kaloriPerPorsi;
    }
}
```

Pemanggilan:

```java
Food mie = new Food("Mie Goreng", 450);
```

---

### **Kondisional & Looping**

Contoh pengecekan batas kalori:

```java
if (mealLog.getTotalKaloriHarian() > user.getKebutuhanKalori()) {
    System.out.println("Anda sudah melebihi kebutuhan kalori!");
}
```

Contoh looping:

```java
for (Food f : listMakanan) {
    f.tampilkanMakanan();
}
```

---

## 5. Implementasi Materi Setelah UTS

### **Enkapsulasi**

* Semua atribut dibuat `private`
* Akses melalui getter dan setter

Contoh:

```java
private double beratBadan;

public double getBeratBadan() {
    return beratBadan;
}
```

### **Inheritance**

Struktur siap dikembangkan untuk:

* User Premium
* User Diet Khusus

Namun saat ini fokus pada enkapsulasi dan modularisasi class.

---

## 7. Pembagian Tugas Anggota

Project dikerjakan oleh tiga anggota secara kolaboratif tanpa pembagian tugas spesifik:

| Nama                     | NIM      | Kontribusi                                                       |
| ------------------------ | -------- | ---------------------------------------------------------------- |
| Fidela Novelia           | L0324012 | Perancangan class, implementasi fitur, GUI, testing, dokumentasi |
| Laely Nisrina            | L0324019 | Perancangan class, implementasi fitur, GUI, testing, dokumentasi |
| Nazwa Nur Aisyiyah Jafni | L0324029 | Perancangan class, implementasi fitur, GUI, testing, dokumentasi |

**Catatan Kolaborasi:**

* Semua keputusan desain dibuat melalui diskusi bersama.
* Seluruh kode dan dokumentasi dikerjakan bersama.
* Tidak ada peran eksklusif; semua fitur dikembangkan kolektif.

---

## 8. Lisensi

Project ini dibuat untuk kebutuhan akademik dan bebas digunakan untuk pembelajaran.

---

## 9. Penutup

FitByte membantu pengguna mengontrol pola makan dengan cara yang modern, informatif, dan mudah digunakan. Dengan adanya versi Console dan GUI, aplikasi ini dapat dijalankan pada berbagai kebutuhan pengguna.

---

## 10. Link Youtube
https://youtu.be/EOmKtJp2UOk
