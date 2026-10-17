import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    static Random random = new Random();

    public static String playRound(String playerMove,
                                   String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock")
                && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper")
                && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors")
                && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String getComputerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[random.nextInt(moves.length)];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rounds = 5;
        int wins = 0, losses = 0, draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter Rock, Paper, or Scissors: ");

            String playerMove = sc.nextLine().trim();

            while (!playerMove.equalsIgnoreCase("Rock")
                    && !playerMove.equalsIgnoreCase("Paper")
                    && !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid move. Try again: ");
                playerMove = sc.nextLine().trim();
            }

            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            String computerMove = getComputerMove();
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Computer chose: " + computerMove);
            System.out.println(result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\n========== FINAL SCOREBOARD ==========");
        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    i + 1, playerMoves[i],
                    computerMoves[i], results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        sc.close();
    }
}
