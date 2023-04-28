import java.util.LinkedList;

// Реализуйте очередь с помощью LinkedList со следующими методами:
// • enqueue() — помещает элемент в конец очереди,
// • dequeue() — возвращает первый элемент из очереди и удаляет его,
// • first() — возвращает первый элемент из очереди, не удаляя.
public class homework_10 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Enqueue(list, 1);
        Enqueue(list, 2);
        Enqueue(list, 3);
        Enqueue(list, 4);
        Enqueue(list, 5);
        System.out.println(list);
        System.out.println(Dequeue(list));
        System.out.println(First(list));

    }
    public static LinkedList<Integer> Enqueue(LinkedList<Integer> list, Integer el) {
        list.addFirst(el);
        return list;
    }
    public static LinkedList<Integer> Dequeue(LinkedList<Integer> list) {
        list.removeLast();
        return list;
    }
    public static Integer First(LinkedList<Integer> list) {
        Integer indx = list.size()-1;
        return list.get(indx);
    }
    
}
