
import java.util.HashSet;
import java.util.Scanner;


public class homework_14 {
    public static void main(String[] args) {
        HashSet<Laptop> laptopsSet = new HashSet<Laptop>();
        for (int i = 1; i < 11; i++) {
            String name = "Ноутбук " + i;
            Integer temp = 11;
            String operatingSystem = "Windows ";
            if (i >= 7)  operatingSystem += i;
            else operatingSystem += temp;
            Integer RAM = 8 * i;
            Integer HDD = 512 * i;
            Integer[] ColorRGB = {255, 0, 0};
            ColorRGB[0] -= i;
            ColorRGB[1] += i;
            ColorRGB[2] += i;
            Laptop nout = new Laptop(name, RAM, HDD, operatingSystem, ColorRGB);
            laptopsSet.add(nout);
        }
        for (Laptop laptop : laptopsSet) {
            laptop.printInf();
        }
        search(laptopsSet);
        System.out.println();
        MinMAx(laptopsSet);
    }
    public static void search(HashSet<Laptop> set) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Выберети действие и введите соответствующую цифрн \n1 - поиск по ОЗУ \n2 - поиск по Объём ЖД \n3 - поиск по Операционная система \n4 - поиск по Цвет(в RGB системк через запятую)");
        String action = iScanner.nextLine();
        System.out.println("Введите параметр: ");
        String parameter = iScanner.nextLine();
        switch (action) {
            case "1":
            for (Laptop laptop : set) {
                Integer parametrInt = Integer.parseInt(parameter);
                laptop.filtrRAM(parametrInt);
            }
            break;
            case "2":
            for (Laptop laptop : set) {
                Integer parametrInt2 = Integer.parseInt(parameter);
                laptop.filtrHDD(parametrInt2);
            }
            break;
            case "3":
                for (Laptop laptop : set) {
                    laptop.filtrOperatingSystem(parameter);
                }
                break;                
                case "4":
                for (Laptop laptop : set) {
                    Integer[] parametrRGB = {Integer.parseInt(parameter.split(",")[0]),Integer.parseInt(parameter.split(",")[1]),Integer.parseInt(parameter.split(",")[2])};
                    laptop.filtrColor(parametrRGB);
                }
                break;
            default:
                System.out.println("Нет такого ноута");
                break;
            }
        }
        public static void MinMAx(HashSet<Laptop> set) {
            Laptop lp = new Laptop();
            System.out.print("максимальный цвет: ");
            lp.maxColor(set).printInf(); // здесь может быть немного не понятно, значение больше если сумма значений в массиве RGB больше, соответственно с минимумом наоборот
            System.out.print("минимальный цвет: ");
            lp.minColor(set).printInf();
            System.out.print("максимальная ОС: ");
            lp.maxOperatingSystem(set).printInf();
            System.out.print("минимальная ОС: ");
            lp.minOperatingSystem(set).printInf();
            System.out.print("максимальный диск: ");
            lp.maxHDD(set).printInf();
            System.out.print("минимальный диск: ");
            lp.minHDD(set).printInf();
            System.out.print("максимальная оперативка: ");
            lp.maxRAM(set).printInf();
            System.out.print("минимальная оперативка: ");
            lp.minRAM(set).printInf();
    }
    
}
// Урок 6. Хранение и обработка данных ч3: множество коллекций Set
// Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.

// Создать множество ноутбуков.

// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

// “Введите цифру, соответствующую необходимому критерию:

// 1 - ОЗУ

// 2 - Объём ЖД

// 3 - Операционная система

// 4 - Цвет …

// Далее нужно запросить минимальные и максимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

class Laptop{
    String name = "Ноутбук HUAWEI 53013ERR BoD-WDH9 MateBook D15";
    Double price = 49999.0;
    String operatingSystem = "Windows 11";
    String CPU = "Intel Core i5 1135";
    String videoCard = "Intel Iris Xe Graphics";
    Double screen = 15.6;
    Integer HDD = 512;
    Integer RAM = 8;
    Integer[] ColorRGB = {255, 0, 0};
    Double dimensions = 16.9*357.8*229.9;

    Laptop()
    {
        name = "";
        price = 0.0;
        operatingSystem = "";
        CPU = "";
        videoCard = "";
        screen = 0.0;
        HDD = 0;
        RAM = 0;
        ColorRGB[0] = 0;
        ColorRGB[1] = 0;
        ColorRGB[2] = 0;
        dimensions = 0.0*0.0*0.0;
    }

    Laptop(String name, Integer RAM, Integer HDD, String operatingSystem, Integer[] ColorRGB){
        if (name == null) this.name = "Ноутбук HUAWEI 53013ERR BoD-WDH9 MateBook D15";
        this.name = name;
        price = 49999.0;
        if (operatingSystem == null) this.operatingSystem = "Windows 11";
        this.operatingSystem = operatingSystem;
        CPU = "Intel Core i5 1135";
        videoCard = "Intel Iris Xe Graphics";
        screen = 15.6;
        if (HDD == null) this.HDD = 512;
        this.HDD = HDD;
        if (RAM == null) this.RAM = 8 ;
        this.RAM = RAM;
        if (ColorRGB == null){
            this.ColorRGB[0] = 255;
            this.ColorRGB[1] = 0;
            this.ColorRGB[2] = 0;
        } 
        this.ColorRGB = ColorRGB;
        dimensions = 16.9*357.8*229.9;
    }
    void printInf(){
        System.out.println(this.name+", ОС - " + this.operatingSystem+", RAM - "+ this.RAM+", Hdd - "+ this.HDD+", Цвет(RGB) - ["+ this.ColorRGB[0] + "," + this.ColorRGB[1] + ","+ this.ColorRGB[2]+ "]");
    }
    
