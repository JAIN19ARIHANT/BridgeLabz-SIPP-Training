public class Main {
    public static void main(String[] args) {

        EmailManager em = new EmailManager();

        em.addEmployee("Arihant","aj@company.com");
        em.addEmployee("asd*@","asd*@v.com");
        em.addEmployee("Suryansh","Suryansh.gr@company.com");
        em.addEmployee("Arjun","Arjun_valid@company.com");
        em.addEmployee("Invalid","invalid@google.co.in");

        System.out.println(em.searchByDomain("company.com"));

        try {
            System.out.println("\n------- EMPLOYEES -------");
            for (Employee e : em.searchByDomain("company.com")) {
                System.out.println(e);
                System.out.println();
            }
        }catch (NoEmployeeFoundException nefe) {
            System.err.println(nefe.getMessage());
        }
    }
}