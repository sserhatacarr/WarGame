public class ToolStore extends NormalLoc {
    // ToolStore class represents a tool store location in the game.
    public ToolStore(Player player) {
        super(player, "Tool Store 🛒");
    }
    @Override
    public boolean onLocation() {   // Handles the actions and menu display when the player is in the Tool Store.
        System.out.println("----- Welcome to the Tool Store ----- 🛒");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.print("Your choice: ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Invalid choice, please enter again: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you again!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {     // Displays the available weapons in the tool store.
        System.out.println("----- Weapons ----- ⚔️");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() +
                    " <Price: " + w.getPrice() + " , Damage: " + w.getDamage() + ">");
        }
        System.out.println("0 - Exit");
    }

    public void buyWeapon() {   // Handles the logic for purchasing a weapon from the tool store.
        System.out.print("Choose a weapon: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Invalid choice, please enter again: ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjectByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money.");
                } else {
                    System.out.println("You purchased " + selectedWeapon.getName() + " weapon!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining Balance: " + this.getPlayer().getMoney());
                    System.out.println("Previous Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your New Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmor() {  // Displays the available armors in the tool store.
        System.out.println("----- Armors ----- 🛡️");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    " <Price: " + a.getPrice() + " , Block Value: " + a.getBlock() + ">");
        }
        System.out.println("0 - Exit");
    }

    public void buyArmor() {  // Handles the logic for purchasing armor from the tool store.
        System.out.print("Choose an armor: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Invalid choice, please enter again: ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjectByID(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You purchased " + selectedArmor.getName() + " armor!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Remaining Balance: " + this.getPlayer().getMoney());
                }
            }
        }
    }
}
