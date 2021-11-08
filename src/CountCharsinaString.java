import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        //обхождаме всяка една буква
        //ако буквата не сме я срещали -> добавяме запис (буква -> 1)
        //ако буквата сме я срещали -> взимаме моментия брой + 1
        Map<Character, Integer> charsCount = new LinkedHashMap<>();
        //символ -> бр. срещанията

        for (char symbol : text.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }
            if (!charsCount.containsKey(symbol)) {
                //не сме срещали буквата
                charsCount.put(symbol, 1);
            } else {
                //сме срещали буквата
                int currentCount = charsCount.get(symbol); //текущ брой на срещанията
                charsCount.put(symbol, currentCount + 1);
            }
        }
        //обходим всеки един запис в мап: символ (key) -> бр. срещания (value)

        //stream
        //charsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        for (Map.Entry<Character, Integer> entry : charsCount.entrySet()) {
            //{char} -> бр. срещанията
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}