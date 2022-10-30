import java.util.ArrayList;
import java.util.Objects;

public class CoffeeKiosk {
    public ArrayList<Item> menu = new ArrayList<Item>();
    public ArrayList<Orders> orders = new ArrayList<Orders>();
    String itemNumber = System.console().readLine();


    public void addMenuItem(String name, double price, int index) {
        Item items = new Item(name,price,index);
        this.menu.add(items);

    }
    public void displayMenu(){
        for (int i=0; i<this.menu.size(); i++){
            System.out.println(i + "" + menu.get(i).getName()+"-- $"+menu.get(i).getPrice());
        }
    }

    public void newOrder() {

        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Orders order = new Orders(name);
        orders.add(order);
        for (int i=0; i<this.menu.size(); i++){
            System.out.println(i + " " + menu.get(i).getName()+"-- $"+menu.get(i).getPrice());
        }
            // Prompts the user to enter an item number


        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber=System.console().readLine();
            if (itemNumber.equals("q")){
                break;
            }
            else {
                order.addItem(menu.get(Integer.parseInt(itemNumber)));

            }
                 // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details
        // as the example below. You may use the order's display method.
        System.out.println("Thank you " + name + ", Here are your order Details: ");
        order.display();
    }


}