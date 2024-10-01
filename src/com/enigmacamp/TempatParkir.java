package com.enigmacamp;

import java.util.*;

public class TempatParkir {
    SlotParkir[] slot;

    public TempatParkir(int totalSlot) {
        slot = new SlotParkir[totalSlot];
        for (int i = 0; i < totalSlot; i++) {
            slot[i] = new SlotParkir(i + 1);
        }
    }

    public void parkirKendaraan(Kendaraan kendaraan) {
        for (SlotParkir slotParkir : slot) {
            if (slotParkir.tersedia()) {
                slotParkir.parkirKendaraan(kendaraan);
                System.out.println("Slot nomor: " + slotParkir.nomorSlot);
                return;
            }
        }
        System.out.println("Maaf, tempat parkir penuh");
    }

    public void keluar(int nomorSlot) {
        if (nomorSlot > 0 && nomorSlot <= slot.length) {
            SlotParkir slotParkir = slot[nomorSlot - 1];
            if (!slotParkir.tersedia()) {
                slotParkir.keluar();
                System.out.println("Slot nomor " + nomorSlot + " kosong");
            } else {
                System.out.println("Slot nomor " + nomorSlot + " sudah kosong");
            }
        } else {
            System.out.println("Nomor slot tidak valid");
        }
    }

    public void status() {
        System.out.println("Slot No.    No Registrasi    Tipe    Warna");
        for (SlotParkir slotParkir : slot) {
            if (!slotParkir.tersedia()) {
                System.out.printf("%d           %s            %s    %s\n",
                        slotParkir.nomorSlot,
                        slotParkir.kendaraan.nomorRegistrasi,
                        slotParkir.kendaraan.tipe,
                        slotParkir.kendaraan.warna);
            }
        }
    }

    public void kendaraanBerdasarkanTipe(String tipe) {
        long jumlah = Arrays.stream(slot)
                .filter(slotParkir -> !slotParkir.tersedia() && slotParkir.kendaraan.tipe.equalsIgnoreCase(tipe))
                .count();
        System.out.println(jumlah);
    }

    public void kendaraanBerdasarkanWarna(String warna) {
        List<String> nomorRegistrasi = new ArrayList<>();
        for (SlotParkir slotParkir : slot) {
            if (!slotParkir.tersedia() && slotParkir.kendaraan.warna.equalsIgnoreCase(warna)) {
                nomorRegistrasi.add(slotParkir.kendaraan.nomorRegistrasi);
            }
        }
        System.out.println(String.join(" ", nomorRegistrasi));
    }

    public void kendaraanDenganPlatGanjilGenap(String tipe) {
        List<String> nomorRegistrasi = new ArrayList<>();
        for (SlotParkir slotParkir : slot) {
            if (!slotParkir.tersedia()) {
                String regNumber = slotParkir.kendaraan.nomorRegistrasi;
                char lastChar = regNumber.charAt(regNumber.length() - 1);
                int lastDigit = Character.getNumericValue(lastChar);

                if ((tipe.equals("ganjil") && lastDigit % 2 != 0) ||
                        (tipe.equals("genap") && lastDigit % 2 == 0)) {
                    nomorRegistrasi.add(regNumber);
                }
            }
        }
        System.out.println(String.join(" ", nomorRegistrasi));
    }

    public int slotUntukNomorRegistrasi(String regNumber) {
        for (SlotParkir slotParkir : slot) {
            if (!slotParkir.tersedia() && slotParkir.kendaraan.nomorRegistrasi.equals(regNumber)) {
                return slotParkir.nomorSlot;
            }
        }
        return -1;
    }

    public void slotUntukWarna(String warna) {
        List<Integer> slotNomor = new ArrayList<>();
        for (SlotParkir slotParkir : slot) {
            if (!slotParkir.tersedia() && slotParkir.kendaraan.warna.equalsIgnoreCase(warna)) {
                slotNomor.add(slotParkir.nomorSlot);
            }
        }
        if (slotNomor.isEmpty()) {
            System.out.println("Tidak ada kendaraan dengan warna " + warna);
        } else {
            System.out.println("Slot nomor untuk kendaraan dengan warna " + warna + ": " + slotNomor);
        }
    }
}