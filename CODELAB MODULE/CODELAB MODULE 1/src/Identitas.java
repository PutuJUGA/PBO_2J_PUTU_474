import java.util.Scanner;
import java.time.LocalDate;
public class Identitas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.println("Masukkan Jenis Kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);
        System.out.println("Masukkan Tahu Lahir: ");
        int tahunlahir = scanner.nextInt();

        scanner.close();

        int tahunnow = LocalDate.now().getYear();
        int umur = tahunnow - tahunlahir;

        String kelamin ;
        if (jenisKelamin == 'L' || jenisKelamin == 'l'){
            kelamin = "Laki-laki";
        } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
            kelamin = "Perempuan";
        } else {
            kelamin = "Tidak Diketahui";
        }

        System.out.println("\n=== Data Diri ===");
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur         : " + umur + " tahun");
        }
    }
