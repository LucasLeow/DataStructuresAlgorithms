import java.util.HashMap;
public class ItemInCommon {

    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int i = 0; i < array1.length; i++) {
            hm.put(array1[i], true);
        }

        for (int j = 0; j < array2.length; j++) {
            if (hm.get(array2[j]) != null) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
    }
}
