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

        HashMap<Integer, ArrayList<String>> oof = new HashMap<Integer, ArrayList<String>>();

        for (String j : freq.keySet()) {
            ArrayList<String> a = oof.getOrDefault(freq.get(j),new ArrayList<>()); // this is HashMap's .get, returns ArrayList
            a.add(j);
            oof.put(freq.get(j),a);
        }

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
        return String.join(" ",result);
    }

}
