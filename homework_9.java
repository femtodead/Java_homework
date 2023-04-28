import java.util.LinkedList;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.
public class homework_9 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        System.out.println(revers(list));
    }

    public static LinkedList<Integer> revers(LinkedList<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            list.add(i, list.peekLast());
            list.removeLast();
        }
        return list;
    }
}
