public class Weapon {
    // Weapon class represents a weapon object with attributes like name, damage, and price
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    // Method to get an array of predefined weapons.
    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Pistol 🔫", 1, 2, 15);
        weaponList[1] = new Weapon("Sword 🗡️", 2, 3, 35);
        weaponList[2] = new Weapon("Rifle 🪖", 3, 7, 45);
        return weaponList;
    }

    // Method to get a weapon object by its ID.
    public static Weapon getWeaponObjectByID(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    // Getter and Setter methods for class attributes.
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getPrice() {
        return price;
    }

}
