public class Hewan extends MakhlukHidup {

    public Hewan(String namaSpesies) {
        super(namaSpesies);
    }

    @Override
    public void bernafas() {
        System.out.println(this.namaSpesies + " bernafas (bisa dengan paru-paru, insang, trakea, dll).");
    }

    @Override
    public void makan() {
        System.out.println(this.namaSpesies + " makan (bisa karnivora, herbivora, atau omnivora).");
    }

    public void bergerak() {
        System.out.println(this.namaSpesies + " bergerak aktif untuk berpindah tempat.");
    }
}