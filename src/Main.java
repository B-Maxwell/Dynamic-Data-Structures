public class Main {

    public static void main(String[] args) throws Exception {

        Bank user = new Bank(); //Creates a Bank User

        user.loadAcct();
        user.enterName();   //Ask user for name
        user.enterChoice(); //Ask user to enter an option


    }
}
