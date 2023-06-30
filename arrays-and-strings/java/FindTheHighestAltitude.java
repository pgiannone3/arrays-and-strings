import java.util.Map;

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        FindTheHighestAltitude f = new FindTheHighestAltitude();
        System.out.println(f.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }


    public int largestAltitude(int[] gain) {
        if(gain == null) {
            return 0;
        }

        int N = gain.length;
        int [] arr = new int[N+1];

        int max = Integer.MIN_VALUE;

        for(int idx = 0; idx < gain.length; idx++) {
            int el = gain[idx];
            arr[idx + 1] = arr[idx] + el;
            max = Math.max(max, arr[idx + 1]);
        }

        return Math.max(max, 0);
    }
}
