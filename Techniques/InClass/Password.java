package InClass;

public class Password {
    public static void main(String[] args) {
        
        String passWord = "q9er8pgy438G";

        boolean hasNum = false;
        boolean hasUpper = false;
        boolean noWhiteSpase = true;

        for(int i = 0; i < passWord.length(); i++){

            char currChar = passWord.charAt(i);

            if(Character.isDigit(currChar)){
                hasNum = true;
            }
            else if(Character.isUpperCase(currChar)){
                hasUpper = true;
            }
            else if(Character.isWhitespace(currChar)){
                noWhiteSpase = false;
            }
        }

        if(hasNum && hasUpper && noWhiteSpase){
            System.out.println("The password is valid");
        }
        else{
            System.out.println("The passsword is not valid");
        }

    }
}
