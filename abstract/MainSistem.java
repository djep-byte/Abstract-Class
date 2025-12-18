import java.util.ArrayList;

public class MainSistem {
    public static void main(String[] args) {

        Manusia manusia = new Manusia("Homo Sapiens");
        Hewan hewan = new Hewan("Kucing (Felis catus)");
        Tumbuhan tumbuhan = new Tumbuhan("Pohon Mangga (Mangifera indica)");

        System.out.println("--- DEMO MANUSIA ---");
        System.out.println("Spesies: " + manusia.getNamaSpesies());
        manusia.bernafas(); 
        manusia.makan();    
        manusia.tumbuh();   
        manusia.berpikir(); 

        System.out.println("\n--- DEMO HEWAN ---");
        System.out.println("Spesies: " + hewan.getNamaSpesies());
        hewan.bernafas();   
        hewan.makan();      
        hewan.tumbuh();    
        hewan.bergerak();  

        System.out.println("\n--- DEMO TUMBUHAN ---");
        System.out.println("Spesies: " + tumbuhan.getNamaSpesies());
        tumbuhan.bernafas();
        tumbuhan.makan();    
        tumbuhan.tumbuh();   
        
        System.out.println("\n--- DEMO POLIMORFISME ---");
        ArrayList<MakhlukHidup> daftarMakhluk = new ArrayList<>();
        daftarMakhluk.add(manusia);
        daftarMakhluk.add(hewan);
        daftarMakhluk.add(tumbuhan);

        for (MakhlukHidup mh : daftarMakhluk) {
            System.out.println("--- Memproses: " + mh.getNamaSpesies() + " ---");
            mh.bernafas(); 
            mh.makan();
            System.out.println();
        }
    }
}