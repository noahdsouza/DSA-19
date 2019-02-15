import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        // TODO
        HashMap<Double,Integer> oof = new HashMap();
        int total = 0;
        for (int i=0; i<points.length; i++) {
            for (int j=0; j<points.length; j++) {
                double dist = Math.pow((points[i][0]-points[j][0]),2)+Math.pow((points[i][1]-points[j][1]),2);
                if (oof.containsKey(dist)) {
                    int val = oof.get(dist);
                    oof.put(dist,val+1);
                } else {
                    oof.put(dist,1);
                }

                }
            for (Map.Entry<Double,Integer> k : oof.entrySet()) {
                total = total + (k.getValue()*(k.getValue()-1));
            }
            oof.clear();

        }
        return total;
    }
}

