import java.io.*;
import java.util.*;

public class E413 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int points = 2;
        for(int i =0; i<n; i++){
            points = points * 2 - 1;
        }
        System.out.println(points*points);
    }
}
