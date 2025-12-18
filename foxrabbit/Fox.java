import java.util.List;
import java.util.Iterator;

public class Fox extends Animal {
    private static final int MIN_BREED_AGE = 10;
    private static final int MAX_AGE_LIMIT = 150;
    private static final double BREED_CHANCE = 0.04;
    private static final int MAX_OFFSPRING = 3;
    private static final double FOOD_PROB = 0.6;
    private int foodLevel;

    public Fox(Field grid, Location position) {
        super(grid, position);
        foodLevel = Randomizer.generateInt(15);  // Nilai makanan awal acak
    }

    @Override
    public void act(List<Animal> newFoxes) {
        advanceAge();
        if (isLiving()) {
            foodLevel--;
            if (foodLevel <= 0) {
                markDead();
                return;
            }
            Location target = findPrey();
            if (target != null) {
                Animal prey = grid.getAnimalAt(target);
                if (prey instanceof Rabbit) {
                    prey.markDead();
                    foodLevel += 12;  // Nilai makanan dari mangsa
                }
                updatePosition(target);
            } else {
                Location newPos = grid.findFreeAdjacent(position);
                if (newPos != null) {
                    updatePosition(newPos);
                } else {
                    markDead();
                }
            }
            if (currentAge >= MIN_BREED_AGE && Randomizer.generateDouble() <= BREED_CHANCE) {
                breed(newFoxes);
            }
            if (currentAge > MAX_AGE_LIMIT) {
                markDead();
            }
        }
    }

    private Location findPrey() {
        List<Location> adjacents = grid.getAdjacentPositions(position);
        for (Location adj : adjacents) {
            Animal animal = grid.getAnimalAt(adj);
            if (animal instanceof Rabbit && animal.isLiving()) {
                return adj;
            }
        }
        return null;
    }

    private void breed(List<Animal> newFoxes) {
        List<Location> freeSpots = grid.getFreeAdjacentPositions(position);
        int numBirths = Randomizer.generateInt(MAX_OFFSPRING) + 1;
        for (int i = 0; i < numBirths && !freeSpots.isEmpty(); i++) {
            Location spot = freeSpots.remove(0);
            Fox young = new Fox(grid, spot);
            newFoxes.add(young);
        }
    }
}