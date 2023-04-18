// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
public class homework_1 {
    public static void main(String[] args) {
        System.out.println(SumNumber(5));
        System.out.println(FactorialNum(5));
    }
    public static int SumNumber(int num) {
        int sum = 0;
        for (int n = 0; n <= num; n++) {
            sum += n;            
        }
        return sum;        
    }
    public static int FactorialNum(int num) {
        int fact = 1;
        for (int n = 1; n <= num; n++) {
            fact *= n;            
        }
        return fact; 
    }
}