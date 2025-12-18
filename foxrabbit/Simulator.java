import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Simulator {
    private static final int STD_ROWS = 50;
    private static final int STD_COLUMNS = 50;
    private static final double FOX_SPAWN_RATE = 0.02;
    private static final double RABBIT_SPAWN_RATE = 0.08;

    private Field grid;
    private SimulatorDisplay display;
    private List<Animal> creatures;
    private int cycle;

    public Simulator() {
        this(STD_ROWS, STD_COLUMNS);
    }

    public Simulator(int rows, int columns) {
        grid = new Field(rows, columns);
        display = new SimulatorDisplay(rows, columns);
        creatures = new ArrayList<>();

        display.assignColor(Rabbit.class, "white");
        display.assignColor(Fox.class, "orange");

        initialize();
    }

    public void runSimulation(int cycles) {
        for (int i = 1; i <= cycles && display.isSustainable(grid); i++) {
            advanceCycle();
        }
    }

    public void advanceCycle() {
        cycle++;
        List<Animal> newborns = new ArrayList<>();

        Iterator<Animal> iter = creatures.iterator();
        while (iter.hasNext()) {
            Animal creature = iter.next();
            if (creature.isLiving()) {
                creature.act(newborns);
            } else {
                iter.remove();
            }
        }

        creatures.addAll(newborns);

        display.updateStatus(cycle, grid);
    }

    public void initialize() {
        cycle = 0;
        creatures.clear();
        grid.reset();
        spawnInitial();
        display.updateStatus(cycle, grid);
    }

    private void spawnInitial() {
        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getColumns(); c++) {
                if (Randomizer.generateDouble() <= FOX_SPAWN_RATE) {
                    Location pos = new Location(r, c);
                    Fox fox = new Fox(grid, pos);
                    creatures.add(fox);
                } else if (Randomizer.generateDouble() <= RABBIT_SPAWN_RATE) {
                    Location pos = new Location(r, c);
                    Rabbit rabbit = new Rabbit(grid, pos);
                    creatures.add(rabbit);
                }
            }
        }
    }

    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.runSimulation(200);
    }
}