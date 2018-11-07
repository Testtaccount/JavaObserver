import java.util.*;

public class Test {
    public static void main(String[] args) {

//        Map<String, Long> hashMap = new HashMap<>();
//        hashMap.put("a", 10L);
//        hashMap.put("b", 20L);
//        hashMap.put("c", 30L);
////        map.put(null,110L);
////        hashMap.put("f",null);
//
//        // Выбираем все ключи:
//        for (String key : hashMap.keySet()) {
//            System.out.println("Key: " + key);
//        }
//
//        // Выбираем все значения:
//        for (long value : hashMap.values()) {
//            System.out.println("Value: " + value);
//        }
//
//        // Выбираем все ключи и значения одновременно:
//        for (Map.Entry entry : hashMap.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + " Value: "
//                    + entry.getValue());
//        }
//
//        System.out.println(hashMap);

//
//        Set<Long> set=new TreeSet<>();
//        set.add(102L);
//        set.add(12L);

        String[] s = {"+37477939733","+37499266857"};

        HashMap<String ,Long> longHashMap = new HashMap<>();
        longHashMap.put(s[0], 15L);

        System.out.println(longHashMap.get(s[1]));

    }
}
