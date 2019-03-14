package divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    public static class Point {
        public int x;
        public int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Building {
        private int l, r, h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        // TODO
        if (B.length==0) {
            return new ArrayList<>();
        }
        if (B.length==1) {
            List<Point> sl = new ArrayList<>();
            sl.add(new Point(B[0].l, B[0].h));
            sl.add(new Point(B[0].r, 0));
            return sl;
        }
        List<Point> l = skyline(Arrays.copyOfRange(B,0,B.length/2));
        List<Point> r = skyline(Arrays.copyOfRange(B,B.length/2,B.length));
        return merge(l,r);
    }

    private static List<Point> merge(List<Point> a, List<Point> b) {
        int i=0; int j=0; int h=0;
        int aLast=0; int bLast=0;
        List<Point> m = new ArrayList<>();
        while (i<a.size() || j<b.size()) {
            if (j>=b.size()) {
                m.add(a.get(i));
                i++;
            } else if (i>=a.size()) {
                m.add(b.get(j));
                j++;
            } else if (a.get(i).x < b.get(j).x) {
                h = (a.get(i).y>bLast) ? a.get(i).y:bLast;
                m.add(new Point(a.get(i).x, h));
                aLast = a.get(i).y;
                i++;
            } else if (a.get(i).x > b.get(j).x) {
                h = (b.get(j).y>aLast) ? b.get(j).y:aLast;
                m.add(new Point(b.get(j).x, h));
                bLast = b.get(j).y;
                j++;
            } else {
                h = (a.get(i).y>b.get(j).y) ? a.get(i).y:b.get(j).y;
                m.add(new Point(a.get(i).x, h));
                aLast = a.get(i).y;
                bLast = b.get(j).y;
                i++;
                j++;
            }
        }
        for (int n=0; n<m.size(); n++) {
            while (n+1<m.size() && m.get(n+1).y==m.get(n).y) {
                m.remove(n+1);
            }
        }
        return m;
    }
}
