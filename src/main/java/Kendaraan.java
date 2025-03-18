public class Kendaraan {
    private String jenis;
    private String bahanBakar;
    private int jumlahRoda;
    public Kendaraan(String jenis,
                     String bahanBakar,
                     int jumlahRoda) {
        this.jenis = jenis;
        this.bahanBakar = bahanBakar;
        this.jumlahRoda = jumlahRoda;
    }

    public boolean isRamahLingkungan() {
        return bahanBakar.equalsIgnoreCase("listrik") ||
                bahanBakar.equalsIgnoreCase("hidrogen") ||
                bahanBakar.equalsIgnoreCase("-");
    }

    public boolean isSepeda() {
        return jenis.
                equalsIgnoreCase("sepeda") &&
                jumlahRoda == 2;
    }

    public int getJumlahRoda() {
        return jumlahRoda;
    }
    public String getJenis() {
        return jenis;
    }
    public String getBahanBakar() {
        return bahanBakar;
    }

    public boolean isBermotor() {
        return !jenis.equalsIgnoreCase("sepeda") &&
                !bahanBakar.equals("-");
    }

    public boolean isTransportasiUmum() {
        return jenis.equalsIgnoreCase("bus") ||
                jenis.equalsIgnoreCase("angkot") ||
                jenis.equalsIgnoreCase("kereta");
    }
}

