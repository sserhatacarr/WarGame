public class Inventory {
    // Represents the inventory of a player, which includes a weapon and armor
    private Weapon weapon;
    private Armor armor;
    private int food;
    private int firewood;
    private int water;


    public Inventory() {
        this.weapon = new Weapon("Punch", -1, 0, 0);
        this.armor = new Armor(-1, "Rag", 0, 0);
        this.food = food;
        this.firewood = firewood;
        this.water = water;

    }
    public boolean hasFood() {
        return food > 0;
    }

    public boolean hasFirewood() {
        return firewood > 0;
    }

    public boolean hasWater() {
        return water > 0;
    }

    public void addFood() {
        food++;
    }

    public void addFirewood() {
        firewood++;
    }

    public void addWater() {
        water++;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFirewood() {
        return firewood;
    }

    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }
}
