// 1.1). Дан список сотрудников:

// Иван Иванов

// Светлана Петрова

// Кристина Белова

// Анна Мусина

// Анна Крутова

// Иван Юрин

// Петр Лыков

// Павел Чернов

// Петр Чернышов

// Мария Федорова

// Марина Светлова

// Мария Савина

// Мария Рыкова

// Марина Лугова

// Анна Владимирова

// Иван Мечников

// Петр Петин

// Иван Ежов

// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

import java.util.LinkedHashMap;
import java.util.Map;

public class homework_12 {
    public static void main(String[] args) {
        String[] employees = {"Иван Иванов","Светлана Петрова","Кристина Белова","Анна Мусина","Анна Крутова","Иван Юрин",
            "Петр Лыков","Павел Чернов","Петр Чернышов","Мария Федорова","Марина Светлова","Мария Савина","Мария Рыкова",
            "Марина Лугова","Анна Владимирова","Иван Мечников","Петр Петин","Иван Ежов"};
        LinkedHashMap<String,Integer> map = Names(employees);
        System.out.println(map);
        popularSort(map);


    }
    public static LinkedHashMap<String,Integer> Names(String[] list) {
        LinkedHashMap<String,Integer> names = new LinkedHashMap<>();
        for (int i = 0; i < list.length; i++) {
            names.put(list[i].split(" ")[0], 1);
        }
        for (int i = 1; i < list.length; i++) {
            String[] temp = list[i].split(" ");
            for (Map.Entry<String,Integer> el : names.entrySet()) {
                if (el.getKey().equals(temp[0])) el.setValue(el.getValue()+1);
            }
        }
        return names;
    }
    public static void popularSort(LinkedHashMap<String,Integer> map) {
        LinkedHashMap<String,Integer> temp = new LinkedHashMap<>();
        Integer max = 0;
        String maxkey = "";
        int size =  map.size();
        for (int i = 0; i < size; i++) {
            for (Map.Entry<String,Integer> el : map.entrySet()) {
                if (el.getValue() > max) 
                {
                    max = el.getValue();
                    maxkey = el.getKey();
                }
            }
            temp.put(maxkey, max);
            map.remove(maxkey);
            max = 0;
            maxkey = "";
        }
        System.out.println(temp);
    }
}   

