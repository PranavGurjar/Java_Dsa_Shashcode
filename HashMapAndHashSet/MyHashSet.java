package HashMapAndHashSet;

import java.util.HashSet;
import java.util.Iterator;

public class MyHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(6);

        System.out.println(set);

        set.add(6);
        System.out.println(set);
        System.out.println(set.contains(4));

        System.out.println(set.remove(4));
        System.out.println(set);

        for (Integer i : set) {
            System.out.println(i);
            set.remove(i);
        }
        System.out.println(set);

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(5);
        System.out.println(set);

        Iterator<Integer> itr = set.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//            itr.remove();
//        }

        while (itr.hasNext()){
            itr.remove();
            System.out.println(itr.next());
        }

        System.out.println(set);
    }
}
