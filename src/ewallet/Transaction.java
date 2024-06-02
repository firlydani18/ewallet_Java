package ewallet;


import java.util.Date;

abstract class Transaction {
    protected double nominal;
    protected Date tanggal;
    protected Customer customer;

    public Transaction(double nominal, Customer customer) {
        this.nominal = nominal;
        this.customer = customer;
        this.tanggal = new Date();
    }

    public double getNominal() {
        return nominal;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public abstract void cetakInformasiTransaksi();
}
