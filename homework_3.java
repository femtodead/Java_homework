import java.util.Scanner;


// 3. Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - /  *). int a ; int b; String op (op!=”Stop”); (char != ’b’)
public class homework_3 {
    public static void main(String[] args) {
        calculator();
    }
    public static void calculator() {
        Scanner iScanner = new Scanner(System.in);
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
                    break;
                case "-":
                    System.out.println(Double.parseDouble(a)-Double.parseDouble(b));
                    break;
                case "*":
                    System.out.println(Double.parseDouble(a)*Double.parseDouble(b));
                    break;
                case "/":
                    System.out.println(Double.parseDouble(a)/Double.parseDouble(b));
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
             }  
        }   
        iScanner.close();    
    }

}
