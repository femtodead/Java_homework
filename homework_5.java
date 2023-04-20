
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

// 2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class homework_5 
{
    public static ArrayList RandomArray(ArrayList list, int length, int min, int max) 
    {
        Random rend = new Random();
        for (int i = 0; i < length; i++) 
        {
            list.add(rend.nextInt(min, max+1));
        }
        return list;
    }        
    public static void main(String[] args) throws SecurityException, IOException 
    {
        Logger log = Logger.getLogger(homework_5.class.getName());
        ArrayList<Integer> myMatrix = new ArrayList<>();
        RandomArray(myMatrix, 6, 0, 9);
        System.out.println(myMatrix);
            FileHandler fh = new FileHandler("log.xml");
            log.addHandler(fh);
            XMLFormatter xml = new XMLFormatter();
            fh.setFormatter(xml);
            for (int i = 0; i < myMatrix.size(); i++)
            {
                for (int j = 0; j < myMatrix.size(); j++) 
                {
                    if (myMatrix.get(i) < myMatrix.get(j))
                    {
                        int temp = myMatrix.get(i);
                        myMatrix.set(i, myMatrix.get(j));
                        myMatrix.set(j, temp);
                        log.info(myMatrix.toString());
                    }
                }
            }
        }
}  
