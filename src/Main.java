import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArrays = {2, 3, 5, 7, 8, 10, 11, 12, 13, 15, 16, 19, 21, 26};
        int searchNum = 16;
        System.out.println("Исходный массив: " + Arrays.toString(testArrays));
        System.out.println("Искомый элемент: " + searchNum);
        SortedArrays newArrays = new SortedArrays();
        int[] resultsNewArrays = newArrays.sortedArrays(testArrays);
        System.out.println("Отсортированный массив: " + Arrays.toString(resultsNewArrays));
        myBinarySearch(resultsNewArrays, searchNum);
    }

    public static void myBinarySearch(int[] resultsNewArrays, int searchNum) {
        int startPoint = 0;
        int endPoint = resultsNewArrays.length;
        int middleArrays = (startPoint+endPoint) / 2;
        int middleNum = resultsNewArrays[middleArrays];
        while (middleNum != searchNum) {
            if (middleNum > searchNum) {
                endPoint=middleArrays;
                middleArrays = (startPoint + endPoint) / 2;
                middleNum = resultsNewArrays[middleArrays];
            } else if (middleNum < searchNum) {
                startPoint=middleArrays;
                middleArrays = (startPoint + endPoint) / 2;
                middleNum = resultsNewArrays[middleArrays];
            }
        }
        System.out.println("Ответ: " + middleNum);
    }
}
