import java.util.Scanner;
public class CustomerMailApplication {
    /**
     * @param args the command line arguments
     */
    private Customer customer;
    public CustomerMailApplication(Customer customer) {
        this.customer = customer;
    }
    public static String getCustomerTypeFromUser() {
        String customerType = null;
        Scanner inp = new Scanner(System.in);
        System.out.print("Please choose customer type 1. Regular, 2. Mountain, 3. Delinquent ");
        int type = inp.nextInt();
        switch(type) {
            case 1:
                customerType = "Regular";
                break;
            case 2:
                customerType = "Mountain";
                break;
            case 3:
                customerType = "Delinquent";
                break;
        }
        inp.close();
        return customerType;
    }
    public String generateMail() {
        return customer.createMail();
    }
    public String generateBrochure() {
        return customer.createBrochure();
    }
    
    public static void main(String[] args) {
        String customerType = getCustomerTypeFromUser();
        Customer customer = CustomerMailFactory.createCustomer(customerType);
        CustomerMailApplication app = new CustomerMailApplication(customer);
        System.out.println(app.generateMail());
        System.out.println(app.generateBrochure());
     //   System.out.println("Mail:\n" + app.customer.generateMail());
     //   System.out.println("\nBrochure:\n" + app.customer.generateBrochure());
    }
}

class CustomerMailFactory {

    public static Customer createCustomer(String customerType) {
        switch (customerType) {
            case "Regular":
                return new RegularCustomer();
            case "Mountain":
                return new MountainCustomer();
            case "Delinquent":
                return new DelinquentCustomer();
            default:
                throw new IllegalArgumentException("Invalid customer type: " + customerType);
        }
    }
}
