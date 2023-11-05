package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    final static int ELEMENTS = 100000;
    final static int nREADS = 1000;
    final static long AFRICA = 1110635000L;
    final static long AMERICA = 972005000L;
    final static long ANTARTICA = 0L;
    final static long ASIA = 4298723000L;
    final static long EUROPE = 742452000L;
    final static long OCEANIA = 38304000L;


    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */


     

    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> list = new ArrayList<>();

        for(int i=1000; i<2000; i++){
            list.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        List<Integer> list2 = new LinkedList<>();
        list2.addAll(list);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        int temp;
        temp = list.get(0);
        list.set(0, list.get(999));
        list.set(999, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

         for (Integer integer : list) {
            System.out.println(integer);
         }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

         long time = System.nanoTime();
         for(int i=0; i<ELEMENTS; i++){
            list.add(0,i);
         }

         time = System.nanoTime() - time;

         final var millisOfArray = TimeUnit.NANOSECONDS.toMillis(time);

         System.out.println("For the arrayList it took "+millisOfArray+"ms");

         time = System.nanoTime();
         for(int i=0; i<ELEMENTS; i++){
            list2.add(0,i);
         }

         time = System.nanoTime() - time;

         final var millisOfLinked = TimeUnit.NANOSECONDS.toMillis(time);

         System.out.println("For the arrayList it took "+millisOfLinked+"ms");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

         time = System.nanoTime();
         for(int i=0; i<nREADS; i++){
            list.get(list.size()/2);
         }
         time = System.nanoTime() - time;
         System.out.println("For the ArrayList to read "+nREADS+" elments it took "+time+" ns");

         time = System.nanoTime();
         for(int i=0; i<nREADS; i++){
            list.get(list2.size()/2);
         }
         time = System.nanoTime() - time;
         System.out.println("For the ArrayList to read "+nREADS+" elments it took "+time+" ns");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

         Map<String, Long> map = new HashMap<>();
         map.put("AFRICA", AFRICA);
         map.put("AMERICA", AMERICA);
         map.put("ANTARTICA", ANTARTICA);
         map.put("ASIA", ASIA);
         map.put("EUROPE", EUROPE);
         map.put("OCEANIA", OCEANIA);
         

        /*
         * 8) Compute the population of the world
         */

         long worldPopuplation = 0;
         System.out.println(map);
         for (Long l : map.values()) {
            worldPopuplation = worldPopuplation + l;
         }
         System.out.println("the population of the world is "+worldPopuplation);
    }
}
