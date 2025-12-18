public class FieldStats {
    private PopulationCounter foxPop;
    private PopulationCounter rabbitPop;
    private boolean statsValid;

    public FieldStats() {
        foxPop = new PopulationCounter("Foxes");
        rabbitPop = new PopulationCounter("Rabbits");
        statsValid = true;
    }

    public void updateCounts(Field grid) {
        foxPop.clear();
        rabbitPop.clear();
        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getColumns(); c++) {
                Animal animal = grid.getAnimalAt(r, c);
                if (animal != null) {
                    if (animal instanceof Fox) {
                        foxPop.increase();
                    } else if (animal instanceof Rabbit) {
                        rabbitPop.increase();
                    }
                }
            }
        }
        statsValid = true;
    }

    public String getSummary() {
        if (!statsValid) {
            return "";
        }
        return foxPop.getLabel() + ": " + foxPop.getTotal() + " " +
               rabbitPop.getLabel() + ": " + rabbitPop.getTotal();
    }

    public void markInvalid() {
        statsValid = false;
    }
}