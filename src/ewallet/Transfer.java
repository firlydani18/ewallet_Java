package ewallet;


class Transfer extends Transaction {
    private Customer penerima;

    public Transfer(double nominal, Customer pengirim, Customer penerima) {
        super(nominal, pengirim);
        this.penerima = penerima;
    }

    public Customer getPenerima() {
        return penerima;
    }

    @Override
    public void cetakInformasiTransaksi() {
        System.out.println("Transfer:");
        System.out.println("Nominal: " + nominal);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Pengirim: " + customer.getNama());
        System.out.println("Penerima: " + penerima.getNama());
    }
}
