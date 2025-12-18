import java.util.List;

public class Rabbit extends Animal {
    private static final int MIN_BREED_AGE = 5;
    private static final int MAX_AGE_LIMIT = 40;
    private static final double BREED_CHANCE = 0.12;
    private static final int MAX_OFFSPRING = 4;

    public Rabbit(Field grid, Location position) {
        super(grid, position);
    }

    @Override
    public void act(List<Animal> newRabbits) {
        advanceAge();
        if (isLiving()) {
            if (currentAge > MAX_AGE_LIMIT) {
                markDead();
                return;
            }
            Location newPos = grid.findFreeAdjacent(position);
            if (newPos != null) {
                updatePosition(newPos);
            } else {
                markDead();
            }
            if (currentAge >= MIN_BREED_AGE && Randomizer.generateDouble() <= BREED_CHANCE) {
                breed(newRabbits);
            }
        }
    }

    private void breed(List<Animal> newRabbits) {
        int numBirths = Randomizer.generateInt(MAX_OFFSPRING) + 1;
        List<Location> freeSpots = grid.getFreeAdjacentPositions(position);
        for (int i = 0; i < numBirths && !freeSpots.isEmpty(); i++) {
            Location spot = freeSpots.remove(0);
            Rabbit young = new Rabbit(grid, spot);
            newRabbits.add(young);
        }
    }
}