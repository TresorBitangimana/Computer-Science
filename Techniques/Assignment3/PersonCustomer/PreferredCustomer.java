package Assignment3.PersonCustomer;

public class PreferredCustomer extends Customer{
    
    private double purchases;
    private double discountLevel;

    public PreferredCustomer(){
        purchases = 0;
        discountLevel = 0;
    }

    public PreferredCustomer(String n, String a, String p, String c, boolean m, double pur){
        super(c, a, p, c, m);
        purchases = pur;
    }
    
    public void setPurchases(double p) {
        purchases = p;
    }

    public double getPurchases() {
        return purchases;
    }

    public double getDiscountLevel() {

        if(purchases >= 500 && purchases < 1000){
            discountLevel = 5;
        }
        else if(purchases >= 1000 && purchases < 1500){
            discountLevel = 6;
        }
        else if(purchases >= 1500 && purchases < 2000){
            discountLevel = 7;
        }
        else if(purchases >= 2000){
            discountLevel = 10;
        }

        return discountLevel;
    }

        public static void main(String[] args) {
        
        PreferredCustomer josh = new PreferredCustomer("Josh", "8743 Longisland dr", "8205837485", "A3654", true, 1000);

        System.out.println(josh.getName());
        System.out.println(josh.getAddress());
        System.out.println(josh.getPhone());
        System.out.println(josh.getCustomerNumber());
        System.out.println(josh.getMailingList());
        System.out.println(josh.getPurchases());
        System.out.println(josh.getDiscountLevel());

        josh.setAddress("7823 LongHord Dr");
        josh.setPhone("6827587385");
        josh.setPurchases(2000);

        System.out.println(josh.getAddress());
        System.out.println(josh.getPhone());
        System.out.println(josh.getDiscountLevel());
    }

}
