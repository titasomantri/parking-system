package com.enigmacamp;

public class SlotParkir {
    int nomorSlot;
    Kendaraan kendaraan;

    public SlotParkir(int nomorSlot) {
        this.nomorSlot = nomorSlot;
    }

    public boolean tersedia() {
        return kendaraan == null;
    }

    public void parkirKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public void keluar() {
        this.kendaraan = null;
    }
}
