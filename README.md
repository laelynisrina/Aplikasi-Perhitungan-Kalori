📘 FITBYTE – Healthy Tracking App
Aplikasi pelacak kalori harian berbasis Java dengan tampilan GUI (Swing) dan versi console.
FitByte membantu pengguna menghitung kebutuhan kalori berdasarkan profil dan mencatat makanan yang dikonsumsi setiap hari.

🎯 Tujuan Aplikasi
Membantu pengguna memantau total kalori makanan harian.

Menyediakan log makanan yang tersusun berdasarkan waktu makan.

Memberikan peringatan otomatis jika kalori melebihi kebutuhan.

Mengelola jadwal makan (pagi, siang, malam, snack).

Menyimpan riwayat makan ke file .txt secara otomatis.

🛠️ Cara Menjalankan Program

📌 Persyaratan
Software	Keterangan
JDK 8+	Untuk menjalankan program Java
IDE (NetBeans / IntelliJ / Eclipse)	Untuk membuka dan menjalankan proyek
OS Windows / Linux / Mac	Aplikasi dapat berjalan di semua OS

📌 Langkah Menjalankan
Clone / Download folder proyek.

Buka IDE lalu Import Project Java.

Pastikan folder utama berisi file berikut:

MainGUI.java

User.java

Food.java

MealLog.java

Schedule.java

CalorieApp.java (versi console)

Jalankan file berikut sesuai mode:

GUI version: jalankan MainGUI.java

Console version: jalankan CalorieApp.java

Aplikasi siap digunakan 🎉

🖥️ 1. Penjelasan Setiap Class

📌 1. User.java
Menyimpan profil pengguna & menghitung kebutuhan kalori harian.
Atribut tersimpan:

Berat badan

Tinggi badan

Usia

Aktivitas

Fitur:

Menghitung kalori harian (rumus Mifflin-St Jeor)

Menampilkan profil

Menyimpan jadwal makan pengguna

📌 2. Food.java
Representasi objek makanan.

Atribut:

Nama makanan

Kalori per porsi

Waktu makan

Fitur:

Menampilkan detail makanan

Objek digunakan di log & jadwal makan

📌 3. MealLog.java
Menyimpan seluruh makanan yang dimakan pada satu hari.

Fitur:

Menambah/hapus makanan

Menghitung total kalori

Menampilkan log makan

Menyimpan data ke file

📌 4. Schedule.java
Menyimpan jadwal makan:

Pagi

Siang

Malam

Snack

Fitur:

Menandai jadwal selesai

Menampilkan status

Pengingat otomatis

📌 5. MainGUI.java (Aplikasi GUI)
Aplikasi berbasis Swing GUI berisi:

Sidebar menu

Profil pengguna

Input makanan

Log makanan

Jadwal makan (checkbox)

Export log ke file .txt

📌 6. CalorieApp.java (Versi Console)
Program berbasis teks dengan fitur:

Input profil

Menambah makanan

Menampilkan log

Menyimpan log ke file

Menampilkan jadwal makan

🖼️ 2. Preview GUI (Screenshots)

📌 Menu Utama
<img width="1096" height="685" alt="Screenshot 2025-12-10 175936" src="https://github.com/user-attachments/assets/d228a31e-99b2-42a0-a172-68537319f035" />

📌 Profil
<img width="1101" height="685" alt="Screenshot 2025-12-10 180254" src="https://github.com/user-attachments/assets/9f67bdda-5166-484b-91ff-9e426db5988f" />

📌 Tambah Makanan
<img width="1103" height="681" alt="Screenshot 2025-12-10 180552" src="https://github.com/user-attachments/assets/ca1a35f3-3666-42b5-9192-d906dbc870a0" />
<img width="1108" height="696" alt="Screenshot 2025-12-10 180631" src="https://github.com/user-attachments/assets/9e6f038d-02d4-4ed0-a95f-6620a54cf506" />
<img width="1099" height="683" alt="Screenshot 2025-12-10 180711" src="https://github.com/user-attachments/assets/731a22f4-1c8b-4285-a3f5-fad81f2f50d7" />



📌 Log Makan
<img width="1101" height="677" alt="Screenshot 2025-12-10 180754" src="https://github.com/user-attachments/assets/d3d49074-0b68-4999-a5a3-adb3bd75374c" />

📌 Jadwal Makan
<img width="1103" height="687" alt="Screenshot 2025-12-10 180841" src="https://github.com/user-attachments/assets/fa686d8f-08d2-47ec-9e1d-36e2fe0fe6d9" />

📌 Keluar (Save Log)
<img width="1100" height="684" alt="Screenshot 2025-12-10 180920" src="https://github.com/user-attachments/assets/ce0f786c-14b3-44a0-a116-22ce4434062c" />


🧾 3. Output Versi Console




📌 Profil
<img width="391" height="409" alt="Screenshot 2025-12-10 181122" src="https://github.com/user-attachments/assets/6fb6cdb0-8438-49c2-bc91-43ab996c6229" />




📌 Tambah Makan
<img width="301" height="235" alt="Screenshot 2025-12-10 181212" src="https://github.com/user-attachments/assets/7125e3db-f9ec-4249-be8b-95a052c88280" />




📌 Log Makan
<img width="433" height="250" alt="image" src="https://github.com/user-attachments/assets/5630dd25-3a08-4e50-abb8-8c1f97f865d5" />




📌 Keluar
<img width="482" height="192" alt="Screenshot 2025-12-10 181411" src="https://github.com/user-attachments/assets/ed5630f9-270d-4d46-9e41-fd9dd448460f" />




📚 4. Implementasi Materi Sebelum UTS (2 Materi Wajib)
🔐 1. Encapsulation (User, Food, Schedule, MealLog)
Seluruh atribut di-set sebagai private, lalu diakses dengan getter & setter.

Contoh kode:
private String nama;

public String getNama() {
    return nama;
}

public void setNama(String nama) {
    this.nama = nama;
}
Manfaat implementasi:
Data aman & terkontrol

Menghindari manipulasi variabel sembarangan

Kelas menjadi lebih rapi & modular

🏗️ 2. Class & Object
Setiap fitur utama dibuat sebagai kelas berbeda.

Struktur OOP:
Class	Fungsi
User	Menyimpan data profil pengguna
Food	Menyimpan detail makanan
MealLog	Menyimpan daftar makanan (ArrayList)
Schedule	Mengelola jadwal makan
Manfaat:
Program lebih mudah dikembangkan

Kode lebih rapi dan modular

Fitur dapat diperluas tanpa mengganggu class lain

📎 5. Materi Setelah UTS (Non-GUI) – File I/O
📄 File I/O (FileWriter)
Saat pengguna menekan Keluar, aplikasi otomatis menyimpan log makanan ke file .txt.

📌 Contoh hasil file
=== LOG MAKAN HARI INI ===
Nasi Goreng | 350 kkal | Pagi
Teh Manis   | 120 kkal | Siang
Total Kalori: 470 kkal
📌 Contoh kode FileWriter
FileWriter writer = new FileWriter("mealLog_" + LocalDate.now() + ".txt");
writer.write("=== LOG MAKAN HARI INI ===\n");

for (Food f : mealLog.getList()) {
    writer.write(f.getName() + " | " + f.getCalories() + " kkal | " + f.getMealTime() + "\n");
}

writer.write("Total Kalori: " + mealLog.getTotalCalories() + " kkal\n");
writer.close();
📌 Manfaat File I/O
Data tidak hilang ketika aplikasi ditutup

Dapat digunakan sebagai riwayat untuk memantau kebiasaan makan

Memudahkan pengguna membaca catatan sebelumnya

