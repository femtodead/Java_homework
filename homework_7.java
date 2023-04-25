import java.util.ArrayList;
import java.util.Random;

// Пусть дан произвольный список целых чисел, удалить из него чётные числа
public class homework_7 {
    public static void main(String[] args) {
        ArrayList<Integer> new_array = new ArrayList<Integer>(ArRandom(10, 0, 10));
        System.out.println(new_array);
        System.out.println(DelEven(new_array));
    }
    public static ArrayList<Integer> ArRandom(int size, int min, int max) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Random rend = new Random();
        for (int i = 0; i < size; i++) {
            array.add(rend.nextInt(min,max+1));
        }
        return array;
    }

    public static ArrayList<Integer> DelEven(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)%2 == 0)
            list.set(i, 0);
        }
        ArrayList<Integer> del_elem_list = new ArrayList<Integer>();
        del_elem_list.add(0);
        list.removeAll(del_elem_list);
        return list;
    }
}
