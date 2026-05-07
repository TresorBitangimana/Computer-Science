package Assignment4;

import java.util.Scanner;

public class CapitalLetter {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter some sentences: ");
        String sentence = scanner.nextLine();
        scanner.close();

        System.out.println(capitalized(sentence));

    }

    public static String capitalized(String sentence){

        String newSentence = "";

        for(int i = 0; i < sentence.length(); i++){

            if(i == 0){
                newSentence += String.valueOf(sentence.charAt(i)).toUpperCase();
            }
            else if(sentence.charAt(i) == '.'){
                newSentence += String.valueOf(sentence.charAt(i));
                i++;
                if(Character.isWhitespace(sentence.charAt(i))){
                    newSentence += String.valueOf(sentence.charAt(i));
                    newSentence += String.valueOf(sentence.charAt(i+1)).toUpperCase();
                    i++;
                }
                else{
                    newSentence += String.valueOf(sentence.charAt(i+1)).toUpperCase();
                }
            }
            else{
                newSentence += String.valueOf(sentence.charAt(i));
            }
        }

        return newSentence;
    }

}
