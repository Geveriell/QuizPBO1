public class Demo2 {
    public static void main(String[] args) {
        KartuKantin k1 = new KartuKantin("KK-001", "rusdi");
        KartuKantin k2 = new KartuKantin("KK-002", "Hendra");

        System.out.println("\nKondisi awal");
        k1.displayInfo();
        k2.displayInfo();

        System.out.println("\nTop up");
        k1.topUp(100000);
        k2.topUp(20000);
        k1.topUp(0);     
        k1.topUp(-5000);    

        System.out.println("\nBayar");
        k1.bayar(15000);
        k2.bayar(30000);
        k2.bayar(0); 
        k2.bayar(-2000);    
        k2.bayar(20000);

        System.out.println("\nKategori saldo");
        k1.bayar(60000);
        System.out.println("Rp" + k1.getSaldo() + " - " + k1.getKategoriSaldo());
        k1.bayar(1);
        System.out.println("Rp" + k1.getSaldo() + " - " + k1.getKategoriSaldo());
        k1.topUp(75001);
        System.out.println("Rp" + k1.getSaldo() + " - " + k1.getKategoriSaldo());

        System.out.println("\nKondisi akhir");
        k1.displayInfo();
        k2.displayInfo();
    }
}