public class Forest extends BattleLoc {
    // Forest class represents the Forest location in the game. It's a battle location.
    public Forest(Player player) {
        super(player, "Forest 🌲", new Vampire(), "firewood 🔥", 3);
    }
}
