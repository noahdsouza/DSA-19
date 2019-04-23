public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBad) {
        // TODO
        long s = 1;
        long e = n;
        while (s < e) {
            long m = (e-s)/2 + s;
            if (isBad.isFailingVersion(m)) {e = m;}
            else {s = m+1;}
        }
        if (isBad.isFailingVersion(s)) {return s;}
        return e;
    }
}
