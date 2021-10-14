import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CafeUtil {
    public Integer getStreakGoal(Integer weeks) {
        int streak = 0;
        int counter = 1;
        while(counter < weeks + 1) {
            streak = streak + counter;
            counter++;
        }
        return streak;
    }

    public void printPriceChart(String name, Double price, Integer quantity) {

        System.out.printf("%s \n", name);

        for(int i = 0; i < quantity; i++){
            System.out.printf("%s - $%s \n", i + 1, (price*(i+1)));
        }

        // return "Banana";
    }

    public Double getOrderTotal(double[] lineItems){
        double total = 0;

        for(double num : lineItems){
            total = total + num;
        }

        return total;
    }

    public void displayMenu(ArrayList <String> menu, ArrayList <Double> prices){

        for(int i = 0; i < menu.size(); i++){
            System.out.printf("%s %s -- $%s \n", i, menu.get(i), prices.get(i));    
        }

    }

    public void addCustomer(ArrayList <String> customers) {
        String userName = System.console().readLine("Please enter your name: \n");
        System.out.printf("Hello, %s! You have %s people ahead of you \n", userName, customers.size());

        customers.add(userName);
    }

}