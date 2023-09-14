import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArrays = {15, 12, 7, 6, 11, 10, 21, 19, 25, 29, 22, 3, 3};
        int searchNum = 30;
        System.out.println("Исходный массив: " + Arrays.toString(testArrays));
        System.out.println("Искомый элемент: " + searchNum);
        SortedArrays newArrays = new SortedArrays();
        int[] resultsNewArrays = newArrays.sortedArrays(testArrays);
        System.out.println("Отсортированный массив: " + Arrays.toString(resultsNewArrays));
        myBinarySearch(resultsNewArrays, searchNum);
    }

    public static void myBinarySearch(int[] resultsNewArrays, int searchNum) {
        boolean flag = true;
        int startPoint = 0;
        int endPoint = resultsNewArrays.length;
        int middleArrays = (startPoint + endPoint) / 2;
        int middleNum = resultsNewArrays[middleArrays];
        while (middleNum != searchNum) {
            if (startPoint + 1 == endPoint) {
                System.out.println("Данное значение отсутствует");
                flag = false;
                break;
            } else if (middleNum > searchNum) {
                endPoint = middleArrays;
                middleArrays = (startPoint + endPoint) / 2;
                middleNum = resultsNewArrays[middleArrays];
            } else if (middleNum < searchNum) {
                startPoint = middleArrays;
                middleArrays = (startPoint + endPoint) / 2;
                middleNum = resultsNewArrays[middleArrays];
            }
        }
        if (flag) {
            System.out.println("Ответ: " + middleNum);
        }
    }
}

