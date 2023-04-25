
import java.util.Arrays;


// Реализовать алгоритм сортировки слиянием

public class homework_6 {
    public static void main(String args[]) {
        int[] test = {10,9,8,7,8,6,5,4,1};
        int[] list = mergeSort(test);
        System.out.println(Arrays.toString(list));
    }
    public static int[] mergeSort(int[] sortArr) {
        int[] list1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] list2 = new int[sortArr.length];
        int[] result = Sotr(list1, list2, 0, sortArr.length);
        return result;
    }
    
    public static int[] Sotr(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = Sotr(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = Sotr(buffer1, buffer2, middle, endIndex);
        
        int index1 = startIndex;
        int index2 = middle;
        int Index = startIndex;
        int[] result;
        if (sorted1 == buffer1)
        {
            result = buffer2;
        }
        else
        {
            result = buffer1;
        }
        while (index1 < middle && index2 < endIndex) {
            if (sorted1[index1] < sorted2[index2])
            {
                result[Index++] = sorted1[index1++];
            }
            else
            {
                result[Index++] = sorted2[index2++];
            }
        }
        while (index1 < middle) {
            result[Index++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[Index++] = sorted2[index2++];
        }
        return result;
    }
    }
    