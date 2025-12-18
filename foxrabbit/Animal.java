import java.util.List;

public abstract class Animal {
    protected boolean living;
    protected Field grid;
    protected Location position;
    protected int currentAge;

    public Animal(Field grid, Location position) {
        this.living = true;
        this.grid = grid;
        this.currentAge = 0;
        updatePosition(position);
    }

    abstract public void act(List<Animal> newAnimals);

    public boolean isLiving() {
        return living;
    }

    protected void markDead() {
        living = false;
        if (position != null) {
            grid.remove(position);
            position = null;
            grid = null;
        }
    }

    protected void updatePosition(Location newPosition) {
        if (position != null) {
            grid.remove(position);
        }
        position = newPosition;
        grid.place(this, newPosition);
    }

    protected void advanceAge() {
        currentAge++;
    }

    public Location getPosition() {
        return position;
    }
}