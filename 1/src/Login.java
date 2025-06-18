import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String adminUsername = "Admin474";
        String adminPassword = "Pass474";
        String mahasiswaNama = "Putu Bawa Givrant Januarta";
        String mahasiswaNim = "202410370110474";

        System.out.println("=== SISTEM LOGIN SEDERHANA ===");
        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1/2): ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.println("\n=== LOGIN ADMIN ===");
            System.out.print("Masukkan Username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Masukkan Password: ");
            String inputPassword = scanner.nextLine();

            if (inputUsername.equals(adminUsername) && inputPassword.equals(adminPassword)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (pilihan == 2) {
            System.out.println("\n=== LOGIN MAHASISWA ===");
            System.out.print("Masukkan Nama: ");
            String inputNama = scanner.nextLine();

            System.out.print("Masukkan NIM: ");
            String inputNim = scanner.nextLine();

            if (inputNama.equals(mahasiswaNama) && inputNim.equals(mahasiswaNim)) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + inputNama);
                System.out.println("NIM: " + inputNim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}