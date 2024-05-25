public class FindMinMaxElement {
    public static int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int[] resultArr = new int[2];
        resultArr[0] = min;
        resultArr[1] = max;

        return resultArr;
    }

    public static void main(String[] args) {
        int[] data = {1, 423, 6, 46, 34, 23, 13, 53, 4};
        int[] ansArr = findMinMax(data);

        System.out.println("Min value: " + ansArr[0] + " | Max value: " + ansArr[1]);
    }
}