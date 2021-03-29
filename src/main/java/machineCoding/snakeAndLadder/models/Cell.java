package machineCoding.snakeAndLadder.models;

import java.util.Objects;

public class Cell {
    private final int i;
    private final int j;

    public Cell(final int i, final int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return i == cell.i &&
            j == cell.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cell{");
        sb.append("i=").append(i);
        sb.append(", j=").append(j);
        sb.append('}');
        return sb.toString();
    }
}
