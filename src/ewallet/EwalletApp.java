package ewallet;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class EwalletApp {
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Tambah Akun");
            System.out.println("2. Topup");
            System.out.println("3. Transfer");
            System.out.println("4. Cek Saldo");
            System.out.println("5. Cetak Transaksi");
            System.out.println("6. Keluar");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    tambahAkun();
                    break;
                case 2:
                    topup();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    cekSaldo();
                    break;
                case 5:
                    cetakTransaksi();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahAkun() {
        System.out.println("Masukkan Nama:");
        String nama = scanner.nextLine();
        System.out.println("Masukkan Alamat:");
        String alamat = scanner.nextLine();
        customers.add(new Customer(nama, alamat));
        System.out.println("Akun berhasil ditambahkan.");
    }

    private static void topup() {
        Customer customer = pilihCustomer();
        if (customer != null) {
            System.out.println("Masukkan Nominal:");
            double nominal = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.println("Masukkan Nomor Referensi:");
            String nomorReferensi = scanner.nextLine();
            System.out.println("Masukkan Metode Pembayaran:");
            String metodePembayaran = scanner.nextLine();
            customer.getEwallet().topup(nominal, customer, nomorReferensi, metodePembayaran);
            System.out.println("Topup berhasil.");
        }
    }

    private static void transfer() {
        Customer pengirim = pilihCustomer();
        if (pengirim != null) {
            System.out.println("Masukkan Nama Penerima:");
            String namaPenerima = scanner.nextLine();
            Customer penerima = cariCustomer(namaPenerima);
            if (penerima != null) {
                System.out.println("Masukkan Nominal:");
                double nominal = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                pengirim.getEwallet().transfer(nominal, pengirim, penerima);
                System.out.println("Transfer berhasil.");
            } else {
                System.out.println("Customer penerima tidak ditemukan.");
            }
        }
    }

    private static void cekSaldo() {
        Customer customer = pilihCustomer();
        if (customer != null) {
            customer.getEwallet().cekSaldo();
        }
    }

    private static void cetakTransaksi() {
        Customer customer = pilihCustomer();
        if (customer != null) {
            customer.getEwallet().cetakTransaksi();
        }
    }

    private static Customer pilihCustomer() {
        System.out.println("Masukkan Nama Customer:");
        String nama = scanner.nextLine();
        return cariCustomer(nama);
    }

    private static Customer cariCustomer(String nama) {
        for (Customer customer : customers) {
            if (customer.getNama().equalsIgnoreCase(nama)) {
                return customer;
            }
        }
        System.out.println("Customer tidak ditemukan.");
        return null;
    }
}