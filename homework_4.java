
// 1.Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json строки. 
// Если значение null, то параметр не должен попадать в запрос. 
// Параметры для фильтрации: String str = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}"; 
// Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” …

public class homework_4 {
    public static void main(String[] args) {
        String str = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}"; 
        
        System.out.println(Select(str));
    }

    public static String Select(String filtr) {
        StringBuilder res = new StringBuilder("select * from students where ");
        filtr = filtr.replaceAll("[{''}]", "").replaceAll(":", ",");
        String[] ArayWord = filtr.split(",");
        for (int i = 0; i < ArayWord.length; i++) {
            if (ArayWord[i].equals("null")) {
                while (res.charAt(res.length()-1) != ' ') {
                    res.deleteCharAt(res.length()-1);
                }
                continue;
            }
            res.append(ArayWord[i]);
            if (i%2 == 0) res.append("=");
        }
        return res.toString();
    }
}
