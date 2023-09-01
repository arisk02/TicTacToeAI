import java.util.ArrayList;

public class Board
{

    private String[] board;
    private ArrayList<Integer> emptySpots;

    public Board()
    {
        String[] boardArray = new String[9];
        board = boardArray;
        for (int i = 0; i < 9; i++)
        {
            board[i] = " ";
        }
        this.emptySpots = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++)
        {
            emptySpots.add(i);
        }

    }

    public void play(String letter, int index)
    {
        board[index - 1] = letter;
        emptySpots.clear();
        for (int i = 0; i < 9; i++)
        {
            if (board[i].equals(" "))
            {
                emptySpots.add(i);
            }
        }
    }

    public ArrayList <Integer> getEmptySpots()
    {
        return emptySpots;
    }

    public void printBoard()
    {
        System.out.println("1    |2    |3    \n" 
                            + "  " + board[0] + "  |  " + board[1] + "  |  " + board[2] +"\n"
                            + "     |     |     \n" 
                            + "------------------\n"
                            + "4    |5    |6    \n" 
                            + "  " + board[3] + "  |  " + board[4] + "  |  " + board[5] +"\n"
                            + "     |     |     \n" 
                            + "------------------\n"
                            + "7    |8    |9    \n" 
                            + "  " + board[6] + "  |  " + board[7] + "  |  " + board[8] +"\n"
                            + "     |     |     " );
    }

    public Board copyBoard()
    {
        Board copy = new Board();
        for (int i = 0; i < 9; i++)
        {
            if (board[i].equals("X"))
            {
                copy.play("X", i + 1);
            }
            if (board[i].equals("O"))
            {
                copy.play("O", i + 1);
            }
        }

        return copy;
    }

    public int checkWinner()
    {
        if (board[0].equals(board[1]) && board[0].equals(board[2]))
        {
            if (board[0].equals("X")) { return 1; }
            if (board[0].equals("O")) { return -1; }
        }

        else if (board[3].equals(board[4]) && board[3].equals(board[5]))
        {
            if (board[3].equals("X")) { return 1; }
            if (board[3].equals("O")) { return -1; }
        }

        else if (board[6].equals(board[7]) && board[6].equals(board[8]))
        {
            if (board[6].equals("X")) { return 1; }
            if (board[6].equals("O")) { return -1; }
        }

        else if (board[0].equals(board[3]) && board[0].equals(board[6]))
        {
            if (board[0].equals("X")) { return 1; }
            if (board[0].equals("O")) { return -1; }
        }

        else if (board[1].equals(board[4]) && board[1].equals(board[7]))
        {
            if (board[1].equals("X")) { return 1; }
            if (board[1].equals("O")) { return -1; }
        }

        else if (board[2].equals(board[5]) && board[2].equals(board[8]))
        {
            if (board[2].equals("X")) { return 1; }
            if (board[2].equals("O")) { return -1; }
        }

        else if (board[0].equals(board[4]) && board[0].equals(board[8]))
        {
            if (board[0].equals("X")) { return 1; }
            if (board[0].equals("O")) { return -1; }
        }

        else if (board[2].equals(board[4]) && board[2].equals(board[6]))
        {
            if (board[2].equals("X")) { return 1; }
            if (board[2].equals("O")) { return -1; }
        }

        else if (emptySpots.size() == 0)
        {
            return 0;
        }

        return 2;
        
    }

    public static void main(String[] args) {
        Board board1 = new Board();
        board1.play("X", 2);
        board1.play("X", 3);
        board1.play("X", 4);
        board1.play("X", 5);
        board1.play("X", 7);
        board1.printBoard();
        Board board2 = board1.copyBoard();
        board2.printBoard();
        board2.play("O", 9);
        board2.play("O", 8);
        board2.printBoard();
        board1.printBoard();

    }   
}
