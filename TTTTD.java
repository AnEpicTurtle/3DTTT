import java.util.Scanner;

public class TTTTD {

    public static void main(String[] args) {

        try (Scanner magic = new Scanner(System.in)) {
            int roundCounter = 2;
            boolean gameOver = false;
            int currentPlayer = 1;
            while (gameOver == false) {
                if (roundCounter % 2 == 0) {
                    currentPlayer = 1;
                } else {
                    currentPlayer = 2;
                }
                System.out.println("Give z,y,x of point (0-2)");
                System.out.println("Z Co-ordinate: ");
                int arrx = magic.nextInt();
                System.out.println("Y Co-ordinate: ");
                int arry = magic.nextInt();
                System.out.println("X Co-ordinate: ");
                int arrz = magic.nextInt();
                System.out.println();
                if (Cube.cube[arrx][arry][arrz] > 0) {
                    System.out.println("Choose an empty point");
                } else {
                    Cube.cube[arrx][arry][arrz] = currentPlayer;
                    roundCounter++;
                    gameOver = Cube.checker();

                }
                Cube.prnt(Cube.cube);
            }
            System.out.println("Player " + currentPlayer + " wins!!!!");
        }
    }
}
