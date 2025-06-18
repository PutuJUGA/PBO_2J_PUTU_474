package com.praktikum.main;

import java.util.Scanner;
import com.praktikum.users.*;
import com.praktikum.data.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Scanner input = new Scanner(System.in);

        Admin admin = new Admin("Admin UMM", "ADM474");
        Mahasiswa mahasiswa = new Mahasiswa("Putu Bawa Givrant Januarta", "202410370110474");
        userList.add(admin);
        userList.add(mahasiswa);

        User user = null;
        System.out.println("++++++++++++PILIH LOGIN++++++++++++");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("===================================");
        System.out.print("Pilih siapa kamu : ");
        int pilih = 0;
        try {
            pilih = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            input.nextLine();
        }

        String username, password, nama, nim;
        switch (pilih) {
            case 1:
                System.out.println("\nMasuk ke Halaman Admin");
                System.out.print("Masukkan username: ");
                username = input.nextLine();
                System.out.print("Masukkan Password: ");
                password = input.nextLine();
                for (User u : userList) {
                    if (u instanceof Admin) {
                        Admin a = (Admin) u;
                        if (a.username.equals(username) && a.password.equals(password)) {
                            user = a;
                            System.out.println("Login Admin Berhasil!");
                            break;

                        }
                    }
                }
                if (user == null) {
                    System.out.println("Login gagal! ERROR");
                }
                break;
            case 2:
                System.out.println("\nMasuk ke Halaman Mahasiswa");
                System.out.print("Masukkan nama: ");
                nama = input.nextLine();
                System.out.print("Masukkan NIM: ");
                nim = input.nextLine();
                for (User u : userList) {
                    if (u instanceof Mahasiswa) {
                        Mahasiswa m = (Mahasiswa) u;
                        if (m.getNama().equals(nama) && m.getNim().equals(nim)) {
                            user = m;
                            System.out.println("Login Mahasiswa Berhasil!");
                            break;
                        }
                    }
                }
                if (user == null) {
                    System.out.println("Login gagal! ERROR");
                }
                break;
            case 0:
                System.out.println("Salah input");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }

        if (user != null) {
            user.displayInfo();
            user.displayAppMenu();
        }

        input.close();
    }
}