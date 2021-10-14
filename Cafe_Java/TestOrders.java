import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args){
        //Menu Items
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 4.0;
        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 2.75;
        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 3.69;
        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 2.34;


        //Order variables -- order 1, order 2 , etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        Order order2 = new Order();
        order2.name = "Jimmy";
        Order order3 = new Order();
        order3.name = "Noah";
        Order order4 = new Order();
        order4.name = "Sam";



        //Application Simulations
        // System.out.println(order1);
        order2.items.add(item1);
        order2.total += item1.price;
        // System.out.printf("Order 2 Total: A %s for $%.2f \n", order2.items, order2.total);
        order3.items.add(item4);
        order3.total += item4.price;

        order4.items.add(item2);
        order4.total += item2.price;

        order1.ready = true;

        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price + item2.price;

        order2.ready = true;

        // Use this example code to test various orders' updates

        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

    }
}