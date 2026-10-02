import java.util.Scanner;

public class Menu {
    public static boolean running = true;

    public static void runLoop() {
        while (running) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------------------------------------");
            System.out.println("Sneaker Collector");
            System.out.println("-----------------");
            System.out.println("[1]: Add a Sneaker");
            System.out.println("[2]: Print Entire Vault");
            System.out.println("[3]: Search for a Shoe");
            System.out.println("[4]: Filter by Brand");
            System.out.println("[5]: Wear a Shoe Once");
            System.out.println("[6]: Return Deadstock Shoes");
            System.out.println("[7]: Print Stock Price of Entire Vault");
            System.out.println("[8]: Print Resale Price of Entire Vault");
            System.out.println("[9]: Set Resale Price of a Shoe");
            System.out.println("[10]: Remove a Sneaker");
            System.out.println("[11]: Quit");

            String option = sc.nextLine();

            if (option.equals("1")) {
                boolean isDeadstock = false;
                clearScreen();
                System.out.println("Make sure everything is spelled properly!");
                System.out.println("Entries will be put in exactly how they're spelled.");
                System.out.println("Enter Sneaker Brand: ");
                String brand = sc.nextLine();
                System.out.println("Enter Sneaker Model: ");
                String model = sc.nextLine();
                System.out.println("Enter Sneaker Colorway: ");
                String colorway = sc.nextLine();
                System.out.println("Enter Sneaker Size: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Error: Did not enter a valid number!");
                    System.out.println("Please enter a valid shoe size");

                    sc.next();
                }
                double size = sc.nextDouble();
                while (size < 0) {
                    System.out.println("Error: Shoe size must be a positive number!");
                    System.out.println("Please enter a valid shoe size");

                    size = sc.nextDouble();
                }

                System.out.println("Enter Stock Price of Sneaker: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Error: Did not enter a valid number!");
                    System.out.println("Please enter a valid price");

                    sc.next();
                }
                double stockPrice = sc.nextDouble();
                while (stockPrice < 0) {
                    System.out.println("Error: Stock Price must be a positive number!");
                    System.out.println("Please enter a valid stock price");

                    stockPrice = sc.nextDouble();
                }
                System.out.println("Enter Resale Price of Sneaker: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Error: Did not enter a valid number!");
                    System.out.println("Please enter a valid price");

