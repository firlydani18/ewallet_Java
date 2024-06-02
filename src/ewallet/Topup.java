package ewallet;


class Topup extends Transaction {
    private String nomorReferensi;
    private String metodePembayaran;

    public Topup(double nominal, Customer customer, String nomorReferensi, String metodePembayaran) {
        super(nominal, customer);
        this.nomorReferensi = nomorReferensi;
        this.metodePembayaran = metodePembayaran;
    }

    @Override
    public void cetakInformasiTransaksi() {
        System.out.println("Topup:");
        System.out.println("Nominal: " + nominal);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Customer: " + customer.getNama());
        System.out.println("Nomor Referensi: " + nomorReferensi);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
    }
}