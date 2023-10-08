public class SafeHouse extends NormalLoc {
    // SafeHouse class represents a safe location in the game.
    public SafeHouse(Player player) {
        super(player, "Safe House 🏠");
    }
    @Override
    public boolean onLocation() {
        System.out.println("You are at a Safe House 🏠");
        System.out.println("Your health has been restored! 🌟");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
