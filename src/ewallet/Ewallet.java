package ewallet;

import java.util.ArrayList;
import java.util.List;

class Ewallet {
    private double saldo;
    private List<Transaction> transactions;

    public Ewallet() {
        this.saldo = 0.0;
        this.transactions = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void topup(double nominal, Customer customer, String nomorReferensi, String metodePembayaran) {
        this.saldo += nominal;
        Topup topup = new Topup(nominal, customer, nomorReferensi, metodePembayaran);
        transactions.add(topup);
    }

    public void transfer(double nominal, Customer pengirim, Customer penerima) {
        if (saldo >= nominal) {
            this.saldo -= nominal;
            Transfer transfer = new Transfer(nominal, pengirim, penerima);
            transactions.add(transfer);
            penerima.getEwallet().receiveTransfer(nominal, transfer);
        } else {
            System.out.println("Saldo tidak mencukupi untuk transfer.");
        }
    }

    public void receiveTransfer(double nominal, Transfer transfer) {
        this.saldo += nominal;
        transactions.add(transfer);
    }

    public void cekSaldo() {
        System.out.println("Saldo: " + saldo);
    }

    public void cetakTransaksi() {
        for (Transaction transaction : transactions) {
            transaction.cetakInformasiTransaksi();
        }
    }
}