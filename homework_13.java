// 2) Реализовать алгоритм пирамидальной сортировки (HeapSort).

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class homework_13 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i%2 != 0) list.add(-i);
            else list.add(i);
        }
        System.out.println(list);
        System.out.println(pyramid(list));
        leftDown(pyramid(list));
        HashMap<Integer,ArrayList<Integer>> myMap = new HashMap<>();
        myMap = leftDown(pyramid(list));
        for (int i = 0; i < 10; i++) {
            leftDown(myMap);
            System.out.println(myMap);
        }
    }
    public static HashMap<Integer,ArrayList<Integer>> pyramid(ArrayList<Integer> list) {
        HashMap<Integer,ArrayList<Integer>> pyramidMap = new HashMap<>();
        int count = list.size();
        int index = 0;
        int tempnum = 0;
        int count2 = 1;
        while (count > 0)
        {
            count = count/2;
            tempnum++;
        }
        for (int i = 0; i < tempnum; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (index < list.size()-count2) {
                for (int j = 0; j < count2; j++) {
                    temp.add(j,list.get(index));
                    index++;
                }
            }
            else{
                for (int j = 0; j <= list.size()-index+1; j++) {
                    temp.add(j,list.get(index));
                    index++;
                }
            } 
                pyramidMap.put(i, temp);
                count2 = count2*2;
        }
        
        return pyramidMap;
    }

    public static HashMap<Integer,ArrayList<Integer>> leftDown(HashMap<Integer,ArrayList<Integer>> map) {
        Set<Integer> key = map.keySet();
        for (int i = 1; i < key.size(); i++) {
            for (int j = 0; j < map.get(i-1).size(); j++) {
                for (int j2 = 0; j2 < map.get(i).size(); j2++) {
                    if (map.get(i-1).get(j) > map.get(i).get(j2))
                    {
                        Integer temp = map.get(i-1).get(j);
                        map.get(i-1).set(j,map.get(i).get(j2));
                        map.get(i).set(j2, temp);
                    }
                }
            }
        }
        return map;
    }
}
