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
        try (Scanner magic = new Scanner(System.in)) {
            boolean computer = false;
            System.out.println("Welcome to THREE DIMENSIONAL TIC TAC TOE");
            System.out.println("Would you like to play against the AI? (y/n)");
            String ai = magic.next();
            if (ai.equals("y"))
            {
                computer = true;
            }
            System.out.println("Let's begin");
            Cube.prnt(Cube.cube);
            int roundCounter = 0;
            boolean gameOver = false;
            int currentPlayer = 1;
            String [] players = new String [2];
            players[0] = "X";
            players[1] = "O";
            int aiGuessx;
            int aiGuessy;
            int aiGuessz;
            while (gameOver == false) {
                if (roundCounter % 2 == 0) {
                    while (true){
                        currentPlayer = 1;
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
                        } 
                        else {
                            Cube.cube[arrx][arry][arrz] = " " + players[currentPlayer - 1];
                            break;
                        }
                    }
                } 
                else if (computer == true && roundCounter % 2 == 1){
                    currentPlayer = 2;
                    while (true)
                    {
                        aiGuessx = (int)(Math.random() * 3);
                        aiGuessy = (int)(Math.random() * 3);
                        aiGuessz = (int)(Math.random() * 3);
                        if (Cube.cube[aiGuessz][aiGuessy][aiGuessx].equals("[]"))
                        {
                            Cube.cube[aiGuessz][aiGuessy][aiGuessx] = " " + players[currentPlayer - 1];
                            break;
                        }
                    }
                }
                else{
                    while(true)
                    {
                        currentPlayer = 2;
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
                        } 
                        else {
                            Cube.cube[arrx][arry][arrz] = " " + players[currentPlayer - 1];
                            break;
                        }
                    }
                }
                System.out.println("-----------END OF ROUND " + roundCounter + "-----------");
                Cube.prnt(Cube.cube);
                gameOver = Cube.checker();
                roundCounter++;
            }
            System.out.println("Player " + players[currentPlayer - 1] + " wins!!!!");
        }
    }
}
