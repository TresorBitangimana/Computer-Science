/**
 * @Author Tresor Bitangimana
 * @since Jan 29 2026
 */

package Assignment3.Course_Grade;

public class Essay extends GradedActivity{
    
    private double grammer; //field for the grammer score
    private double spelling; //field for the spelling score
    private double correctLength; //field for th ecorrect length score
    private double content; //field for the content score

    /**
     * class constructor
     * @param gr
     * @param sp
     * @param len
     * @param cnt
     */
    public Essay(double gr, double sp, double len, double cnt){ //Error in UML diageam, directs the constructor to be void
        grammer = gr;
        spelling = sp;
        correctLength = len;
        content = cnt;
    }

    /**
     * setter method for grammer
     * @param g
     */
    public void setGrammer(double g){
        if(g >= 0 && g <= 30){
            grammer = g;
        }
        else{
            System.out.println("invalid score for grammer");
        }
    }

    /**
     * setter method for spelling
     * @param s
     */
    public void setSpelling(double s){
        if(s >= 0 && s <= 20){
            spelling = s;
        }
        else{
            System.out.println("invalid score for spelling");
        }
    }

    /**
     * setter method for corect length
     * @param c
     */
    public void setCorrectLength(double c){
        if(c >= 0 && c <= 20){
            correctLength = c;
        }
        else{
            System.out.println("invalid score for correct length");
        }
    }

    /**
     * setter method for content
     * @param c
     */
    public void setContent(double c){
        if(c >= 0 && c <= 30){
            content = c;
        }
        else{
            System.out.println("invalid score for content");
        }
    }

    /**
     * getter method for grammer
     * @return grammer score
     */
    public double getGrammer(){
        return grammer;
    }

    /**
     * getter method for spelling
     * @return spelling score
     */
    public double getSpelling(){
        return spelling;
    }

    /**
     * getter method for corrent length
     * @return correctLength score
     */
    public double getCorrectLength(){
        return correctLength;
    }

    /**
     * getter method for content
     * @return content score
     */
    public double getContent(){
        return content;
    }

    /**
     * get score method
     * <p>gets the score by adding the grammer, spelling, 
     * correctLength, and content score together<p/>
     * @return the sum of all the scores
     */
    public double getScore(){

        double total = grammer + spelling + correctLength + content;

        setScore(total);
        return total;
    }

    //demo
    public static void main(String[] args) {
        
        Essay essay = new Essay(30, 20, 10, 30);

        System.out.println(essay.getSpelling());
        System.out.println(essay.getGrammer());
        System.out.println(essay.getCorrectLength());
        System.out.println(essay.getContent());
        System.out.println(essay.getScore());

        essay.setCorrectLength(20);

        System.out.println(essay.getScore());

    }

}
