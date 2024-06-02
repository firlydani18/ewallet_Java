# Ewallet CLI Application

## Overview
Ewallet CLI Application adalah aplikasi sederhana berbasis Command Line Interface (CLI) yang memungkinkan pengguna untuk menambahkan akun, membuat ewallet, melakukan transaksi topup, dan transfer.

## Features
- Menambahkan data akun
- Membuat ewallet
- Melakukan transaksi topup
- Melakukan transaksi transfer
- Mengecek saldo ewallet
- Mencetak riwayat transaksi

## Class Descriptions

### Customer
- **Attributes:**
  - `String nama`
  - `String alamat`
  - `Ewallet ewallet`
- **Methods:**
  - `getNama()`, `setNama(String nama)`
  - `getAlamat()`
  - `getEwallet()`

### Ewallet
- **Attributes:**
  - `double saldo`
  - `List<Transaction> transactions`
- **Methods:**
  - `getSaldo()`
  - `topup(double nominal, Customer customer, String nomorReferensi, String metodePembayaran)`
  - `transfer(double nominal, Customer pengirim, Customer penerima)`
  - `cekSaldo()`
  - `cetakTransaksi()`

### Abstract Class Transaction
- **Attributes:**
  - `double nominal`
  - `Date tanggal`
  - `Customer customer`
- **Methods:**
  - `getNominal()`
  - `getTanggal()`
  - `getCustomer()`
  - `cetakInformasi()`

### Topup (Inherits Transaction)
- **Attributes:**
  - `String nomorReferensi`
  - `String metodePembayaran`
- **Methods:**
  - `cetakInformasi()`

### Transfer (Inherits Transaction)
- **Attributes:**
  - `Customer penerima`
- **Methods:**
  - `cetakInformasi()`

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- IDE or text editor of your choice

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/ewallet-cli-app.git
   ```
2. Navigate to the project directory:
   ```sh
   cd ewallet-cli-app
   ```

### Usage
1. Compile the Java files:
   ```sh
   javac EwalletApp.java
   ```
2. Run the application:
   ```sh
   java EwalletApp
   ```

### Example Workflow
1. Tambahkan akun:
   ```
   1. Tambah Akun
   Masukkan Nama: John Doe
   Masukkan Alamat: 123 Main St
   Akun berhasil ditambahkan.
   ```
2. Topup saldo:
   ```
   2. Topup
   Masukkan Nama Customer: John Doe
   Masukkan Nominal: 1000
   Masukkan Nomor Referensi: REF123
   Masukkan Metode Pembayaran: Credit Card
   Topup berhasil.
   ```
3. Transfer saldo:
   ```
   3. Transfer
   Masukkan Nama Customer: John Doe
   Masukkan Nama Penerima: Jane Doe
   Masukkan Nominal: 500
   Transfer berhasil.
   ```
4. Cek saldo:
   ```
   4. Cek Saldo
   Masukkan Nama Customer: John Doe
   Saldo: 500
   ```
5. Cetak riwayat transaksi:
   ```
   5. Cetak Transaksi
   Masukkan Nama Customer: John Doe
   Topup:
   Nominal: 1000
   Tanggal: Sun Jun 02 10:00:00 UTC 2024
   Customer: John Doe
   Nomor Referensi: REF123
   Metode Pembayaran: Credit Card

   Transfer:
   Nominal: 500
   Tanggal: Sun Jun 02 10:05:00 UTC 2024
   Pengirim: John Doe
   Penerima: Jane Doe
   ```
