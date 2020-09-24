package cc.oilslug;

import java.util.*;

public class StringPredictionAPI {

    public static String predictString(String input, List<String> values) {
        String predicted = "";
        HashMap<String, Integer> scores = new HashMap<>();
        String[] letters = input.split("");

        for (String value : values) {
            if (value.equals(input)) {
                return value;
            } else if (value.equalsIgnoreCase(input)) {
                predicted = value;
            } else {
                int score = 0;
                String[] valueLetters = value.split("");
                for (int i = 0; i < valueLetters.length; i++) {
                    for (int k = 0; k < letters.length; k++) {
                        if (valueLetters[i].equalsIgnoreCase(letters[k])){
                            score++;
                        }
                    }
                }
                scores.put(value, score);
                System.out.println(value + " : " + score);
            }
            int highestScore = 0;
            for (Map.Entry<String, Integer> set : scores.entrySet()) {
                if(set.getValue() > 0 && set.getValue() > highestScore){
                    highestScore = set.getValue();
                    predicted = set.getKey();
                }else if(set.getValue() == highestScore && highestScore != 0){
                    if(letters[0].equalsIgnoreCase(set.getKey().split("")[0]) && !letters[0].equalsIgnoreCase(predicted.split("")[0])){
                        highestScore = set.getValue()+1;
                        predicted = set.getKey();
                    }
                }
            }
        }
        return predicted;
    }

}
