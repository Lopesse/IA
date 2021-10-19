package examples;

import java.util.*;

public class HouseDemo {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>(){{
            add("pe1");
            add("pe2");
        }};

        Set<String> set2 = new HashSet<String>(){{
            add("p1");
            add("p2");
            add("p3");
        }};

        HouseExample maison = new HouseExample(20, 30,set1, set2);
        
    }
}
