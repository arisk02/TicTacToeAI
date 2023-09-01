import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe
{
    public int count;
    private Board board;
    private boolean maxPlayer;
    private boolean minPlayer;

    public TicTacToe()
    {
        count = 0;
        board = new Board();
        maxPlayer = true;
        minPlayer = false;
    }

    public Board getBoard()
    {
        return board;
    }

    public void tttplay(String letter, int index)
    {
        board.play(letter, index);
    }

    public int minimax(Board board1, boolean player, int depth)
    {
        if (board1.checkWinner() == 1) { return 1; }
        if (board1.checkWinner() == -1) { return -1; }
        if (board1.checkWinner() == 0) { return 0; }

        if (board1.checkWinner() == 2)
        {
            int bestScore = 0;
            int index = 5;
            if (player == true)
            {
                bestScore = -2;
                for (int i = 0; i < board1.getEmptySpots().size(); i++)
                {
                    Board boardCopy = board1.copyBoard();
                    boardCopy.play("X", board1.getEmptySpots().get(i) + 1);
                    int score = minimax(boardCopy, false, depth + 1);
                    if (score > bestScore)
                    {
                        bestScore = score;
                        if (depth == 1)
                        {
                            index = board1.getEmptySpots().get(i) + 1;
                        }
                    }
                }
            }

            if (player == false)
            {
                bestScore = 2;
                for (int i = 0; i < board1.getEmptySpots().size(); i++)
                {
                    Board boardCopy = board1.copyBoard();
                    boardCopy.play("O", board1.getEmptySpots().get(i) + 1);
                    int score = minimax(boardCopy, true, depth + 1);
                    if (score < bestScore)
                    {
                        bestScore = score;
                    }
                }
            }

            if (depth == 1)
            {
                board.play("X", index);
            }


            return bestScore;


        }

        return -5;
    }

    public static void main(String[] args)
    {
        Scanner keyboard1 = new Scanner(System.in);
        System.out.print("Enter 1 if you want to go first,  2 if you want to go second: ");
        int firstOrNah = keyboard1.nextInt();
        TicTacToe tt = new TicTacToe();
        if (firstOrNah == 1)
        {
            tt.getBoard().printBoard();
            while (tt.getBoard().checkWinner() == 2)
            {
                Scanner keyboard = new Scanner(System.in);
                System.out.print("\nChoose which cell to put O in: \n");
                int index = keyboard.nextInt();
                tt.tttplay("O", index);
                tt.getBoard().printBoard();
                if (tt.getBoard().checkWinner() == -1)
                {
                    System.out.println("\nYou won!\n");
                    break;
                }
                if (tt.getBoard().checkWinner() == 0)
                {
                    System.out.println("\nYou tied!\n");
                    break;
                }
                System.out.println("\nAI's turn:\n");
                tt.minimax(tt.getBoard(), true, 1);
                tt.getBoard().printBoard();
                if (tt.getBoard().checkWinner() == 1)
                {
                    System.out.println("\nYou lost! :(\n");
                    break;
                }
                if (tt.getBoard().checkWinner() == 0)
                {
                    System.out.println("\nYou tied!\n");
                    break;
                }
            }
        }
        else if (firstOrNah == 2)
        {
            while (tt.getBoard().checkWinner() == 2)
            {
                System.out.println("\nAI's turn:\n");
                tt.minimax(tt.getBoard(), true, 1);
                tt.getBoard().printBoard();
                if (tt.getBoard().checkWinner() == 1)
                {
                    System.out.println("\nYou lost! :(\n");
                    break;
                }
                if (tt.getBoard().checkWinner() == 0)
                {
                    System.out.println("\nYou tied!\n");
                    break;
                }
                Scanner keyboard = new Scanner(System.in);
                System.out.print("\nChoose which cell to put O in: \n");
                int index = keyboard.nextInt();
                tt.tttplay("O", index);
                tt.getBoard().printBoard();
                if (tt.getBoard().checkWinner() == -1)
                {
                    System.out.println("\nYou won!\n");
                    break;
                }
                if (tt.getBoard().checkWinner() == 0)
                {
                    System.out.println("\nYou tied!\n");
                    break;
                }
            }
        }


    }



}