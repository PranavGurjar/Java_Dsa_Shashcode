package Tree_Data_Structure;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeBasedKey_ValueStore {
    public static void main(String[] args) {

        TimeMap timeMap = new TimeMap();

        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // bar
        System.out.println(timeMap.get("foo", 3)); // bar

        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // bar2
        System.out.println(timeMap.get("foo", 5)); // bar2

    }

    static class TimeMap {
        HashMap<String, TreeMap<Integer, String>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)){
                map.put(key, new TreeMap<>());
            }
            TreeMap<Integer, String> subMap = map.get(key);
            subMap.put(timestamp, value);
            //key -> time -> value
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)){
                return "";
            }
            TreeMap<Integer, String> subMap = map.get(key);
            Integer prevTime = subMap.floorKey(timestamp);
            if (prevTime == null){
                return "";
            }
            return subMap.get(prevTime);
        }
    }
}


