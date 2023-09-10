import java.io.*;
import java.util.*;

public class E392 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        ArrayList<Reservation> list = new ArrayList<Reservation>();

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            list.add(new Reservation(startTime, endTime));
        }
        Collections.sort(list);

        int result = 0;
        int lastTime = 0;

        for (Reservation reservation: list){
            if (reservation.startTime >= lastTime){
                result++;
                lastTime = reservation.endTime;
            }
        }
        System.out.println(result);
    }

    public static class Reservation implements Comparable<Reservation>{
        int startTime, endTime;

        public Reservation(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int compareTo(Reservation reservation){
            return this.endTime - reservation.endTime;
        }
    }
}
