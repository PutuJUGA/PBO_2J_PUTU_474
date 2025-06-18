package App;
import Library.Anggota;
import Library.Buku;
import Library.Fiksi;
import Library.NonFiksi;
public class Main {
    public static void main(String[] args) {
        Buku revolusi = new NonFiksi("Madilok", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku lautBercerita = new Fiksi("Halinuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");
        Anggota Putu = new Anggota("Putu Bawa Givrant Januarta", "202410370110474");
        Anggota Japong = new Anggota("Ramadhan Zhafran Lillah Illham", "202410370110454");
        System.out.println("=== INFORMASI BUKU ===");
        revolusi.displayInfo();
        System.out.println();
        lautBercerita.displayInfo();
        System.out.println("\n=== DATA ANGGOTA ===");
        System.out.printf("- ");
        Putu.displayInfo();
        System.out.printf("- ");
        Japong.displayInfo();
        System.out.println("\n=== PROSES PEMINJAMAN ===");
        System.out.println("[Putu] ");
        System.out.printf(" - ");
        Putu.pinjamBuku("Madilok");
        System.out.println("\n[Japong] ");
        System.out.printf(" - ");
        Japong.pinjamBuku("Halinuwele", 7);
        System.out.println("\n=== PROSES PENGEMBALIAN ===");
        System.out.println("[Putu] ");
        System.out.printf(" - ");
        Putu.kembalikanBuku("Madilok");
        System.out.println("\n[Japong] ");
        System.out.printf(" - ");
        Japong.kembalikanBuku("Halinuwele");
        System.out.println("\n=== PROGRAM SELESAI ===");
    }
}