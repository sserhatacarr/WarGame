import java.util.Random;

/**
 * BattleLoc represents a location in the game where combat with an obstacle can occur.
 * It extends Location and provides specific behavior for battle locations.
 */
public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public boolean onLocation() {       // Handles the logic when the player is at this battle location.
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are currently at: " + this.getName() + "\uD83D\uDC47");
        System.out.println("Be careful! There are " + obsNumber + " " + this.getObstacle().getName() + " here! 🚨");
        System.out.print("Choose to <F>ight or <R>un: ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("F")) {
            if (selectCase.equals("F") && combat(obsNumber)) {
                System.out.println("You have defeated all the enemies at " + this.getName() + "! 🎉");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You have died! ☠️");
            return false;
        }
        if (!this.isRewardsClaimed()) {
            this.claimRewards();
        }
        return true;
    }
    private boolean isRewardsClaimed() {
        switch (this.getName()) {
            case "Cave 🏞️":
                return this.getPlayer().getInventory().hasFood();
            case "Forest 🌲":
                return this.getPlayer().getInventory().hasFirewood();
            case "River 🌊":
                return this.getPlayer().getInventory().hasWater();
            default:
                return false;
        }
    }
    private void claimRewards() {
        switch (this.getName()) {
            case "Cave 🏞️":
                System.out.println("You gained Food 🍞!");
                this.getPlayer().getInventory().addFood();
                break;
            case "Forest 🌲":
                System.out.println("You gained Firewood 🔥!");
                this.getPlayer().getInventory().addFirewood();
                break;
            case "River 🌊":
                System.out.println("You gained Water 💧!");
                this.getPlayer().getInventory().addWater();
                break;
        }
    }



    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);

            boolean playerFirst = determineFirstMove();
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<A>ttack or <R>un: "); // Choose to Attack or Run
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("A")) {
                    if (playerFirst) {
                        playerAttack();
                        if (this.getObstacle().getHealth() > 0) {
                            obstacleAttack();
                        }
                    } else {
                        obstacleAttack();
                        if (this.getPlayer().getHealth() > 0) {
                            playerAttack();
                        }
                    }
                } else if (selectCombat.equals("R")) {
                    return false;
                }
            }

            if (this.getObstacle().getHealth() <= 0) {
                System.out.println("You defeated the enemy! 🎉");
                System.out.println("You earned " + this.getObstacle().getAward() + "\uD83D\uDCB8");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your current money: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }

        return true;
    }

    private void playerAttack() {
        System.out.println("You attacked! ⚔️");
        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
        afterHit();
    }

    private void obstacleAttack() {
        System.out.println("The enemy attacked you! ⚔️");
        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
        if (obstacleDamage < 0) {
            obstacleDamage = 0;
        }
        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
        afterHit();
    }


    private boolean determineFirstMove() {
        Random random = new Random();
        return random.nextDouble() < 0.5;
    }

    public void afterHit() {        // Prints the player's health and the obstacle's health after a combat hit.
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "'s Health: " + this.getObstacle().getHealth());
        System.out.println("----------");
    }

    public void playerStats() {     // Prints the player's statistics, including health, weapon, damage, armor, armor block and money.
        System.out.println("Player Stats");
        System.out.println("--------------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Armor Block: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i) {  // Prints the statistics of the obstacle encountered in battle, including health, damage, and award.
        System.out.println(i + "." + this.getObstacle().getName() + " Stats");
        System.out.println("--------------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println();
    }


    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

}
