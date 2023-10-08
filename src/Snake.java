
import java.util.Random;

public class Snake extends Obstacle {

    public Snake() {
        super(4, "Snake", new Random().nextInt(3, 7), 12, -1);
    }

    public int calculateDropType() {
        int dropPercentage = getRandomPercentage();

        if (dropPercentage < 15) {
            return 0; // Weapon drop
        } else if (dropPercentage < 30) {
            return 1; // Armor drop
        } else {
            return 2; // Money drop
        }
    }

    public Weapon dropRandomWeapon() {
        int weaponDropPercentage = getRandomPercentage();

        if (weaponDropPercentage < 20) {
            return Weapon.getWeaponObjectByID(3);
        } else if (weaponDropPercentage < 50) {
            return Weapon.getWeaponObjectByID(2);
        } else {
            return Weapon.getWeaponObjectByID(1);
        }
    }

    public Armor dropRandomArmor() {
        int armorDropPercentage = getRandomPercentage();

        if (armorDropPercentage < 20) {
            return Armor.getArmorObjectByID(3);
        } else if (armorDropPercentage < 50) {
            return Armor.getArmorObjectByID(2);
        } else {
            return Armor.getArmorObjectByID(1);
        }
    }

    public int dropRandomMoney() {
        int moneyDropPercentage = getRandomPercentage();

        if (moneyDropPercentage < 20) {
            return 10;
        } else if (moneyDropPercentage < 50) {
            return 5;
        } else {
            return 1;
        }
    }

    private int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


    private int getRandomPercentage() {
        return new Random().nextInt(101);
    }
}
