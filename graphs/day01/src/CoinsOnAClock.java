import java.util.ArrayList;
import java.util.List;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        // TODO
        List<char[]> result = new ArrayList<>();
        char[] clock = new char[hoursInDay];
        coinsback(clock,pennies,nickels,dimes,0,hoursInDay,result);
        return result;
    }

    private static void coinsback(char[] clock, int p, int n, int d, int time, int numhrs, List<char[]> perm) {
//        clock (for 12 hrs) is a 0-11 vector
//        coins is an array with all the coins in it (ex. [1,1,1,1,5,5,5,5...]
//        time is the current time
//        numhrs is hours in a day

//      base case
        if(p==0 && n==0 && d==0) {
            char[] addclock = new char[clock.length];
            System.arraycopy(clock,0,addclock,0,clock.length);
            perm.add(addclock);
            //return;
        }
        int current = time;
        if(clock[time]==0) {
            if(p!=0) {
                clock[time] = 'p';
                time = (time+1)%numhrs;
                coinsback(clock,p-1,n,d,time,numhrs,perm);
                time = current;
                clock[time] = 0;
            }
            if(n!=0) {
                clock[time] = 'n';
                time = (time+5)%numhrs;
                coinsback(clock,p,n-1,d,time,numhrs,perm);
                time = current;
                clock[time] = 0;
            }
            if(d!=0) {
                clock[time] = 'd';
                time = (time+10)%numhrs;
                coinsback(clock,p,n,d-1,time,numhrs,perm);
                time = current;
                clock[time] = 0;
            }
        }
    }
}
