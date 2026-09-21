public class KartuKantin {
    private String idKartu;
    private String namaPemilik;
    private int saldo;
    private int jumlahTransaksi;

    public KartuKantin(String idKartu, String namaPemilik) {
        this.idKartu = idKartu;
        this.namaPemilik = namaPemilik;
        this.saldo = 0;
        this.jumlahTransaksi = 0;
    }

    public void topUp(int nominal) {
        if (nominal <= 0) {
            System.out.println(idKartu + " top up Rp" + nominal
                    + " ditolak, nominal harus lebih dari 0");
        } else {
            this.saldo += nominal;
            System.out.println(idKartu + " top up Rp" + nominal
                    + " berhasil, saldo Rp" + saldo);
        }
    }

    public void bayar(int nominal) {
        if (nominal <= 0) {
            System.out.println(idKartu + " bayar Rp" + nominal
                    + " ditolak, nominal harus lebih dari 0");
        } else if (nominal > saldo) {
            System.out.println(idKartu + " bayar Rp" + nominal
                    + " ditolak, saldo Rp" + saldo + " tidak cukup");
        } else {
            this.saldo -= nominal;
            this.jumlahTransaksi++;
            System.out.println(idKartu + " bayar Rp" + nominal
                    + " berhasil, saldo Rp" + saldo);
        }
    }

    public String getKategoriSaldo() {
        if (saldo < 25000) {
            return "RENDAH";
        } else if (saldo < 100000) {
            return "SEDANG";
        } else {
            return "TINGGI";
        }
    }

    public String getIdKartu() {
        return idKartu;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void displayInfo() {
        System.out.println(idKartu + " | " + namaPemilik + " | Rp" + saldo
                + " | " + getKategoriSaldo() + " | " + jumlahTransaksi + " transaksi");
    }
}