    void filtrRAM(Integer RAM){
        if (RAM == null | !(RAM instanceof Integer)) System.out.print("Некорректный ввод");
        if (this.RAM == RAM) System.out.print(this.name + " ");
    }
    void filtrHDD(Integer HDD){
        Integer temp = HDD;
        if (HDD == null | !(HDD instanceof Integer)) System.out.print("Некорректный ввод"); 
        if (this.HDD*2 == temp*2) System.out.print(this.name + " "); // здесь пришлос мудрить с условием, так  и не понял почему (this.HDD == temp) всегда фолс, типы проверил, значения понятно дело тоже
    }// возможно была какаято проблема с ссылками, но для Integera такую белеберду не видел
    void filtrOperatingSystem(String operatingSystem){
        if (operatingSystem == null | !(operatingSystem instanceof String)) System.out.print("Некорректный ввод");
        if (this.operatingSystem.equals(operatingSystem)) System.out.print(this.name + " ");
    }
    void filtrColor(Integer[] ColorRGB){
        if (ColorRGB == null | !(ColorRGB instanceof Integer[])) System.out.print("Некорректный ввод");
        if (this.ColorRGB[0]+ColorRGB[0] == ColorRGB[0]*2 & this.ColorRGB[1]+ColorRGB[1] == ColorRGB[1]*2 & this.ColorRGB[2]+ColorRGB[2] == ColorRGB[2]*2) System.out.print(this.name + " ");
    } // здесь таже фигня как и с HDD

    Laptop maxRAM(HashSet<Laptop> laptopsSet){
        Laptop lap = new Laptop(this.name, 0, this.HDD, this.operatingSystem, this.ColorRGB);
        if ( laptopsSet == null) System.out.print("Некорректный ввод");
        for (Laptop laptop : laptopsSet) {         
            if (lap.RAM < laptop.RAM) lap = laptop;
            else  continue;
        }
        return lap;
    }
    Laptop maxHDD(HashSet<Laptop> laptopsSet){
        Laptop lap = new Laptop(this.name, this.RAM, 0, this.operatingSystem, this.ColorRGB);
        if ( laptopsSet == null) System.out.print("Некорректный ввод");
        for (Laptop laptop : laptopsSet) {         
            if (lap.HDD < laptop.HDD) lap = laptop;
            else  continue;
        }
        return lap;
    }
    Laptop maxOperatingSystem(HashSet<Laptop> laptopsSet){
        Laptop lap = new Laptop(name, RAM, HDD, "Винда 0", ColorRGB);
        if (operatingSystem == null) System.out.print("Некорректный ввод");
        for (Laptop laptop : laptopsSet) {
            String[] ferst_lap_op = lap.operatingSystem.split(" ");
            String[] secondLaptop_op = laptop.operatingSystem.split(" ");
            Integer f_num_op = Integer.parseInt(ferst_lap_op[1]);
            Integer s_num_op = Integer.parseInt(secondLaptop_op[1]);
            if (f_num_op < s_num_op) lap = laptop;
        }
        return lap;
    }
    Laptop maxColor(HashSet<Laptop> laptopsSet){
        Integer[] temp_calor = {0,0,0};
        Laptop max = new Laptop(null, null, null, null, temp_calor);
        for (Laptop laptop : laptopsSet) {
            if (max.ColorRGB[0] + max.ColorRGB[1] + max.ColorRGB[2] < laptop.ColorRGB[0] + laptop.ColorRGB[1] + laptop.ColorRGB[2]) max = laptop;
            else continue;
        }
        return max;
    }
    Laptop minRAM(HashSet<Laptop> laptopsSet){
        Laptop lap = new Laptop(this.name, 160000, this.HDD, this.operatingSystem, this.ColorRGB);
        if ( laptopsSet == null) System.out.print("Некорректный ввод");
        for (Laptop laptop : laptopsSet) {         
            if (lap.RAM > laptop.RAM) lap = laptop;
            else  continue;
        }
        return lap;
    }
    Laptop minHDD(HashSet<Laptop> laptopsSet){
        Laptop lap = new Laptop(this.name, this.RAM, 100000000, this.operatingSystem, this.ColorRGB);
        if ( laptopsSet == null) System.out.print("Некорректный ввод");
        for (Laptop laptop : laptopsSet) {         
            if (lap.HDD > laptop.HDD) lap = laptop;
            else  continue;
        }
        return lap;
    }
    Laptop minOperatingSystem(HashSet<Laptop> laptopsSet){
        Laptop lap = new Laptop(name, RAM, HDD, "Винда 200", ColorRGB);
        if (operatingSystem == null) System.out.print("Некорректный ввод");
        for (Laptop laptop : laptopsSet) {
            String[] ferst_lap_op = lap.operatingSystem.split(" ");
            String[] secondLaptop_op = laptop.operatingSystem.split(" ");
            Integer f_num_op = Integer.parseInt(ferst_lap_op[1]);
            Integer s_num_op = Integer.parseInt(secondLaptop_op[1]);
            if (f_num_op > s_num_op) lap = laptop;
        }
        return lap;
    }
    Laptop minColor(HashSet<Laptop> laptopsSet){
        Integer[] temp_calor = {255,255,255};
        Laptop min = new Laptop(null, null, null, null, temp_calor);
        for (Laptop laptop : laptopsSet) {
            if (min.ColorRGB[0] + min.ColorRGB[1] + min.ColorRGB[2] > laptop.ColorRGB[0] + laptop.ColorRGB[1] + laptop.ColorRGB[2]) min = laptop;
            else continue;
        }
        return min;
    }
    Laptop clone(Laptop Lap)
    {   
        Laptop clone_lap = new Laptop(Lap.name, Lap.RAM, Lap.HDD, Lap.operatingSystem, ColorRGB);
        return clone_lap;
    }
}