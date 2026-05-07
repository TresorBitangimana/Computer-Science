/**
 * @author Tresor Bitangimana
 * @since Jan 26/ 2026
 * 
 *  TeamLeader class, create a team leader class that extends the production worker class,
 *  This class stoles the production workers monthly bonus, required trainign hours and 
 *  the training hours attended.
 */

package Assignment2;

public class TeamLeader extends ProductionWorker{
    
    private double monthlyBonus;
    private double requiredTrainingHours;
    public double trainingHoursAttended;

    public TeamLeader(String n, String num, String date, int sh, double rate, double mb, double rth, double tha){
        super(n, num, date, sh, rate);

        monthlyBonus = mb;
        requiredTrainingHours = rth;
        trainingHoursAttended = tha;

    }

    public TeamLeader(){
        super();
        monthlyBonus = 0;
        requiredTrainingHours = 0;
        trainingHoursAttended = 0;
    }

    public void setMonthlyBonus(double b){
        monthlyBonus = b;
    }

    public void setRequiredTrainingHours(double p){
        requiredTrainingHours = p;
    }

    public void setTrainingHoursAttended(double t){
        trainingHoursAttended = t;
    }

    public double getMonthlyBonus(){
        return monthlyBonus;
    }

    public double getRequiredTrainingHours(){
        return requiredTrainingHours;
    }

    public double getTrainingHoursAttended(){
        return trainingHoursAttended;
    }

    @Override
    public String toString(){
        return super.toString()+"Monthly bonus: "+monthlyBonus+
                " \nRequired training hours: "+requiredTrainingHours+
                "\nTraining hours attended"+trainingHoursAttended;
    }


    public static void main(String[] args) {
        
        //test
        TeamLeader leader = new TeamLeader("John", "9872-D", "Jan 27/ 2025", 1, 15.5, 1000, 5, 3);

        System.out.println(leader.getName());
        System.out.println(leader.getEmployeeNumber());
        System.out.println(leader.getHireDate());
        System.out.println(leader.getShift());;
        System.out.println(leader.getPayRate());
        System.out.println(leader.getMonthlyBonus());
        System.out.println(leader.getRequiredTrainingHours());
        System.out.println(leader.getTrainingHoursAttended());

        leader.setName("Bob");
        System.out.println(leader.getName());
        leader.setPayRate(18);
        System.out.println(leader.getPayRate());

    }
}
