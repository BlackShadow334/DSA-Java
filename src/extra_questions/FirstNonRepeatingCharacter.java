package extra_questions;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    static char firstNonRepeatedCh(String str){
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();

        for (char ch : chars){
            var count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }

        for (char ch: chars){
            if (map.get(ch) == 1) return ch;
        }
        return Character.MIN_VALUE;
    }

    public static void main(String[] args){
        System.out.println(firstNonRepeatedCh("a green apple"));
        System.out.println(firstNonRepeatedCh("a red apple"));
    }
}
