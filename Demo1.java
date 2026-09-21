public class Demo1 {
    public static void main(String[] args) {
        Kendaraan k1 = new Kendaraan(" ABCD ", "Mobil");
        Kendaraan k2 = new Kendaraan(" FGHI ", "Motor");
        Kendaraan k3 = new Kendaraan(" JKLM ", "Motor");

        System.out.println("\nKondisi awal ");
        k1.displayInfo();
        k2.displayInfo();
        k3.displayInfo();

        System.out.println("\nTransaksi berhasil (masuk 8, keluar 13, durasi 5 jam)");
        System.out.println("Total : Rp9000 ");
        k1.masuk(8);
        k1.keluar(13);
        k1.displayInfo();

        System.out.println("\nMasuk dua kali (harus ditolak)");
        k2.masuk(9);
        k2.masuk(10);
        k2.displayInfo();

        System.out.println("\nKeluar sebelum masuk (harus ditolak)");
        k3.keluar(12);
        k3.displayInfo();

        System.out.println("\nJam keluar lebih kecil dari jam masuk (masuk 9, keluar 7, harus ditolak) ===");
        k2.keluar(7);
        k2.displayInfo();

        System.out.println("\nJam di luar rentang 0-23 (harus ditolak)");
        k3.masuk(25);
        k3.masuk(-1);
        k1.keluar(24);

        System.out.println("\nBatas tarif (masuk 10, keluar 12, durasi 2 jam)");
        System.out.println("Total : Rp3000 ");
        k3.masuk(10);
        k3.keluar(12);
        k3.displayInfo();

        System.out.println("\nTransaksi berhasil (masuk 9, keluar 10, durasi 1 jam)");
        System.out.println("Total : Rp3000 ");
        k2.keluar(10);
        k2.displayInfo();

        System.out.println("\nKendaraan parkir lagi setelah keluar (masuk 14)");
        k1.masuk(14);
        k1.displayInfo();

        System.out.println("\nKondisi akhir");
        k1.displayInfo();
        k2.displayInfo();
        k3.displayInfo();
    }
}