                    sc.next();
                }
                double resalePrice = sc.nextDouble();
                while (resalePrice < 0) {
                    System.out.println("Error: Resale Price must be a positive number!");
                    System.out.println("Please enter a valid resale price");

                    resalePrice = sc.nextDouble();
                }

                sc.nextLine(); // Consumes \n from nextDouble()
                System.out.println("Is the Sneaker Deadstock: ");
                String deadstockString = sc.nextLine();
                if (deadstockString.equals("Y") || deadstockString.equals("y") || deadstockString.equals("Yes") || deadstockString.equals("yes") || deadstockString.equals("True") || deadstockString.equals("true")) {
                    isDeadstock = true;
                } else if (deadstockString.equals("N") || deadstockString.equals("n") || deadstockString.equals("No") || deadstockString.equals("no") || deadstockString.equals("False") || deadstockString.equals("false")) {
                    isDeadstock = false;
                } else {
                    System.out.println("Did not enter a proper value. Please enter (Y, y, Yes, yes, True, true) or (N, n, No, no, False, false)");
                    System.out.println("Defaulting deadstock value to true.");
                    isDeadstock = true;
                }
                if (brand.equals("") || model.equals("") || colorway.equals("")) {
                    System.out.println("Please input proper values, do not leave variables blank.");
                    System.out.println("Try again.");
                } else {
                    Sneaker sneaker = new Sneaker(brand, model, colorway, size, stockPrice, resalePrice, isDeadstock);
                    Collector.addSneaker(sneaker);
                }
            } else if (option.equals("2")) {
                clearScreen();
                for (int i = 0; i < Collector.getArrayLength(); i++) {
                    Sneaker sneaker = Collector.getSneaker(i);
                    System.out.println(sneaker.toString());
                }
            } else if (option.equals("3")) {
                clearScreen();
                System.out.println("Make sure everything is spelled properly!");
                System.out.println("Entries will be put in exactly how they're spelled.");
                System.out.println("Enter Sneaker Brand: ");
                String brand = sc.nextLine();
                System.out.println("Enter Sneaker Model: ");
                String model = sc.nextLine();
                System.out.println("Enter Sneaker Colorway: ");
                String colorway = sc.nextLine();
                System.out.println("Enter Sneaker Size: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Error: Did not enter a valid number!");
                    System.out.println("Please enter a valid shoe size");

                    sc.next();
                }
                double size = sc.nextDouble();
                while (size < 0) {
                    System.out.println("Error: Shoe size must be a positive number!");
                    System.out.println("Please enter a valid shoe size");

                    size = sc.nextDouble();
                }

                sc.nextLine();
                // Already prints out shoe meant to be searched for
                Collector.searchVault(brand, model, colorway, size);
            } else if (option.equals("4")) {
                clearScreen();
                System.out.println("Enter Sneaker Brand: ");
                String brand = sc.nextLine();
                // Already prints out shoes that are filtered
                Collector.filterByBrand(brand);
            } else if (option.equals("5")) {
                clearScreen();
                System.out.println("Make sure everything is spelled properly!");
                System.out.println("Entries will be put in exactly how they're spelled.");
                System.out.println("Enter Sneaker Brand: ");
                String brand = sc.nextLine();
                System.out.println("Enter Sneaker Model: ");
                String model = sc.nextLine();
                System.out.println("Enter Sneaker Colorway: ");
                String colorway = sc.nextLine();
                System.out.println("Enter Sneaker Size: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Error: Did not enter a valid number!");
                    System.out.println("Please enter a valid shoe size");

                    sc.next();
                }
                double size = sc.nextDouble();
                while (size < 0) {
                    System.out.println("Error: Shoe size must be a positive number!");
                    System.out.println("Please enter a valid shoe size");

                    size = sc.nextDouble();
                }

                sc.nextLine();
                int indexOfShoe = Collector.returnIndex(brand, model, colorway, size);
                Sneaker sneaker = Collector.getSneaker(indexOfShoe);
                sneaker.wearOnce();
            } else if (option.equals("6")) {
                clearScreen();
                // Method already prints out deadstock shoes
                System.out.println("Deadstock Shoes");
                System.out.println("---------------");
                Collector.deadstockOnly();
            } else if (option.equals("7")) {
                clearScreen();
                System.out.println("Total Stock Price: " + Collector.getTotalStockPrice());
            } else if (option.equals("8")) {
                clearScreen();
                System.out.println("Total Resale Price: " + Collector.getTotalResalePrice());
            } else if (option.equals("9")) {
                clearScreen();
                System.out.println("Make sure everything is spelled properly!");
                System.out.println("Entries will be put in exactly how they're spelled.");
                System.out.println("Enter Sneaker Brand: ");
                String brand = sc.nextLine();
                System.out.println("Enter Sneaker Model: ");
                String model = sc.nextLine();
                System.out.println("Enter Sneaker Colorway: ");
                String colorway = sc.nextLine();
                System.out.println("Enter Sneaker Size: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Error: Did not enter a valid number!");
                    System.out.println("Please enter a valid shoe size");

                    sc.next();
                }
                double size = sc.nextDouble();
                while (size < 0) {
                    System.out.println("Error: Shoe size must be a positive number!");
                    System.out.println("Please enter a valid shoe size");

                    size = sc.nextDouble();
                }

                sc.nextLine();

                int index = Collector.returnIndex(brand, model, colorway, size);
                Sneaker currentSneaker = Collector.getSneaker(index);
                System.out.println("Enter New Resale Price: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Error: Did not enter a valid number!");
                    System.out.println("Please enter a valid resale price");

                    sc.next();
                }
                double newResalePrice = sc.nextDouble();
                sc.nextLine();
                currentSneaker.setResalePrice(newResalePrice);
            } else if (option.equals("10")) {
                clearScreen();
                System.out.println("Make sure everything is spelled properly!");
                System.out.println("Entries will be put in exactly how they're spelled.");
                System.out.println("Enter Sneaker Brand: ");
                String brand = sc.nextLine();
                System.out.println("Enter Sneaker Model: ");
                String model = sc.nextLine();
                System.out.println("Enter Sneaker Colorway: ");
                String colorway = sc.nextLine();
                System.out.println("Enter Sneaker Size: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Error: Did not enter a valid number!");
                    System.out.println("Please enter a valid shoe size");

                    sc.next();
                }
                double size = sc.nextDouble();
                while (size < 0) {
                    System.out.println("Error: Shoe size must be a positive number!");
                    System.out.println("Please enter a valid shoe size");

                    size = sc.nextDouble();
                }

                sc.nextLine();
                Collector.removeSneaker(brand, model, colorway, size);
            } else if (option.equals("11")) {
                clearScreen();
                System.out.println("Thanks for using sneaker collector!");
                System.out.println("Quitting program now...");
                System.exit(0);
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
