import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Field {
    private int rows;
    private int columns;
    private Animal[][] terrain;

    public Field(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        terrain = new Animal[rows][columns];
    }

    public void reset() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                terrain[r][c] = null;
            }
        }
    }

    public void remove(Location pos) {
        terrain[pos.getRow()][pos.getCol()] = null;
    }

    public void place(Animal animal, Location pos) {
        terrain[pos.getRow()][pos.getCol()] = animal;
    }

    public Animal getAnimalAt(Location pos) {
        return terrain[pos.getRow()][pos.getCol()];
    }

    public Animal getAnimalAt(int r, int c) {
        return terrain[r][c];
    }

    public List<Location> getFreeAdjacentPositions(Location pos) {
        List<Location> free = new LinkedList<>();
        List<Location> adj = getAdjacentPositions(pos);
        for (Location next : adj) {
            if (getAnimalAt(next) == null) {
                free.add(next);
            }
        }
        return free;
    }

    public Location findFreeAdjacent(Location pos) {
        List<Location> free = getFreeAdjacentPositions(pos);
        if (!free.isEmpty()) {
            Collections.shuffle(free);  // Acak untuk variasi
            return free.get(0);
        }
        return null;
    }

    public List<Location> getAdjacentPositions(Location pos) {
        List<Location> positions = new LinkedList<>();
        int r = pos.getRow();
        int c = pos.getCol();
        for (int dr = -1; dr <= 1; dr++) {
            int nextR = r + dr;
            if (nextR >= 0 && nextR < rows) {
                for (int dc = -1; dc <= 1; dc++) {
                    int nextC = c + dc;
                    if (nextC >= 0 && nextC < columns && (dr != 0 || dc != 0)) {
                        positions.add(new Location(nextR, nextC));
                    }
                }
            }
        }
        return positions;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}