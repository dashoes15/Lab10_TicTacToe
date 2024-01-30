import java.util.Objects;
import java.util.Scanner;
public class TicTacToe {


    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String [][] board = new String[ROW][COL];


    //METHODS


    //sets all the board elements to "-"
    private static void clearBoard(){
        for (int r = 0; r<board.length; r++) {
            for (int c = 0; c<board[0].length; c++) {
                board[r][c] = "-";
            }
        }
    }


    //shows the Tic Tac Toe game board in its current state
    private static void displayBoard(){
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + "  ");
            }
            System.out.println();
        }
    }


    //returns true if there is a space at the given proposed move coordinates which means it is a legal move
    private static boolean isValidMove(int row, int col){
        boolean valid = false;
        if (Objects.equals(board[row][col], "-")) {
            valid = true;
        }
        return valid;
    }


    //checks to see if there is a win state on the current board for the specified player
    private static boolean isWin(String player){
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }


    //checks for a col win for specified player
    private static boolean isColWin(String player){
        boolean colWin = false;
        int counter;
        for (int j = 0; j < board[0].length; j++) {
            counter = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[j][i].equals(player)) {
                    counter++;
                }
                if (counter == 3) {
                    colWin = true;
                    break;
                }
            }
        }
        return colWin;
    }


    //checks for a row win for the specified player
    private static boolean isRowWin(String player){
        boolean rowWin = false;
        int counter;
        for (int j = 0; j < board[0].length; j++) {
            counter = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j].equals(player)) {
                    counter++;
                }
                if (counter == 3) {
                    rowWin = true;
                    break;
                }
            }
        }
        return rowWin;
    }


    //checks for a diagonal win for the specified player
    private static boolean isDiagonalWin(String player){
        boolean diagWin = false;
        if (board[0][0].equals(player) && board[2][2].equals(player) && board[1][1].equals(player)) {
            diagWin = true;
        } else if (board[2][0].equals(player) && board[0][2].equals(player) && board[1][1].equals(player)) {
            diagWin = true;
        }
        return diagWin;
    }


    //checks for a tie condition: all spaces on the board are filled and no win has occurred
    private static boolean isTie(){
        boolean tie = false;
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("-")) {
                    counter++;
                    break;
                }
            }
        }
        if (counter == 0) {
            tie = true;
        }
        return tie;
    }






    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        String playerOne = "";
        String playerTwo = "";
        boolean game = false;
        boolean end;
        boolean round;
        boolean donePlayerOne;
        boolean donePlayerTwo;
        int playerOneMoveRow = -1;
        int playerOneMoveCol = -1;
        int playerTwoMoveRow = -1;
        int playerTwoMoveCol = -1;
        String temp;



        while (!game) {
            end = false;
            round = false;
            while (!end) {
                temp = InputHelper.getNonZeroString(scan, "Player 1, choose X or O");
                if (temp.equalsIgnoreCase("X")) {
                    playerOne = "X";
                    playerTwo = "O";
                    end = true;
                } else if (temp.equalsIgnoreCase("O")) {
                    playerOne = "O";
                    playerTwo = "X";
                    end = true;
                } else {
                    System.out.println("Invalid");
                }
            }

            clearBoard();
            displayBoard();

            while (!round) {
                donePlayerOne = false;
                donePlayerTwo = false;
                while (!donePlayerOne){
                    playerOneMoveRow = InputHelper.getRangedInt(scan, "Player One, pick a row for your move", 1, 3);
                    playerOneMoveCol = InputHelper.getRangedInt(scan, "Player One, pick a column for your move", 1, 3);
                    if (isValidMove(playerOneMoveRow - 1, playerOneMoveCol - 1)) {
                        donePlayerOne = true;
                    } else {
                        System.out.println("That move is already taken");
                    }
                }
                board[playerOneMoveRow -1][playerOneMoveCol -1] = playerOne;
                displayBoard();
                if (isWin(playerOne) || isTie()) {
                    round = true;
                    break;
                }
                while (!donePlayerTwo){
                    playerTwoMoveRow = InputHelper.getRangedInt(scan, "Player Two, pick a row for your move", 1, 3);
                    playerTwoMoveCol = InputHelper.getRangedInt(scan, "Player Two, pick a column for your move", 1, 3);
                    if (isValidMove(playerTwoMoveRow - 1, playerTwoMoveCol - 1)) {
                        donePlayerTwo = true;
                    } else {
                        System.out.println("That move is already taken");
                    }
                }
                board[playerTwoMoveRow -1][playerTwoMoveCol -1] = playerTwo;
                displayBoard();
                if (isWin(playerTwo) || isTie()) {
                    round = true;
                    break;
                }
            }


            if (isWin(playerOne)) {
                System.out.println("Player One Wins!");
            } else if (isWin(playerTwo)) {
                System.out.println("Player Two Wins!");
            } else if (isTie()) {
                System.out.println("You Tied!");
            }


            end = InputHelper.getYNConfirm(scan, "Would you like to play again?(Y/N)");
            if (end) {
                break;
            }
        }
    }




}
