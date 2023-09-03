import java.util.*;
import java.io.*;

public class E408 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        String result = "";
        int n = 8;
        // 첫번째 토큰
        int temp = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n-1; i++){
            int value = Integer.parseInt(st.nextToken());
            int diff = value - temp;
            String type = "";
            if (diff == 1){
                type = "ascending";
            } else  if (diff == -1){
                type = "descending";
            } else {
                result = "mixed";
                break;
            }
            if (result != "" && type != result){
                result = "mixed";
                break;
            }
            temp = value;
            result = type;
        }
        System.out.println(result);
    }
}
