import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        List<String> firstGroup = filterInput(firstWordList);
        List<String> secondGroup = filterInput(secondWordList);
        Predicate<String> isMatch = word -> word.matches("^[A-Z ]+$");
        if (!isInputValid(firstGroup, isMatch) || !isInputValid(secondGroup, isMatch)) {
            throw new RuntimeException("input not valid");
        }

        List<String> result = firstGroup.stream()
                                        .distinct().filter(secondGroup::contains)
                                        .collect(Collectors.toList());
        return result;
    }

    private static boolean isInputValid(List<String> list, Predicate predicate) {
        return list.stream().allMatch(predicate);
    }

    private static List<String> filterInput(String input) {
        return Arrays.stream(input.split(","))
                .map(String::toUpperCase)
                .map(word -> word.replace("", " ").trim())
                .collect(Collectors.toList());
    }
}
