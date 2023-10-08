import java.util.Scanner;

public abstract class Location {
    // Location class represents a location in the game.

    private Player player;
    private String name;
    public static Scanner input = new Scanner(System.in);

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    // Abstract method to be overridden by subclasses for specific location behavior.
    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }
}


