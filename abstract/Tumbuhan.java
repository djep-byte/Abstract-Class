public class Tumbuhan extends MakhlukHidup {

    public Tumbuhan(String namaSpesies) {
        super(namaSpesies);
    }

    @Override
    public void bernafas() {
        System.out.println(this.namaSpesies + " berespirasi melalui stomata dan lentisel.");
    }

    @Override
    public void makan() {
        System.out.println(this.namaSpesies + " 'makan' dengan cara fotosintesis (membuat makanan sendiri).");
    }

    @Override
    public void tumbuh() {
        System.out.println(this.namaSpesies + " tumbuh ke arah sumber cahaya.");
    }
}