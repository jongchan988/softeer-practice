import java.util.*;
import java.io.*;


public class E990_근무시간
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int workingDays = 5;
        int sum = 0;
        for(int i=0; i < workingDays; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            sum += getWorkingDateTime(st);
        }
        System.out.println(sum);
    }

    public static int getWorkingDateTime(StringTokenizer st){
        String[] startTimeArr = st.nextToken().split(":");
        String[] endTimeArr = st.nextToken().split(":");
        
        int endTime = getTotalMinutes(Integer.parseInt(endTimeArr[0]), Integer.parseInt(endTimeArr[1]));
        int startTime = getTotalMinutes(Integer.parseInt(startTimeArr[0]), Integer.parseInt(startTimeArr[1]));
        
        return endTime - startTime;
    }

    public static int getTotalMinutes(int hours, int minutes){
        return hours * 60 + minutes;
    }
}