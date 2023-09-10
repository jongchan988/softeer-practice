import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E1717 {
    public static int carCnt;

    public static int[] carList;

    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(in.readLine());

        carCnt = Integer.parseInt(st.nextToken());
        int qCnt = Integer.parseInt(st.nextToken());
        carList = new int[carCnt];

        st = new StringTokenizer(in.readLine());
        for (int i =0; i< carCnt; i++){
            carList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(carList);

        for (int i =0; i < qCnt; i++){
            int value = Integer.parseInt(in.readLine());
            int index = Arrays.binarySearch(carList, value);
            if (index < 0){
                System.out.println(0);
                continue;
            }
            int overCnt = carCnt - index - 1;
            int lowerCnt = index;

            if (overCnt < 0 || lowerCnt < 0){
                System.out.println(0);
                continue;
            }
            System.out.println(overCnt * lowerCnt);
        }
    }
}
