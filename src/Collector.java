import java.util.ArrayList;

public class Collector {
    private static ArrayList<Sneaker> vault = new ArrayList<>();

    public static void searchVault(String brand, String model, String colorway, double size) {
        boolean sneakerNotFound = true;
        for (int i = 0; i < vault.toArray().length; i++) {
            Sneaker currentSneaker = vault.get(i);
            if (currentSneaker.getBrand().equals(brand) && currentSneaker.getModel().equals(model) && currentSneaker.getColorway().equals(colorway) && currentSneaker.getSize() == size) {
                System.out.println(vault.get(i).toString());
                sneakerNotFound = false;
            }
        }
        if (sneakerNotFound) {
            System.out.println("Could not find shoe! Please make sure everything is properly spelled (case sensitive) and try again.");
        }
    }

    public static double getTotalStockPrice() {
        double totalPrice = 0;
        for (int i = 0; i < vault.toArray().length; i++) {
            Sneaker currentSneaker = vault.get(i);
            double currentSneakerPrice = currentSneaker.getPrice();
            totalPrice = totalPrice + currentSneakerPrice;
        }
        return totalPrice;
    }

    public static int returnIndex(String brand, String model, String colorway, double size) {
        boolean sneakerNotFound = true;
        int index = 0;
        for (int i = 0; i < vault.toArray().length; i++) {
            Sneaker currentSneaker = vault.get(i);
            if (currentSneaker.getBrand().equals(brand) && currentSneaker.getModel().equals(model) && currentSneaker.getColorway().equals(colorway) && currentSneaker.getSize() == size) {
                index = i;
                sneakerNotFound = false;
            }
        }
        if (sneakerNotFound) {
            System.out.println("Could not find shoe! Please make sure everything is properly spelled (case sensitive) and try again.");
        }
        return index;
    }

    public static double getTotalResalePrice() {
        double totalPrice = 0;
        for (int i = 0; i < vault.toArray().length; i++) {
            Sneaker currentSneaker = vault.get(i);
            double currentSneakerPrice = currentSneaker.getResalePrice();
            totalPrice = totalPrice + currentSneakerPrice;
        }
        return totalPrice;
    }

    public static void filterByBrand(String brand) {
        boolean brandFound = false;
        ArrayList<Sneaker> brandFilteredShoes = new ArrayList<>();
        for (int i = 0; i < vault.toArray().length; i++) {
            Sneaker currentSneaker = vault.get(i);
            if (currentSneaker.getBrand().equals(brand)) {
                brandFilteredShoes.add(currentSneaker);
                brandFound = true;
            }
        }

        if (brandFound) {
            for (int i = 0; i < brandFilteredShoes.toArray().length; i++) {
                Sneaker brandFilteredShoe = brandFilteredShoes.get(i);
                System.out.println(brandFilteredShoe.toString());
            }
        } else {
            System.out.println("Could not find brand! Please make sure everything is properly spelled (case sensitive) and try again.");
        }
    }

    public static void addSneaker(Sneaker sneaker) {
        vault.add(sneaker);
    }

    public static Sneaker getSneaker(int index) {
        return Collector.vault.get(index);
    }

    public static int getArrayLength() {
        return vault.toArray().length;
    }

    public static void removeSneaker(String brand, String model, String colorway, double size) {
        Sneaker removeSneaker = null;
        for (int i = 0; i < vault.toArray().length; i++) {
            Sneaker currentSneaker = vault.get(i);
            if (currentSneaker.getBrand().equals(brand) && currentSneaker.getModel().equals(model) && currentSneaker.getColorway().equals(colorway) && currentSneaker.getSize() == size) {
                removeSneaker = currentSneaker;
            }
        }
        if (removeSneaker != null) {
            vault.remove(removeSneaker);
            System.out.println("Removed Sneaker " + removeSneaker.toString());
        } else {
            System.out.println("Could not find sneaker.");
        }
        
    }

    public static void deadstockOnly() {
        ArrayList<Sneaker> deadstockShoes = new ArrayList<>();
        for (int i = 0; i < vault.toArray().length; i++) {
            Sneaker currentSneaker = vault.get(i);
            if (currentSneaker.getIsDeadstock() == true) {
                deadstockShoes.add(currentSneaker);
            }
        }

        for (int i = 0; i < deadstockShoes.toArray().length; i++) {
            Sneaker deadstockShoe = deadstockShoes.get(i);
            System.out.println(deadstockShoe.toString());
        }
    }
}
