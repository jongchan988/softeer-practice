import java.util.*;
import java.io.*;

public class E362 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int seq = i+1;
            int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            System.out.println("Case #"+(seq)+": "+sum);
        }
    }
}
