import java.util.Scanner;

public class Player {
    // Player class represents the player in the game, holding attributes such as damage, health, money, and inventory.
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {  // Method to choose a character.
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("Characters");
        System.out.println("----------------------------------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("ID : " + gameChar.getId() +
                    "\t Character : " + gameChar.getName() +
                    "\t Damage : " + gameChar.getDamage() +
                    "\t Health : " + gameChar.getHealth() +
                    "\t Money : " + gameChar.getMoney());
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Please select a character: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
    }

    public void initPlayer(GameChar gameChar) { // Method to initialize the player with chosen character attributes.
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {   // Method to print player information.
        System.out.println("Weapon: " + this.getInventory().getWeapon().getName() +
                ", Block: " + this.getInventory().getArmor().getBlock() +
                ", Armor: " + this.getInventory().getArmor().getName() +
                ", Damage: " + this.getTotalDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney());
    }

    public int getTotalDamage() {       // Method to calculate total damage.
        return damage + this.getInventory().getWeapon().getDamage();
    }

    // Getter and setter methods for class attributes.
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health=0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
