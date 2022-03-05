
/*
 * Devon Clayton & Sir Dom Muppet (The Seccond)
 * 08/09/2021
 */

public class Cube {
    public static String[][][] cube = new String[3][3][3];
    // Prints 3d array
    public static void prnt(String[][][] cube) {
        for (byte x = 0; x < 3; x++) {
            for (byte y = 0; y < 3; y++) {
                for (byte z = 0; z < 3; z++) {

                    System.out.print(cube[x][y][z] + " ");

                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public static boolean checker() {

        boolean win = false;
        // So first check all 9 potencials 3x3 board variations

        // 3 X Y checkers with incremental Z

        // 3 X Z chckers with incremental Y

        // 3 Y Z checkers with incremental X

        // if checks XY with incremental Z
        for (int z = 0; z < 3; z++) {
            String[][] translate2d = new String[3][3];

            // X outside
            for (int i = 0; i < 3; i++) {
                // Y inside
                for (int j = 0; j < 3; j++) {
                    translate2d[i][j] = cube[i][j][z];
                }
            }

            if (FaceCheck(translate2d)) {
                win = true;
            }
        }

        // Checks YZ with incremental X
        // werid not right variable names incoming

        for (int z = 0; z < 3; z++) {
            String[][] translate2d = new String[3][3];

            // X outside
            for (int i = 0; i < 3; i++) {
                // Y inside
                for (int j = 0; j < 3; j++) {
                    translate2d[i][j] = cube[z][i][j];
                }
            }

            if (FaceCheck(translate2d)) {
                win = true;
            }
        }

        // checks XZ with incremental Y
        // werid not right variable names incoming

        for (int z = 0; z < 3; z++) {
            String[][] translate2d = new String[3][3];

            // X outside
            for (int i = 0; i < 3; i++) {
                // Y inside
                for (int j = 0; j < 3; j++) {
                    translate2d[i][j] = cube[i][z][j];
                }
            }

            if (FaceCheck(translate2d)) {
                win = true;
            }
        }

        // check all four hard coded diagonals
        if (cube[0][0][0].equals(cube[1][1][1]) && cube[0][0][0].equals(cube[2][2][2]) && !cube[1][1][1].equals("[]")){
            win = true;
        } else if (cube[2][0][0].equals(cube[1][1][1]) && cube[2][0][0].equals(cube[0][2][2]) && !cube[1][1][1].equals("[]")) {
            win = true;
        } else if (cube[0][2][0].equals(cube[1][1][1]) && cube[0][2][0].equals(cube[2][0][2]) && !cube[1][1][1].equals("[]")) {
            win = true;
        } else if (cube[2][2][0].equals(cube[1][1][1]) && cube[2][2][0].equals(cube[0][0][2]) && !cube[1][1][1].equals("[]")) {
            win = true;
        }

        return win;

    }

    public static boolean FaceCheck(String[][] face) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (face[i][0].equals(face[i][1]) && face[i][0].equals(face[i][2]) && !face[i][0].equals("[]")) {
                return true;
            }

            // check cols
            for (int j = 0; j < 3; j++) {
                if (face[0][j].equals(face[1][j]) && face[0][j].equals(face[2][j]) && !face[0][j].equals("[]")) {
                    return true;
                }

            }

            // check diags
            if (face[0][0].equals(face[1][1]) && face[0][0].equals(face[2][2]) && !face[1][1].equals("[]")) {
                return true;
            } else if (face[2][0].equals(face[1][1]) && face[2][0].equals(face[2][0]) && !face[1][1].equals("[]")) {
                return true;
            }

        }
        return false;
    }
}
