import java.util.*;
import java.io.*;

public class E1016_주행거리비교하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
    
        if (A > B){
            System.out.println("A");
        } else if (B > A){
            System.out.println("B");
        } else {
            System.out.println("same");
        }
    }
}
