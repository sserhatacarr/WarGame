public class GameChar {
   // GameChar class represents a character in the game with specific attributes like damage, health, and money.
    private int id;
    private String name;
    private int damage;
    private int health;
    private int money;


    public GameChar(int id, String name, int damage, int health, int money) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    // Getter and setter methods...

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }
}
