import java.util.Scanner;

public class TTTTD {

    public static void main(String[] args) {
        for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                for (int k = 0; k<3; k++)
                {
                    Cube.cube[i][j][k] = ("[]");
                }
            }
        }
        System.out.println("Welcome to THREE DIMENSIONAL TIC TAC TOE");
        System.out.println("Let's begin");
        Cube.prnt(Cube.cube);
        try (Scanner magic = new Scanner(System.in)) {
            int roundCounter = 2;
            boolean gameOver = false;
            int currentPlayer = 1;
            String [] players = new String [2];
            players[0] = "X";
            players[1] = "O";
            while (gameOver == false) {
                if (roundCounter % 2 == 0) {
                    currentPlayer = 1;
                } else {
                    currentPlayer = 2;
                }
                System.out.println("Give x,y,z of point (0-2)");
                System.out.println("X Co-ordinate: ");
                int arrz = magic.nextInt();
                System.out.println("Y Co-ordinate: ");
                int arry = magic.nextInt();
                System.out.println("Z Co-ordinate: ");
                int arrx = magic.nextInt();
                System.out.println();
                if (!Cube.cube[arrx][arry][arrz].equals("[]") ) {
                    System.out.println("Choose an empty point");
                } else {
                    Cube.cube[arrx][arry][arrz] = " " + players[currentPlayer % 2];
                    roundCounter++;
                    gameOver = Cube.checker();

                }
                Cube.prnt(Cube.cube);
            }
            System.out.println("Player " + currentPlayer + " wins!!!!");
        }
    }
}
