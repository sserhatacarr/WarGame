import java.util.Scanner;
public class Game {
    // Game class orchestrates and manages the gameplay, interactions, and progression in the game
    private Scanner input = new Scanner(System.in);


    public void start() { // Starts the war game.
        System.out.println("Welcome to the War Game ! \uD83E\uDD3A");
        System.out.print("Please enter a name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome to this dark and misty island, " + player.getName() + "!");
        System.out.println("Everything that happens here is real! 🏝️");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("############# Locations #############");
            System.out.println();
            System.out.println("1 - Safe House --> It's a safe place, no enemies here! 🏠");
            System.out.println("2 - Tool Store --> You can buy weapons and armor here! ⚔️");
            System.out.println("3 - Cave --> Reward: <Food>, but be careful, a zombie may appear! 🧟‍♂️");
            System.out.println("4 - Forest --> Reward: <Firewood>, but be careful, a vampire may appear! \uD83E\uDDDB\u200D♂");
            System.out.println("5 - River --> Reward: <Water>, but be careful, a bear may appear! 🐻");
            System.out.println("6 - Mine --> Reward : <Random>, but be careful, a snake may appear!");
            System.out.println("0 - Exit --> Exit the game. ❌");

            System.out.print("Please choose the location you want to go: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6 :
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Please enter a valid location!");
            }
            if (location == null) {
                System.out.println("You quickly gave up on this dark and misty island! 😔");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER ! \uFE0F");
                break;
            }
        }

    }
}
