package com.enigmacamp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TempatParkir tempatParkir = null;

        while (true) {
            // Menampilkan daftar perintah yang bisa digunakan, termasuk menu baru
            System.out.println("\nDaftar Perintah yang Tersedia:");
            System.out.println("1. buat_tempat_parkir <jumlah_slot>");
            System.out.println("2. parkir <nomor_registrasi> <warna> <tipe_kendaraan>");
            System.out.println("3. keluar <nomor_slot>");
            System.out.println("4. status");
            System.out.println("5. tipe_kendaraan <tipe_kendaraan>");
            System.out.println("6. nomor_registrasi_ganjil");
            System.out.println("7. nomor_registrasi_genap");
            System.out.println("8. nomor_registrasi_berdasarkan_warna <warna_kendaraan>");
            System.out.println("9. nomor_slot_berdasarkan_nomor_registrasi <nomor_registrasi>");
            System.out.println("10. nomor_slot_berdasarkan_warna <warna_kendaraan>"); // Menu baru
            System.out.println("11. keluar_program");
            System.out.print("\nMasukkan perintah: ");

            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "buat_tempat_parkir":
                    int totalSlot = Integer.parseInt(parts[1]);
                    tempatParkir = new TempatParkir(totalSlot);
                    System.out.println("Membuat tempat parkir dengan " + totalSlot + " slot");
                    break;

                case "parkir":
                    String regNumber = parts[1];
                    String warna = parts[2];
                    String tipe = parts[3];
                    tempatParkir.parkirKendaraan(new Kendaraan(regNumber, warna, tipe));
                    break;

                case "keluar":
                    int nomorSlot = Integer.parseInt(parts[1]);
                    tempatParkir.keluar(nomorSlot);
                    break;

                case "status":
                    tempatParkir.status();
                    break;

                case "tipe_kendaraan":
                    String tipeKendaraan = parts[1];
                    tempatParkir.kendaraanBerdasarkanTipe(tipeKendaraan);
                    break;

                case "nomor_registrasi_ganjil":
                    tempatParkir.kendaraanDenganPlatGanjilGenap("ganjil");
                    break;

                case "nomor_registrasi_genap":
                    tempatParkir.kendaraanDenganPlatGanjilGenap("genap");
                    break;

                case "nomor_registrasi_berdasarkan_warna":
                    String warnaKendaraan = parts[1];
                    tempatParkir.kendaraanBerdasarkanWarna(warnaKendaraan);
                    break;

                case "nomor_slot_berdasarkan_nomor_registrasi":
                    String regNum = parts[1];
                    int slot = tempatParkir.slotUntukNomorRegistrasi(regNum);
                    if (slot == -1) {
                        System.out.println("Tidak ditemukan");
                    } else {
                        System.out.println(slot);
                    }
                    break;

                case "nomor_slot_berdasarkan_warna": // Opsi baru
                    String warnaSlot = parts[1];
                    tempatParkir.slotUntukWarna(warnaSlot);
                    break;

                case "keluar_program":
                    System.out.println("Program selesai.");
                    return;

                default:
                    System.out.println("Perintah tidak valid");
                    break;
            }
        }
    }
}