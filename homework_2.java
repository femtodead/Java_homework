import java.util.ArrayList;


// Вывести все простые числа от 1 до 1000
public class homework_2 {
    public static void main(String[] args) {
        ArrayList <Integer> ar = integers(1, 1000);
        System.out.println(ar);
    }
    public static ArrayList <Integer> integers(int min, int max) {
    ArrayList <Integer> arrayNum = new ArrayList<>();
        for (int num = min; num <= max; num++) {
            for (int i = 2; i < 10; i++) {
                if ((i == 9) | (i == num)) arrayNum.add(num);
                if (num%i == 0) break;
            }            
        }
        return arrayNum; 
    }
}
