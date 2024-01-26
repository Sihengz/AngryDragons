import java.util.Scanner;
public class DragonSlayer {
    private int choice;
    private Player player;
    private Scanner scan = new Scanner(System.in);
    private Room currentRoom = new Room("Outside", 0);
    private boolean gameOver = false;
    private int roomNumber = 1;
    private String[] RoomNames = {"Entrance", "Cavern", "Lair", "Hatchery", "Treasure Room"};
    private Dragon dragon;

    public void run() {
        intro();
        while (roomNumber < 6 && !gameOver) {
            roomCycle();
            roomNumber += 1;
        }
        if (!gameOver) {
            System.out.println("YOU WIN!");
            System.out.println("Score: " + calcScore());
        }

    }

    public void intro() {
        System.out.println("Welcome Dragon Slayer");
        System.out.print("Whats your name?: ");
        player = new Player(scan.nextLine());
        System.out.println("Welcome, " + player.getName());
        System.out.println("Fight through the five rooms of the dragon den to get to the treasure");
    }

    // Completes one room
    public void roomCycle() {
        currentRoom = new Room(RoomNames[roomNumber - 1]);
        System.out.println("You enter the " + currentRoom.getName());
        System.out.println(currentRoom.getNumDragons() + " dragons spawned");
        try {
            Thread.sleep(2000);  // 2000 milliseconds, or 2 seconds
        } catch (Exception e) {
            System.out.println("error");
        }

        while (!currentRoom.allDragonsSlayed() && !gameOver) {
            
            dragon = currentRoom.getDragon();
            menu();
            gameOver = player.fightDragon(dragon);
            if (!gameOver) {
                reward();
            }
            try {
                Thread.sleep(2000);  // 2000 milliseconds, or 2 seconds
            } catch (Exception e) {
                System.out.println("error");
            }
            ConsoleUtility.clearScreen();
        

        }

        if (gameOver) {
            System.out.println("You Lose!");
            System.out.println("Score: " + calcScore());

        }

    }

    private void reward() {
        double rand = Math.random();
        if(rand < 0.25) {
            System.out.println("The dragon's corpse turns to ash!");
            System.out.println("You get Nothing!");
        } else if(rand < 0.5) {
            System.out.println("The dragon explodes into gold!");
            int gold = (int) (Math.random() * 100) + 1;
            player.gainGold(gold);
            System.out.println("You gained " + gold + " gold");

        } else if (rand > 0.75) {
            System.out.println("The dragon transmogrifies into a upgrade!");
            int attackIncrease = (int) (Math.random() * 10) + 1;
            double dodgeRatingIncrease = 0;
            if (player.getSword().getDodgeRating() < 0.5) {
            dodgeRatingIncrease = ((int) (Math.random() * 5)) / 100.0;
            System.out.println("Your sword's attack increases by " + attackIncrease);
            System.out.println("Your sword's dodge rating increases by " + dodgeRatingIncrease);
            }
            player.getSword().gainAttackPower(attackIncrease);
            player.getSword().gainDodgeRating(dodgeRatingIncrease);

        }  else {
            System.out.println("The dragon's energy heals you!");
            player.setHealth((int) (50 - (player.getHealth() * (1.0/4.0))));
            System.out.println("Your health is now " + player.getHealth());
        }
    }

    public int calcScore() {
        int score = 0;
        if (!gameOver) {
            score += 100;
        }
        score += player.getGold() * 5;
        score += player.getHealth();
        return score;
    }

    //prints menu again if the option is not 1
    private void menu() {
        System.out.println("---------MENU---------");
        System.out.println("(1) - fight next dragon");
        System.out.println("(2) - search room");
        System.out.println("(3) - drink potion");
        System.out.println("(4) - view info");
        choice = scan.nextInt();
        if (choice == 1) {
            ConsoleUtility.clearScreen();
        } else if (choice == 2) {
            player.search(currentRoom);
            menu();
        } else if (choice == 3) {
            player.drinkPotion();
            menu();
        } else if (choice == 4) {
            System.out.println("Player health: " + ConsoleUtility.RED + player.getHealth() + ConsoleUtility.RESET);
            System.out.println("Gold: " + ConsoleUtility.YELLOW +player.getGold() + ConsoleUtility.RESET);
            System.out.println("Has health potion: " + player.isHasHealthPotion());
            System.out.println("Sword attack: " + ConsoleUtility.CYAN + player.getSword().getAttackPower() + ConsoleUtility.RESET);
            System.out.println("Sword dodge rating: " + ConsoleUtility.PURPLE +player.getSword().getDodgeRating() + ConsoleUtility.RESET);
            System.out.println("Dragon level: " + ConsoleUtility.GREEN +dragon.getLevel() + ConsoleUtility.RESET);
            System.out.println();
            menu();
        } else {
            System.out.println("Invalid choice\n");
            menu();
        }
    }
}

