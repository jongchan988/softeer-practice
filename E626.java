import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class E626 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        ArrayList<Room> roomList = new ArrayList<Room>();

        int roomCnt = Integer.parseInt(st.nextToken());
        int reservationCnt = Integer.parseInt(st.nextToken());

        for(int i = 0; i < roomCnt; i++){
            roomList.add(new Room(in.readLine()));
        }

        for(int i = 0; i < reservationCnt; i++){
            st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            for (Room room: roomList){
                if (room.isSameRoom(name)){
                    room.reservation(startTime, endTime);
                }
            }
        }

        Collections.sort(roomList);

        for (int i=0; i<roomList.size(); i++){
            ArrayList<String> infoList = roomList.get(i).getInfoList();
            for(String info: infoList){
                System.out.println(info);
            }
            if (i < roomList.size()-1){
                System.out.println("-----");
            }
        }

    }

    public static class Room implements Comparable<Room>{
        private String name;
        
        private int timeCnt = 9;

        private int[] reservationArr = new int[timeCnt];

        public Boolean isSameRoom(String name){
            return this.name.equals(name);
        }

        public String getName(){
            return "Room " + this.name + ":";
        }

        public ArrayList<String> getInfoList(){
            ArrayList<String> result = new ArrayList<String>();
            result.add(getName());
            ArrayList<String> reservationInfoList = getReservationInfoList();
            result.add(getAvailable(reservationInfoList.size()));
            result.addAll(reservationInfoList);

            return result;
        }
        public String getAvailable(int cnt){
            if (cnt > 0){
                return cnt + " available:";
            }
            return "Not available";
        }

        public ArrayList<String> getReservationInfoList(){
            ArrayList<String> reservationInfoList = new ArrayList<String>();
            for(int i = 0; i < timeCnt; i++){ 
                if (reservationArr[i] == 0){
                    int addAreaIndex = getFindArea(i+1);
                    reservationInfoList.add(getTime(i)+"-"+getTime(i + addAreaIndex + 1));
                    i += addAreaIndex; 
                }
            }
            return reservationInfoList;
        }

        public int getFindArea(int index){
            if (index >= timeCnt || reservationArr[index] != 0){
                return 0;
            }

            return 1 + getFindArea(index+1);
        }

        public Room(String name){
            this.name = name;
            for(int i = 0; i < timeCnt; i++){
                reservationArr[i] = 0;
            }
        }

        public void reservation(int startTime, int endTime){
            for (int i = getIndex(startTime); i < getIndex(endTime); i++){
                reservationArr[i] = 1;
            }
        }

        public String getTime(int index){
            return String.format("%02d", index + timeCnt); 
        }

        public int getIndex(int time){
            return time - timeCnt;
        }

        public int compareTo(Room room){
            return this.name.compareTo(room.name);
        }
    }
}
