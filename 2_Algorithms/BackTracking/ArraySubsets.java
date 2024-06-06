import java.util.ArrayList;
import java.util.List;

public class ArraySubsets {

    public static void calcSubset(List<Integer> numbers,
                                  List<List<Integer>>results,
                                  List<Integer> subset,
                                  int idx) {

        // add current subset to results list
        results.add(new ArrayList<>(subset));

        // Generate subsets recursively
        for (int i = idx; i < numbers.size(); i++) {

            // include number in subset
            subset.add(numbers.get(i));

            // Recursively generate subsets with current element included
            calcSubset(numbers, results, subset, i + 1);

            // exclude current element from subset (backtracking)
            subset.remove(subset.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(List<Integer> numbers) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();

        int idx = 0;
        calcSubset(numbers, results, subset, idx);

        return results;
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);
        List<List<Integer>> results = subsets(numbers);

        System.out.println(results);
    }
}
