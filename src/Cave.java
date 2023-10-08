import java.util.Random;

public class Cave extends BattleLoc {
    // Cave class represents a cave location in the game where a battle can occur.
    public Cave(Player player) {
        super(player, "Cave 🏞️", new Zombie(), "Food 🍞", 3);
    }
}
