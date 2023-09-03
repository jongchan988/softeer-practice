import java.io.*;
import java.util.*;

public class E623 {
    public static Boolean isSecret(int[] secretNotes, int[] userNotes, int targetIndex){
        for(int i =0; i<secretNotes.length; i++){
            if (secretNotes[i] != userNotes[i+targetIndex]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        String result = "normal";
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (m <= n){
            int[] secretNotes = new int[m];
            int[] userNotes = new int[n];

            st = new StringTokenizer(in.readLine());

            for(int i = 0; i < m; i++){
                secretNotes[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine());
            
            for(int i = 0; i < n; i++){
                userNotes[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++){
                if (i > n-m){
                    break;
                }
                if (isSecret(secretNotes, userNotes, i) == true){
                    result = "secret";
                    break;
                }
            }
        }
        
        System.out.println(result);
    }
}
