import java.util.Scanner;

public class DragonSlayer {
    private Player player;
    private Scanner scan = new Scanner(System.in);
    private Room currentRoom;
    private boolean gameOver = false;
    private int roomNumber = 1;
    public void run() {
        intro();
        while (roomNumber < 6 && !gameOver) {
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
        currentRoom = new Room();
        while (!currentRoom.allDragonsSlayed() && !gameOver) {
            Dragon dragon = currentRoom.getDragon();
            gameOver = player.fightDragon(dragon);
        }

        if (gameOver) {
            System.out.println("You Lose!!!!!!!!!!!!!!!!!!");
        }

    }

    public String menu() {
        String str = "";
        return str;
    }
}
