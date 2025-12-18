public abstract class MakhlukHidup {
    
    protected String namaSpesies;

    public MakhlukHidup(String namaSpesies) {
        this.namaSpesies = namaSpesies;
    }

    public abstract void bernafas();

    public abstract void makan();

    public void tumbuh() {
        System.out.println(this.namaSpesies + " sedang tumbuh.");
    }

    public String getNamaSpesies() {
        return this.namaSpesies;
    }
}