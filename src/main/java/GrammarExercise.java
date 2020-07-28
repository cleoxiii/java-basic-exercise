import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GrammarExercise {
    public static void main(String[] args) {
        // get input from terminal as required
        String firstWordList = args[0];
        String secondWordList = args[1];

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        // print output to the terminal as required
        System.out.println(result);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        // please implement this method here
        List<String> firstGroup = Arrays.asList(firstWordList.split(","));
        List<String> secondGroup = Arrays.asList(secondWordList.split(","));
        Predicate<String> isMatch = word -> word.matches("^[a-zA-Z]+$");
        if (!isInputValid(firstGroup, isMatch) || !isInputValid(secondGroup, isMatch)) {
            throw new RuntimeException("input not valid");
        }
        return null;
    }

    private static boolean isInputValid(List<String> list, Predicate predicate) {
        return list.stream().allMatch(predicate);
    }
}
