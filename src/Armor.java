public class Armor {
    // Class to represent armor items.

    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors() {   // Method to return an array of predefined armor items.
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1, "Light  🛡️", 1, 15);
        armorList[1] = new Armor(2, "Medium 🛡️🛡️", 3, 25);
        armorList[2] = new Armor(3, "Heavy  🛡️🛡️🛡️", 5, 40);

        return armorList;
    }

    public static Armor getArmorObjectByID(int id) {    // Method to get an Armor object by its unique ID.
        for (Armor armor : Armor.armors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBlock() {
        return block;
    }

    public int getPrice() {
        return price;
    }

}
