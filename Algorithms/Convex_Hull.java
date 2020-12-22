package Algorithms;

import FastIO.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class Convex_Hull {

    private boolean cw(Pair a, Pair b, Pair c) {
        return a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y) < 0;
    }

    private boolean acw(Pair a, Pair b, Pair c) {
        return a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y) > 0;
    }

    public ArrayList<Pair> convex_hull(ArrayList<Pair> a) {
        Collections.sort(a);
        Pair p1 = a.get(0), p2 = a.get(a.size()-1);
        ArrayList<Pair> up=new ArrayList<>();
        ArrayList<Pair> down=new ArrayList<>();
        up.add(p1);
        down.add(p1);
        for (int i = 1; i < a.size(); i++) {
            if (i == a.size() - 1 || cw(p1, a.get(i), p2)) {
                while (up.size() >= 2 && !cw(up.get(up.size()-2), up.get(up.size()-1), a.get(i)))
                    up.remove(up.size()-1);
                up.add(a.get(i));
            }
            if (i == a.size() - 1 || acw(p1, a.get(i), p2)) {
                while(down.size() >= 2 && !acw(down.get(down.size()-2), down.get(down.size()-1), a.get(i)))
                    down.remove(down.size()-1);
                down.add(a.get(i));
            }
        }

        for (int i = down.size() - 2; i > 0; i--)
            up.add(down.get(i));
        return up;
    }
}
