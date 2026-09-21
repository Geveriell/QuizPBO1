public class Kendaraan {

    private String plat;
    private String jenis;
    private boolean sedangParkir;
    private int jamMasuk;
    private int jamKeluar;
    private int biaya;
    private int jumlahTransaksi;


    public Kendaraan(String plat, String jenis) {
        this.plat = plat;
        this.jenis = jenis;
        this.sedangParkir = false;
        this.jamMasuk = -1;    
        this.jamKeluar = -1;
        this.biaya = 0;
        this.jumlahTransaksi = 0;
    }

    private boolean cekJam(int jam) {
        return jam >= 0 && jam <= 23;
    }

    public void masuk(int jam) {
        if (!cekJam(jam)) {
            System.out.println("[DITOLAK] Maaf, jam " + jam
                    + " tidak valid. Jam harus antara 0 sampai 23.");
        } else if (sedangParkir) {
            System.out.println("[DITOLAK] Maaf, kendaraan " + plat
                    + " masih berada di area parkir, tidak bisa masuk lagi.");
        } else {
            this.jamMasuk = jam;
            this.jamKeluar = -1;
            this.biaya = 0;
            this.sedangParkir = true;
            System.out.println("[BERHASIL] Kendaraan " + plat
                    + " masuk pada jam " + jam + ".");
        }
    }

    public void keluar(int jam) {
        if (!cekJam(jam)) {
            System.out.println("[DITOLAK] Maaf, jam " + jam
                    + " tidak valid. Jam harus antara 0 sampai 23.");
        } else if (!sedangParkir) {
            System.out.println("[DITOLAK] Maaf, kendaraan " + plat
                    + " belum masuk, tidak bisa keluar.");
        } else if (jam < jamMasuk) {
            System.out.println("[DITOLAK] Maaf, jam keluar (" + jam
                    + ") tidak boleh lebih kecil dari jam masuk (" + jamMasuk + ").");
        } else {
            this.jamKeluar = jam;
            this.biaya = hitungBiaya(jamKeluar - jamMasuk);
            this.sedangParkir = false;
            this.jumlahTransaksi++;
            System.out.println("[BERHASIL] Kendaraan " + plat
                    + " keluar pada jam " + jam + ". Biaya parkir: Rp" + biaya);
        }
    }
    private int hitungBiaya(int durasi) {
        int tarifDuaJamPertama = 3000;
        int tarifJamBerikutnya = 2000;
        int biayaTotal = tarifDuaJamPertama;

        if (durasi > 2) {
            biayaTotal += (durasi - 2) * tarifJamBerikutnya;
        }
        return biayaTotal;
    }

    public String getPlat() {
        return plat;
    }

    public String getJenis() {
        return jenis;
    }

    public boolean isSedangParkir() {
        return sedangParkir;
    }

    public int getJamMasuk() {
        return jamMasuk;
    }

    public int getJamKeluar() {
        return jamKeluar;
    }

    public int getBiaya() {
        return biaya;
    }

    public int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void displayInfo() {
        System.out.println("Plat       : " + plat);
        System.out.println("Jenis      : " + jenis);
        if (sedangParkir) {
            System.out.println("Status     : SEDANG PARKIR");
        } else {
            System.out.println("Status     : TIDAK PARKIR");
        }
        System.out.println("Jam masuk  : " + (jamMasuk >= 0 ? String.valueOf(jamMasuk) : "-"));
        System.out.println("Jam keluar : " + (jamKeluar >= 0 ? String.valueOf(jamKeluar) : "-"));
        System.out.println("Biaya      : Rp" + biaya);
        System.out.println("Transaksi  : " + jumlahTransaksi + " x selesai");
        System.out.println("========================");
    }
}