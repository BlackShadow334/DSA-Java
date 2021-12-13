package extra_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRepeatingCharacter {

    static char firstRepeatingCh(String str){
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();

        for (var ch : chars){
            var count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }

        for (var ch : chars)
            if (map.get(ch) > 1) return ch;

        return Character.MIN_VALUE;
      }

      // Wrong implementation, because when using set it gives different output for "black apple"
//    static char firstRepeatingCh(String str){
//        Set<Character> set = new HashSet<>();
//        var chars = str.toCharArray();
//
//        for (var ch : chars){
//            System.out.println(set);
//            if (set.contains(ch)) return ch;
//            set.add(ch);
//        }
//        return Character.MIN_VALUE;
//    }

    public static void main(String[] args){
        System.out.println(firstRepeatingCh("green apple"));
        System.out.println(firstRepeatingCh("black apple"));
    }
}
