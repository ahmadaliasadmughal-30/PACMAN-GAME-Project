import java.util.Scanner;

public class Gameboard 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Map gm = new Map();
        Score sc = new Score();
        Lives lifes = new Lives();
        Position pacST = new Position(1, 1);
        PacMan pacman = new PacMan(pacST, gm, sc);
        Ghost g1 = new Ghost(new Position(5, 3), gm);
        Ghost g2 = new Ghost(new Position(8, 5), gm);
        Ghost[] ghosts = {g1, g2};
        System.out.println("Welcome to PAC-MAN!");
        System.out.println("Eat all dots (.) to win. Avoid the ghost!");
        System.out.println("Controls: W (Up), S (Down), A (Left), D (Right)");
        System.out.println("Press Q to quit\n");
        boolean playing = true;
        while (playing) 
        {
            Position[] gPosition =
                    {
                            g1.getPosition(), g2.getPosition()
                    };
            gm.printMap(pacman.getPosition(), gPosition);
            System.out.println("Score: " + sc.getPoints() + "   Lives: " + lifes.getLives());
            if (gm.allDotsEaten())
            {
                System.out.println("\nCONGRATULATIONS! YOU WIN! Final Score: " + sc.getPoints());
                break;
            }
            System.out.print("Move (W/A/S/D) or Q to quit: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Q"))
            {
                System.out.println("Game exited. Final Score: " + sc.getPoints());
                break;
            }
            pacman.move(input);
            for (Ghost g : ghosts)
            {
                g.moveRandom();
            }
            boolean collided = false;
            for (Ghost g : ghosts)
            {
                if (pacman.getPosition().equals(g.getPosition()))
                {
                    collided = true;
                    break;
                }
            }
            if (collided)
            {
                System.out.println("GHOST CAUGHT YOU!");
                lifes.loseLife();
                pacman.resetPosition();
                g1.resetPosition();
                g2.resetPosition();
                if (lifes.isGameOver())
                {
                    System.out.println("GAME OVER! You ran out of lifes.");
                    System.out.println("Final Score: " + sc.getPoints());
                    playing = false;
                }
                else
                {
                    System.out.println("You have " + lifes.getLives() + " lifes left.");
                }
            }
        }
        scanner.close();
        System.out.println("Thanks for playing Pac-Man!");
    }
}