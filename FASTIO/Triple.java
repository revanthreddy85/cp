package FastIO;

import java.util.Objects;

public class Triple implements Comparable <Triple>
{
    public int x;
    public int y;
    public int z;

    public Triple(int x, int y, int z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple triple = (Triple) o;
        return x == triple.x &&
                y == triple.y &&
                z == triple.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public int compareTo(Triple t) {
        return Long.compare(x,t.x);
    }
}
