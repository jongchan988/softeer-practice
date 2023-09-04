import java.io.*;
import java.util.*;

public class E584 {
    public static final int limitTower = 100;

    public static int getCurrentSpeed(int[][] arrays, int targetM){
        int sum = 0;
        for (int[] array: arrays){
            sum += array[0];
            if (sum >= targetM){
                return array[1];
            }
        }
        return 0;
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] configArr = new int[n][2];
        int[][] testArr = new int[m][2];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(in.readLine());
            configArr[i][0] = Integer.parseInt(st.nextToken());
            configArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(in.readLine());
            testArr[i][0] = Integer.parseInt(st.nextToken());
            testArr[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 0; i <= limitTower; i++){
            int diff = getCurrentSpeed(testArr, i) - getCurrentSpeed(configArr, i);
            if (diff > result){
                result = diff;
            }
        }
        
        System.out.println(result);
    }
}
