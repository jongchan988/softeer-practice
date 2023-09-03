import java.util.*;
import java.io.*;

public class E395 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int limit = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        ArrayList<Item> itemList = new ArrayList<Item>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            itemList.add(new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(itemList, Collections.reverseOrder());

        int result = 0;
        int currentWeight = 0;

        for(int i = 0; i < n; i++){
            int weight = 0;
            int restWeight = limit - currentWeight;

            if (restWeight <= itemList.get(i).getWeight()){
                weight = restWeight;
            } else {
                weight = itemList.get(i).getWeight();
            }
            currentWeight += weight;
            result += weight * itemList.get(i).getPrice();
            
            if (currentWeight >= limit){
                break;
            }
        }
        System.out.println(result);
    }

    public static class Item implements Comparable<Item>{
        private int weight;
        private int price;
        
        public Item(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        public int getWeight(){
            return this.weight;
        }
        
        public int getPrice(){
            return this.price;
        }

        public int compareTo(Item item) {
            if (item.getPrice() < this.getPrice()){
                return 1;
            } else if (item.getPrice() > this.getPrice()){
                return -1;
            }
            return 0;
        }
    }
}
