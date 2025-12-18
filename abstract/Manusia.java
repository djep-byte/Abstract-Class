public class Manusia extends MakhlukHidup {

    public Manusia(String namaSpesies) {
        super(namaSpesies);
    }

    @Override
    public void bernafas() {
        System.out.println(this.namaSpesies + " bernafas menggunakan paru-paru.");
    }

    @Override
    public void makan() {
        System.out.println(this.namaSpesies + " makan nasi, sayur, dan daging (omnivora).");
    }

    public void berpikir() {
        System.out.println(this.namaSpesies + " mampu berpikir secara kompleks.");
    }
}