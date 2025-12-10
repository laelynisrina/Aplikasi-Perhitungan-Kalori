FITBYTE – Healthy Tracking App
Aplikasi tracking kalori harian berbasis Java + GUI (Swing).
FitByte membantu pengguna menghitung kebutuhan kalori harian berdasarkan data profil (usia, berat, tinggi, dan aktivitas) dan mencatat makanan yang dikonsumsi dalam satu hari.
✨ Tujuan aplikasi:

Membantu pengguna memantau total kalori makanan.

Menampilkan jadwal makan dan log makanan.

Memberikan peringatan otomatis jika kalori melebihi kebutuhan.
🛠 Cara Menjalankan Program
Pastikan sudah terinstall:

Software	                        Keterangan
JDK 8+	                        Java Development Kit
IDE (NetBeans/IntelliJ/Eclipse)	Editor untuk menjalankan proyek
OS Windows/Linux/Mac	            Dapat dijalankan di semua OS

🔧 Langkah menjalankan

Clone/Download folder project.

Import project ke IDE Java.

Pastikan folder AplikasiPenghitungKalori/ berisi file:

MainGUI.java

User.java

Food.java

MealLog.java

Schedule.java

Jalankan file:

MainGUI.java

Aplikasi akan tampil dan siap digunakan 🎉

1. Penjelasan Setiap Class
   1. User.java
      Menyimpan profil pengguna dan menghitung kebutuhan kalori harian berdasarkan:
      Berat badan
      Tinggi badan
      Usia
      Tingkat aktivitas
      Fitur:
      Hitung kalori dengan rumus Mifflin-St Jeor
      Menampilkan profil
      Menyimpan array jadwal makan
   2. Food.java
      Representasi satu makanan dengan atribut:
      Nama makanan
      Kalori per porsi
      Waktu makan
      Juga menyediakan method untuk menampilkan makanan.
   3. MealLog.java
      Menyimpan semua makanan yang dimakan hari itu.
      Fitur:
      Menambah dan menghapus makanan
      Menghitung total kalori harian
      Menampilkan log makanan
      Menyimpan data ke file
   4. Schedule.java
      Kelas yang mewakili jadwal makan:
      Pagi
      Siang
      Malam
      Snack
      Fitur:
      Tandai jadwal sebagai selesai
      Menampilkan status jadwal
      Pengingat
   6. MainGUI.java (APP GUI)
      Aplikasi Swing dengan:
      Sidebar menu
      Profil pengguna
      Input makanan
      Log harian
      Jadwal makan checklist
      Export log ke file .txt
   8. CalorieApp.java (APP CONSOLE)
      Aplikasi berbasis teks yang menyediakan:
      Input profil
      Tambah makanan
      Log makanan
      Jadwal makan
      Menyimpan data ke file
2. Preview GUI
   <img width="1096" height="685" alt="image" src="https://github.com/user-attachments/assets/9eabaf6d-75ec-43fe-bf23-395001d6e2e9" />
   
   Profile
   <img width="1101" height="685" alt="image" src="https://github.com/user-attachments/assets/6c6af5a7-d52c-43c3-b9f1-ed18d859d3b2" />

   Tambah Makanan
   <img width="1103" height="681" alt="image" src="https://github.com/user-attachments/assets/1c314f49-ef0e-4012-9182-9711e3229b02" />
   <img width="1107" height="696" alt="image" src="https://github.com/user-attachments/assets/a7790414-15d2-4e95-94ba-833f90b11f50" />
   <img width="1098" height="682" alt="image" src="https://github.com/user-attachments/assets/c3fcebb0-641e-4b61-9e56-9e44b2a56a24" />

   Log Makan
   <img width="1101" height="677" alt="image" src="https://github.com/user-attachments/assets/4019c17a-cb10-4534-a5cd-0feb50672373" />

   Jadwal Makan
   <img width="1102" height="687" alt="image" src="https://github.com/user-attachments/assets/d2cf17c8-0cd9-4222-bc1d-f90e02b1d89c" />

   Keluar
   <img width="1100" height="683" alt="image" src="https://github.com/user-attachments/assets/81c26542-f9f5-4e62-9eb6-609e0d64b496" />

4. Output Console
   Profil
   <img width="391" height="408" alt="image" src="https://github.com/user-attachments/assets/501b2555-a5d1-4c97-9e65-593348b88463" />

   Tambah Makan
<img width="301" height="235" alt="image" src="https://github.com/user-attachments/assets/fdfccea9-eccf-4ecf-8664-ee1a79de29a3" />

 Log


   Keluar
<img width="482" height="192" alt="image" src="https://github.com/user-attachments/assets/3351be33-50a0-427d-aadb-ae412ad161e4" />

📚 Implementasi Materi Sebelum UTS (2 Materi Wajib)
🔐 1. Encapsulation (User, Food, Schedule, MealLog)
Semua atribut bersifat private.

Akses menggunakan getter & setter.

Contoh implementasi:

private String nama;
public String getNama() { return nama; }
➡ Digunakan untuk menyimpan dan melindungi data user dan makanan.

🏗️ 2. Class & Object
Setiap fitur dibuat menjadi objek berbeda:

Class	Fungsi
User	Menyimpan data profil pengguna
Food	Menyimpan info makanan
MealLog	Menyimpan daftar makanan (ArrayList)
Schedule	Menyimpan status jadwal makan
➡ OOP membuat program terstruktur, rapi, dan mudah dikembangkan.

📎 Materi Setelah UTS (Non-GUI) – Wajib 1
📄 File I/O (FileWriter)
Saat pengguna klik Keluar, program otomatis menyimpan log ke file .txt.

📌 Contoh hasil file:

=== LOG MAKAN HARI INI ===
Nasi Goreng | 350 kkal | Pagi
Teh Manis | 120 kkal | Siang
Total Kalori: 470 kkal
📌 Contoh kode:

FileWriter writer = new FileWriter("mealLog_" + LocalDate.now() + ".txt");
writer.write(...);
writer.close();
📌 Manfaat:

Data tidak hilang meskipun aplikasi ditutup.

Bisa dibaca ulang sebagai riwayat makan sehat.

👥 Tim Pengembang
Contributors
Nama	NIM
Fidela Novelia            L0324012
Laely Nisrina             L0324019
Nazwa Nur Aisyiyah Jafni  L0324029
