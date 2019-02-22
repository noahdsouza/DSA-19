import java.awt.event.ItemEvent;
import java.util.*;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        String[] arr = s.split(" ");
        for (String i : arr) {
            if (!freq.containsKey(i)) {
                freq.put(i,1);
            } else {
                freq.put(i,(freq.get(i)+1));
            }
        }
        List<String> keys = new ArrayList<>(freq.keySet());
        List<Integer> vals = new ArrayList<>(freq.values());

//        int[] newKeys = new int[vals.size()];
//        Arrays.sort(vals.toArray());

        HashMap<Integer, ArrayList<String>> oof = new HashMap<Integer, ArrayList<String>>();

        for (String j : freq.keySet()) {
//            if (oof.containsKey(freq.get(j))) { // this is ArrayList's .get, returns int
            ArrayList<String> a = oof.getOrDefault(freq.get(j),new ArrayList<>()); // this is HashMap's .get, returns ArrayList
            a.add(j);
            oof.put(freq.get(j),a);
//            } else {
//                ArrayList<String> b = new ArrayList<>();
//                b.add(j);
//                oof.put(freq.get(j),b);
//            }
        }

//        Arrays.sort(vals.toArray());
//        List<Integer> newKeys = new ArrayList<>(oof.keySet());
//        int[] newKeys = new int[oof.size()];
//        Arrays.sort(newKeys.toArray());
//        String finalString = new String();
        ArrayList<String> result = new ArrayList<>();

        for (int k=0; k<arr.length; k++) {
            if (oof.containsKey(k)) {
                for (String m : oof.get(k)) {
                    for (int n=0; n<k; n++) {
                        result.add(m);
                    }
                }
            }
        }

        System.out.println(String.join(" ",result));
        return String.join(" ",result);
    }

}
