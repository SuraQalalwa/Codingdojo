public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 6.5;
        double lattePrice = 5.5;
        double cappuccinoPrice = 4.5;
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;

        // total for Sam
        double total = lattePrice *2;
        // total for Jimmy
        double total2 = dripCoffeePrice - lattePrice;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(isReadyOrder1? readyMessage:pendingMessage);
        System.out.println(readyMessage + displayTotalMessage + cappuccinoPrice);

        // Customer3
        System.out.println(generalGreeting + customer3); // Displays "Welcome to Cafe Java, Jimmy"
        System.out.println(isReadyOrder1? readyMessage:pendingMessage);
        System.out.println(readyMessage + displayTotalMessage + dripCoffeePrice);
        System.out.println(displayTotalMessage + total2);

        // Customer2
        System.out.println(generalGreeting + customer2); // Displays "Welcome to Cafe Java, Sam"
        System.out.println(isReadyOrder1? readyMessage:pendingMessage);
        System.out.println(readyMessage + displayTotalMessage + total);

        //
        if (isReadyOrder2) {
            System.out.println(readyMessage + displayTotalMessage + total);
        }
        else {
            System.out.println(pendingMessage);
        }
    }
}
