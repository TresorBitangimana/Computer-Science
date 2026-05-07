package Assignment3.PersonCustomer;

public class Customer extends Person{
    
    private String customerNumber;
    private boolean mailingList;

    public Customer(){
        this.customerNumber = "";
        this.mailingList = false;
    }

    public Customer(String n, String a, String p, String c, boolean m){
        super(n,a,p);
        customerNumber = c;
        mailingList = m;
    }

    public void setCustomerNumber(String c){
        customerNumber = c;
    }

    public void setMailingList(boolean m){
        mailingList = m;
    }

    public String getCustomerNumber(){
        return customerNumber;
    }

    public boolean getMailingList(){
        return mailingList;
    }


    //demostration
    public static void main(String[] args) {
        
        Customer josh = new Customer("Josh", "8743 Longisland dr", "8205837485", "A3654", true);

        System.out.println(josh.getName());
        System.out.println(josh.getAddress());
        System.out.println(josh.getPhone());
        System.out.println(josh.getCustomerNumber());
        System.out.println(josh.getMailingList());

        josh.setAddress("7823 LongHord Dr");
        josh.setPhone("6827587385");

        System.out.println(josh.getAddress());
        System.out.println(josh.getPhone());

    }
}
