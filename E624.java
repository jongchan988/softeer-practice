import java.io.*;
import java.util.*;
public class E624 {
    public static final int lightLimit = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            String before = st.nextToken();
            String after = st.nextToken();
            ArrayList<Light> beforeList = getLightList(before);
            ArrayList<Light> afterList = getLightList(after);
            int result = 0;
            for (int j = 0; j < lightLimit; j++){
                result += beforeList.get(j).getDiffAmount(afterList.get(j));
            }
            System.out.println(result);
        }
    }
    public static String appendFill(String text){
        int appendLength = lightLimit - text.length();
        for(int i = 0; i < appendLength; i++){
            text = "x"+ text;
        }
        return text;
    }
    public static ArrayList<Light> getLightList(String text){
        ArrayList<Light> list = new ArrayList<Light>();
        text = appendFill(text);
        for(int i=0; i<lightLimit; i++ ){
            list.add(getLight(text.charAt(i)));
        }
        return list;
    }
    public static Light getLight(char value){
        switch(value){
            case '0': return new Light(true, true, true, false, true, true, true);
            case '1': return new Light(false, true, false, false, false, true, false);
            case '2': return new Light(true, true, false, true, true, false, true);
            case '3': return new Light(true, true, false, true, true, true, false);
            case '4': return new Light(false, true, true, true, false, true, false);
            case '5': return new Light(true, false, true, true, true, true, false);
            case '6': return new Light(true, false, true, true, true, true, true);
            case '7': return new Light(true, true, true, false, false, true, false);
            case '8': return new Light(true, true, true, true, true, true, true);
            case '9': return new Light(true, true, true, true, true, true, false);
        }
        return new Light(false, false, false, false, false, false, false);
    }

    public static class Light{
        private Boolean head;
        private Boolean headRight;
        private Boolean headLeft;
        private Boolean middle;
        private Boolean bottom;
        private Boolean bottomRight;
        private Boolean bottomLeft;

        public Light(Boolean head, Boolean headRight, Boolean headLeft, Boolean middle, Boolean bottom, Boolean bottomRight, Boolean bottomLeft){
            this.head = head;
            this.headRight = headRight;
            this.headLeft = headLeft;
            this.middle = middle;
            this.bottom = bottom;
            this.bottomRight = bottomRight;
            this.bottomLeft = bottomLeft;
        }

        public int getDiffAmount(Light light){
            int result = 0;
            if (light.head != this.head){
                result += 1;
            }
            if (light.headRight != this.headRight){
                result += 1;
            }
            if (light.headLeft != this.headLeft){
                result += 1;
            }
            if (light.middle != this.middle){
                result += 1;
            }
            if (light.bottom != this.bottom){
                result += 1;
            }
            if (light.bottomRight != this.bottomRight){
                result += 1;
            }
            if (light.bottomLeft != this.bottomLeft){
                result += 1;
            }

            return result;
        }
    }
}
