import book.objectorienteddesign.generic.methods.GenericDemo;
import book.objectorienteddesign.linkedLists.singlylinkedlists.SinglyLinkedList;
import book.objectorienteddesign.recursion.binary.Binary;
import book.objectorienteddesign.recursion.factorial.Factorial;
import jdk.nashorn.internal.runtime.NumberToString;

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

        String[] s = {"+37477939733", "+37499266857"};

//        HashMap<String ,Long> longHashMap = new HashMap<>();
//        longHashMap.put(s[0], 15L);

//        String[] m= new String[s.length];
//        GenericDemo.reverse(s);
//        for (int i = 0; i < 256; i++) {
//            System.out.println("DEC: "+i+" Char: "+(char)i);
//            if(i==127) System.out.println("\n");
//        }
//
//        char c = 'z' + '1';
//        System.out.println(c);
//        System.out.println((char)150);


//        int[ ][ ] data = new int[8][10];
//
////    data[i][i+1] = data[i][i] + 3;
//        int j = data.length; // j is 8
//        int k = data[4].length;
//        System.out.println(j);
//        System.out.println(k);


        Abc abc = new Abc(65);
        Abc abc1 = new Abc(1);
        Abc abc2 = new Abc(233);
        Abc abc3 = new Abc(3);

        SinglyLinkedList<Abc> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addLast(abc);
        singlyLinkedList.addLast(abc1);
        singlyLinkedList.addLast(abc2);
        singlyLinkedList.addLast(abc3);

        singlyLinkedList.add(4,new Abc(5));
//       int a= 1;
//       int b= 2147483647;

//        int c=a+b;
//        for (int i = 0; i < 100_000; i++) {
//            singlyLinkedList.addLast(new Abc(i));
//        }

//        System.out.println(singlyLinkedList.remove(4));
//        System.out.println(singlyLinkedList.remove(4));
//        for (int i = 0; i < singlyLinkedList.size() ; i++) {
//            System.out.println( singlyLinkedList.get(i) );
//        }

        int[] arr = {1,5,6,9,55,333,424,668,1000};

        System.out.println(Binary.binarySearch(arr,1,0,arr.length-1));
        System.out.println(Binary.indexOf(arr,10040));
        System.out.println(Arrays.binarySearch(arr, 5));



//        if(!isOverflow(a,b)){
//            System.out.println(c);
//        }else {
//            System.out.println("Overflow");
//        }


    }

    static boolean isOverflow(int left, int right) {
        return right > 0
                ? Integer.MAX_VALUE - right < left
                : Integer.MIN_VALUE - right > left;
    }

    static class Abc {

        int a;

        public Abc(int a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "" + a;
        }
    }

}
