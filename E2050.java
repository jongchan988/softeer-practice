import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E2050 {
    public static int count = 0;

    public static int[][] pan;

    public static Boolean[][] checkList;

    public static int[] moveI = {-1, 0, 1, 0};

    public static int[] moveJ = {0, 1, 0, -1};

    public static int n;

    public static int m;

    public static int[][] pointsArr;

    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pan = new int[n][n];
        checkList = new Boolean[n][n];
        pointsArr = new int[m][2];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++){
                pan[i][j] = Integer.parseInt(st.nextToken());
                checkList[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(in.readLine());
            pointsArr[i][0] = Integer.parseInt(st.nextToken()) -1;
            pointsArr[i][1] = Integer.parseInt(st.nextToken()) -1;
        }

        dfs(0, pointsArr[0][0], pointsArr[0][1]);
        System.out.println(count);
    }

    public static Boolean checkPoints(int index, int pointI, int pointJ){
        return pointsArr[index][0] == pointI && pointsArr[index][1] == pointJ;
    }

    public static void dfs(int index, int pointI, int pointJ){
        if (checkPoints(index, pointI, pointJ)){
            if (index == m - 1){
                count++;
                return;
            }
            index++;
        }

        checkList[pointI][pointJ] = true;
        for (int i = 0; i < 4; i++){
            int nextI = pointI + moveI[i];
            int nextJ = pointJ + moveJ[i];

            if (outOfLange(nextI) || outOfLange(nextJ)){
                continue;
            }
            if (pan[nextI][nextJ] == 1){
                continue;
            }
            if (checkList[nextI][nextJ] == true){
                continue;
            }

            dfs(index, nextI, nextJ);
        }
        checkList[pointI][pointJ] = false;
    }

    public static Boolean outOfLange(int value){
        return value < 0 || value >=  n;
    }
}
