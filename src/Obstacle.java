public class Obstacle {
    // Obstacle class represents an obstacle in the game.

    private int id;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int originalHealth;

    public Obstacle(int id, String name, int damage, int health, int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.originalHealth = health;
        this.award = award;
    }

    // Getters and setters for the class attributes.

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

}
