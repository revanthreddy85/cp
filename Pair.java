package FastIO;
import java.util.Objects;

public class Pair implements Comparable <Pair>{
    public int x;
    public int y;

    public Pair(int x1,int y1) {
        this.x=x1;
        this.y=y1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x &&
                y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int compareTo(Pair p) {
        if(x==p.x)
            return Integer.compare(y,p.y);
        return Long.compare(x,p.x);
    }
}
