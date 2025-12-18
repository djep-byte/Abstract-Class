public class SimulatorDisplay {
    private FieldStats metrics;
    private int rows, columns;

    public SimulatorDisplay(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.metrics = new FieldStats();
    }

    public void assignColor(Class type, String color) {
        // Metode ini bisa diperluas jika menggunakan GUI, tapi untuk console diabaikan.
    }

    public boolean isSustainable(Field grid) {
        return true;  // Asumsi selalu berkelanjutan untuk simulasi sederhana.
    }

    public void updateStatus(int cycle, Field grid) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Siklus Simulasi: " + cycle);
        System.out.println("=============================");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                Animal animal = grid.getAnimalAt(r, c);
                if (animal instanceof Fox) {
                    System.out.print(" F ");
                } else if (animal instanceof Rabbit) {
                    System.out.print(" R ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println("=============================");

        metrics.updateCounts(grid);
        System.out.println(metrics.getSummary());

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            // Abaikan kesalahan.
        }
    }
}