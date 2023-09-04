import java.util.*;
import java.io.*;

public class E407 {
    public static void main(String args[]) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long result = k;
        for(int i=0; i<n; i++){
            result = (result * p) % 1000000007;
        }
        System.out.println(result);
    }
}