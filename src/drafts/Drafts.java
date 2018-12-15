package drafts;

import java.util.Scanner;

public class Drafts {

    public static void main(String[] args) throws CloneNotSupportedException {
        boolean isSecondPlayerTurn = false;
        boolean isGameRuning = true;
        Board board = new Board(8, 3, 'O', 'X', ' ', '-');
        GameManager gameObject = GameManager.getInstance();
        gameObject.startGame();
        board.populateBoard();
        Scanner input = new Scanner(System.in);
        String inputText;
        board.drawBoard();
        gameObject.printMainCommands(isSecondPlayerTurn, board);
        while (isGameRuning) {
            inputText = input.nextLine();
            String[] strings = inputText.split(" ");
            switch (strings[0]) {
                case "move":
                    board.movePiece(Integer.parseInt(strings[1].substring(0, 1)) - 1, Integer.parseInt(strings[1].substring(1, 2)) - 1, Integer.parseInt(strings[3].substring(0, 1)) - 1, Integer.parseInt(strings[3].substring(1, 2)) - 1, isSecondPlayerTurn);
                    break;
                case "end":
                    isSecondPlayerTurn = !isSecondPlayerTurn;
                    break;
                case "restart": 
                    board.populateBoard();
                    
                    gameObject.nextGame();
                    break;
                case "ragequit":
                    gameObject.endGame();
                    break;
                default:
                    gameObject.printWarningMessage();
            }
            board.drawBoard();
            gameObject.printMainCommands(isSecondPlayerTurn, board);
            //Win check
            if (board.getBlackCheckersRemaining() == 0) {
                System.out.println("Player 2 has won!");
                isGameRuning = false;
            }
            if (board.getWhiteCheckersRemaining() == 0) {
                System.out.println("Player 1 has won!");
                isGameRuning = false;
            }
        }
    }

}
