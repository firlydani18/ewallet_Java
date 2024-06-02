package ewallet;


class Customer {
    private String nama;
    private String alamat;
    private Ewallet ewallet;

    public Customer(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
        this.ewallet = new Ewallet();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public Ewallet getEwallet() {
        return ewallet;
    }
}
