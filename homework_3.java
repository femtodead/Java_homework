import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

// 3. Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - /  *). int a ; int b; String op (op!=”Stop”); (char != ’b’)
// В калькулятор добавьте возможность отменить последнюю операцию.
public class homework_3 {
    private static Logger log = Logger.getLogger(homework_3.class.getName());
    public static void main(String[] args) throws SecurityException, IOException {
        FileHandler fh = new FileHandler("log_calculator.xml");
        log.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);  
        log.info(calculator());
    }
    public static String calculator() {
        Scanner iScanner = new Scanner(System.in);
        String res = "";
        String br = "";
        while (true) {
            System.out.println("Для остановки - stop, для работы с предыдущим результатом - br");
            System.out.print("Введите число a: ");
            String a = iScanner.nextLine();
            if (a.equals("stop")) break;
            if (a.equals("br"))
            {
                a = br;
                System.out.println("Тепеь а =" + br);
            } 
            System.out.print("Введите действие(+,-,/,*)");
            String ch = iScanner.nextLine();
            if (ch.equals("stop")) break;
            if (ch.equals("br"))
            {
                a = br;
                System.out.println("Тепеь а =" + br);
                System.out.print("Введите действие(+,-,/,*)");
                ch = iScanner.nextLine();
                if (ch.equals("stop")) break;
            } 
            System.out.print("Введите число b: ");
            String b = iScanner.nextLine();
            if (b.equals("stop")) break;
            if (b.equals("br"))
            {
                a = br;
                System.out.println("Тепеь а = " + br);
                System.out.print("Введите число b: ");
                b = iScanner.nextLine();
                if (ch.equals("stop")) break;
            } 
             switch (ch) {
                case "+":
                    System.out.println(Double.parseDouble(a)+Double.parseDouble(b));
                    res += a + ch + b + "=" + (Double.parseDouble(a)+Double.parseDouble(b))+ "|";
                    br = Double.toString((Double.parseDouble(a)+Double.parseDouble(b)));
                    break;
                case "-":
                    System.out.println(Double.parseDouble(a)-Double.parseDouble(b));
                    res += a + ch + b + "=" + (Double.parseDouble(a)*Double.parseDouble(b))+ "|";
                    br = Double.toString((Double.parseDouble(a)-Double.parseDouble(b)));
                    break;
                case "*":
                    System.out.println(Double.parseDouble(a)*Double.parseDouble(b));
                    res += a + ch + b + "=" + (Double.parseDouble(a)*Double.parseDouble(b))+ "|";
                    br = Double.toString((Double.parseDouble(a)*Double.parseDouble(b)));
                    break;
                case "/":
                    System.out.println(Double.parseDouble(a)/Double.parseDouble(b));
                    res += a + ch + b + "=" + (Double.parseDouble(a)/Double.parseDouble(b))+ "|";
                    br = Double.toString((Double.parseDouble(a)/Double.parseDouble(b)));
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
                }  
        }   
        iScanner.close();
        return res;
    }
}
