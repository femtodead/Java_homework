
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// 1) Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class homework_11 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> phoneBookmap = new HashMap<>();
        for (int i = 0; i < 6; i++) { // тут шесть итераций, под шесть записей
            HashMap<String, ArrayList<Integer>> temp = phoneBook();
            for (Map.Entry<String, ArrayList<Integer>> el : temp.entrySet()) {
                phoneBookmap.put(el.getKey(), el.getValue()); 
            }
        }
        System.out.println(phoneBookmap);        
    }

    public static HashMap<String, ArrayList<Integer>> phoneBook() {
        HashMap<String, ArrayList<Integer>> pb = new HashMap<>();
        ArrayList<Integer> phone = new ArrayList<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите имя фамилию через пробел: ");
        String key = iScanner.nextLine();
        System.out.print("Сколько номеров телефона у данного человека: ");
        Integer count = iScanner.nextInt();
        pb.put(key, addPhone(phone, count));
        return pb;
    }
    public static ArrayList<Integer> addPhone(ArrayList<Integer> list , Integer count) {
        for (int i = 0; i < count; i++) {
                Scanner iScanner = new Scanner(System.in);
                System.out.println("Введите номер телефона: ");
                Integer val = iScanner.nextInt();
                list.add(val);
        }
        return list;
    }
}
