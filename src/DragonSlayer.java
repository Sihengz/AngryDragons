import java.util.Scanner;

public class DragonSlayer {
    private int choice;
    private Player player;
    private Scanner scan = new Scanner(System.in);
    private Room currentRoom;
    private boolean gameOver = false;
    private int roomNumber = 1;
    private String[] RoomNames = {"Entrance", "Cavern", "Lair", "Hatchery", "Treasure Room"};
    public void run() {
        intro();
        while (roomNumber < 6 && !gameOver) {
            menu();
            roomCycle();
            roomNumber += 1;
        }
        if (!gameOver) {
            System.out.println("YOU WIN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

    }

    public void intro() {
        System.out.println("Welcome Dragon Slayer");
        System.out.print("Whats your name?: ");
        player = new Player(scan.nextLine());
        System.out.println("Welcome, " + player.getName());
        System.out.println("Fight through the five rooms of the dragon den to get to the treasure");
    }

    public void roomCycle() {
        currentRoom = new Room(RoomNames[roomNumber - 1]);
        while (!currentRoom.allDragonsSlayed() && !gameOver) {
            Dragon dragon = currentRoom.getDragon();
            gameOver = player.fightDragon(dragon);
        }

        if (gameOver) {
            System.out.println("You Lose!!!!!!!!!!!!!!!!!!");

        } else {
            reward();
        }

    }

    private void menu() {
        System.out.println("---------MENU---------");
        System.out.println("(1) - fight next dragon");
        choice = scan.nextInt();

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
}
