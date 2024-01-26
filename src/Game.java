import java.util.Scanner;

public class Game {
    private DragonSlayer ds = new DragonSlayer();
    private int bestScore = 0;
    private boolean playAgain = true;
    private Scanner scan = new Scanner(System.in);
    
    public void startGame() {
        ds.run();
        while (playAgain) {
            if (ds.calcScore() > bestScore) {
                bestScore = ds.calcScore();
            }
            menu();
            if (playAgain) {
                ConsoleUtility.clearScreen();
                ds = new DragonSlayer();
                ds.run();
            }
        }
    }
    private void menu() {
        System.out.println("(1) - play again");
        System.out.println("(2) - quit" );
        System.out.println("(3) - see best score");
        int choice = scan.nextInt();
        if (choice == 1) {
            playAgain = true;  
        }  else if (choice == 2) {
            playAgain = false;
            System.out.println("Bye!");
        } else if (choice == 3) {
            System.out.println("Best Score: " + bestScore);
            menu();
        }
    }
}
