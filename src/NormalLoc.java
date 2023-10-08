public abstract class NormalLoc extends Location {
    // NormalLoc class represents a normal location in the game.

    public NormalLoc(Player player, String name) {
        super(player, name);
    }
    @Override
    public boolean onLocation() {
        return true;
    }
}
