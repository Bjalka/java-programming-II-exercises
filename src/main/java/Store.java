import java.util.Scanner;

public class Store {
    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }
    /**
     * This method is used to simulate a shopping experience in the store.
     * It allows a customer to add products to their shopping cart and calculates the total price.
     * The method interacts with the user through the console.
     *
     * @param customer The name of the customer shopping in the store.
     */
    
    // The method allows the customer to add products to their cart until they press enter without inputting a product name.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            if (product.isEmpty()) {
                break;
            }

            if (this.warehouse.products().contains(product)) {
                if (this.warehouse.take(product)) {
                    cart.add(product, this.warehouse.price(product));
                } else {
                    System.out.println("Sorry, we are out of stock for " + product);
                }
            } else {
                System.out.println("Sorry, we don't have " + product + " in our store.");
            }
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }
}
