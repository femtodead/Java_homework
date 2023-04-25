import java.util.ArrayList;
import java.util.Random;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class homework_8 {
    public static void main(String[] args) {
        ArrayList<Integer> new_array = new ArrayList<Integer>(ArRandom(10, 0, 10));
        System.out.println(new_array);
        System.out.println(min(new_array));
        System.out.println(max(new_array));
        System.out.println(arithmeticMean(new_array));
    }

    public static ArrayList<Integer> ArRandom(int size, int min, int max) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Random rend = new Random();
        for (int i = 0; i < size; i++) {
            array.add(rend.nextInt(min,max+1));
        }
        return array;
    }

    public static int min(ArrayList<Integer> array) {
        int min = array.get(0);
        for (Integer el : array) {
            if (el < min) min = el;
        }
        return min;
    }

    public static int max(ArrayList<Integer> array) {
        int max = array.get(0);
        for (Integer el : array) {
            if (el > max) max = el;
        }
        return max;
    }

    public static double arithmeticMean(ArrayList<Integer> array) {
        Double sum = 0.0;
        for (Integer el : array) {
            sum += el;
        }
        Double ari = sum/array.size();
        return ari;
    }
}
