public class PopulationCounter {
    private String label;
    private int total;

    public PopulationCounter(String label) {
        this.label = label;
        this.total = 0;
    }

    public String getLabel() {
        return label;
    }

    public int getTotal() {
        return total;
    }

    public void increase() {
        total++;
    }

    public void clear() {
        total = 0;
    }
}