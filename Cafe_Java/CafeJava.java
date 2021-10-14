public class CafeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = ", Your total is $";

        double mochaPrice = 3.5;
        double dripCoffeePrice = 4.3;
        double lattePrice = 4.2;
        double cappuccinoPrice = 2.5;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        System.out.println(generalGreeting + customer1);

        System.out.println(customer1 + pendingMessage);

        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage);

            System.out.println(displayTotalMessage + cappuccinoPrice);
        }

        System.out.println(customer2 + displayTotalMessage + (lattePrice + lattePrice));
        if(isReadyOrder2){
            isReadyOrder2 = false;
            System.out.println(customer2 + pendingMessage);
        }

        System.out.println(customer3 + " your new total is an additional .1 for the latte");

    }
}