package drafts;

public class MenuDialog {

    public  void printMainCommands(boolean isSecondPlayer, Board board) {
        System.out.println("Status:\n"
                + "Player 1 checkers remaining - " + board.getBlackCheckersRemaining()
                + "\nPlayer 2 checkers remaining - " + board.getWhiteCheckersRemaining() + "\n");
        if (isSecondPlayer) {
            System.out.println("Player 2 (" + board.getWhiteChecker() + ") takes this turn:");
        } else {
            System.out.println("Player 1 (" + board.getBlackChecker() + ") takes this turn:");
        }
        System.out.println("Available commands:\n"
                + "move <checker position>(row+col) to <position>(row+col) for example 'move 61 to 52' - makes a move with selected checker\n"
                + "end - ends turn\n"
                + "restart - resets the board\n"
                + "ragequit - flip the table and call it a day");
    }

    public  void printWarningMessage() {
        System.out.println("Error, unavailable command");
    }
}
