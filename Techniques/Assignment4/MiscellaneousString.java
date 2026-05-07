package Assignment4;

import java.util.HashMap;
import java.util.Map;

public class MiscellaneousString {
    

    public static int wordCount(String string){

        if(string.length() > 0){
            String[] count = string.split("\\s+");
            return count.length;
        }
        return 0;
    }

    public static String arrayToString(char[] array){

        String string = new String(array);
        return string;
    }

    public static char mostFrequent(String string){

        // string = string.toLowerCase();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < string.length(); i++){

            char currChar = string.charAt(i);
            

            if(!(map.containsKey(currChar))){
                map.put(currChar, 1);
            }
            else{
                map.put(currChar, map.get(currChar)+1);
            }
        }

        int frequent = 0;
        char letter = ' ';

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {

                if(entry.getValue() > frequent){
                    frequent = entry.getValue();
                    letter = entry.getKey();
                }
            }
            return letter;
    }


    public static String replaceSubstring(String string1,String  string2,String  string3){

        if(string1.contains(string2)){
            string1 = string1.replace(string2, string3);

        }
        return string1;
    }


    //test
    public static void main(String[] args) {
  
        System.out.println(wordCount("Hello World"));

        char[] array = {'H', 'e', 'l', 'l', 'o',' ','W'};
        System.out.println(arrayToString(array));

        System.out.println(mostFrequent("wioreughiwolghrtuhgwrhgkuhvihrwe"));

        System.out.println(replaceSubstring("the dog jumped over the fence", "the", "that"));

    }

}
