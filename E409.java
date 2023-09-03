import java.io.*;
import java.util.*;
public class E409 {
    public static final int checkValue = 999;

    public static int getAreaSize(int[][] pan, int x, int y, int n){
        pan[x][y] = checkValue;
        int result = 1;
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++){
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n){
                continue;
            }
            if (pan[nextX][nextY] == 1){
                result += getAreaSize(pan, nextX, nextY, n);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] pan = new int[n][n];

        for(int i =0; i<n; i++){
            String inputText = in.readLine();
            for(int j = 0; j<n; j++){
                pan[i][j] = inputText.charAt(j) - '0';
            }
        }

        ArrayList<Integer> blockCountList = new ArrayList<Integer>();

        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                if (pan[i][j] == 1){
                    blockCountList.add(getAreaSize(pan, i, j, n));
                }
            }
        }

        // 장애물 블록수를 출력하고, 
        System.out.println(blockCountList.size());
        // 각 블록에 속하는 장애물의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
        Collections.sort(blockCountList);
        for(int count:blockCountList){
            System.out.println(count);
        }
        
    }
}
