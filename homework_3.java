import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

// 3. Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - /  *). int a ; int b; String op (op!=”Stop”); (char != ’b’)
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
        while (true) {
            System.out.print("Если хотите остановить калькулятор напишите stop, если хотите продолжить введите любой символ ");
            if (iScanner.hasNext("stop")) {
                break;
            }
            iScanner.nextLine();
            System.out.print("Введите число a: ");
            String a = iScanner.nextLine();
            System.out.print("Введите действие(+,-,/,*)");
            String ch = iScanner.nextLine();
            System.out.print("Введите число b: ");
            String b = iScanner.nextLine();
             switch (ch) {
                case "+":
                    System.out.println(Double.parseDouble(a)+Double.parseDouble(b));
                    res += a + ch + b + "=" + (Double.parseDouble(a)+Double.parseDouble(b))+ "|";
                    break;
                case "-":
                    System.out.println(Double.parseDouble(a)-Double.parseDouble(b));
                    res += a + ch + b + "=" + (Double.parseDouble(a)*Double.parseDouble(b))+ "|";
                    break;
                case "*":
                    System.out.println(Double.parseDouble(a)*Double.parseDouble(b));
                    res += a + ch + b + "=" + (Double.parseDouble(a)*Double.parseDouble(b))+ "|";
                    break;
                case "/":
                    System.out.println(Double.parseDouble(a)/Double.parseDouble(b));
                    res += a + ch + b + "=" + (Double.parseDouble(a)/Double.parseDouble(b))+ "|";
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
