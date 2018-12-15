/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drafts;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Board implements Cloneable{

    private char whiteTileSymbol;
    private char blackTileSymbol;
    private char whiteChecker;
    private char blackChecker;
    private int boardSize;
    private int checkerAmountInRows;
    private int whiteCheckersRemaining;
    private int blackCheckersRemaining;
    private Tile[][] board;

    public Board(int boardSize, int checkerAmountInRows, char whiteChecker, char blackChecker, char whiteTileSymbol, char blackTileSymbol) {
        this.boardSize = boardSize;
        board = new Tile[this.boardSize][this.boardSize];
        this.checkerAmountInRows = checkerAmountInRows;
        this.whiteChecker = whiteChecker;
        this.blackChecker = blackChecker;
        this.whiteTileSymbol = whiteTileSymbol;
        this.blackTileSymbol = blackTileSymbol;
        whiteCheckersRemaining = (boardSize / 2) * checkerAmountInRows;
        blackCheckersRemaining = (boardSize / 2) * checkerAmountInRows;
    }

    public void drawBoard() {
        System.out.println(drawNumbersOnTop(boardSize));
        System.out.println(drawLineForSpacing('-', boardSize * 4));
        for (int y = 0; y < boardSize; y++) {
            System.out.print((y + 1) + " |");
            for (int x = 0; x < boardSize; x++) {
                if (!board[y][x].isIsBlackTile()) {
                    System.out.printf("%2s |", whiteTileSymbol);
                } else {
                    if (board[y][x].getPiece() != null) {
                        if (board[y][x].getPiece().isIsColorWhite()) {
                            System.out.printf("%2c |", whiteChecker);
                        } else {
                            System.out.printf("%2c |", blackChecker);
                        }
                    } else {
                        System.out.printf("%2c |", blackTileSymbol);
                    }
                }
            }
            System.out.println("");
            System.out.println(drawLineForSpacing('-', boardSize * 4));
        }
    }
    public void populateBoard() {
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                board[y][x] = new Tile(y, x, whiteTileSymbol);
                if ((x % 2) == 0 && (y % 2) != 0 || (x % 2) != 0 && (y % 2) == 0) {
                    board[y][x].setIsBlackTile(true);
                    if (y < checkerAmountInRows) {
                        Piece piece = new Piece(false);
                        board[y][x].setPiece(piece);
                    }
                    if (y >= boardSize - checkerAmountInRows) {
                        Piece piece = new Piece(true);
                        board[y][x].setPiece(piece);
                    }
                      if (y >= checkerAmountInRows && boardSize - checkerAmountInRows > y) {
                        board[y][x].setDefaultIcon(blackTileSymbol);
                    }
                }
            }
        }
    }

    public void movePiece(int y, int x, int toY, int toX, boolean isSecondPlayer) {
        if (!board[toY][toX].isIsBlackTile()) {
            System.out.println("Cant move on white tiles");
        } else {
            if (board[toY][toX].getPiece() == null && board[y][x].getPiece() != null) {
                //second player moves white checkers
                if (board[y][x].getPiece().isIsColorWhite() && isSecondPlayer) {
                    //paprastas ejimas
                    if (y - 1 == (toY)) {
                        if (pieceMomeventBasic(y, x, toY, toX)) {
                            return;
                        }
                    }
                    //ejimas su saskes nukirtimu
                    if (((toY) - (y)) * -1 == 2) {
                        //jei yra nuimama saske is kaires
                        if (x - 2 == (toX)) {
                            if (!board[y - 1][x - 1].getPiece().isIsColorWhite()) {
                                pieceMovementAttack(y, x, toY, toX, -1, -1);
                                blackCheckersRemaining--;
                                return;
                            }
                        }
                        //jei yra nuimama saske is desines
                        if (x + 2 == (toX)) {
                            if (!board[y - 1][x + 1].getPiece().isIsColorWhite()) {
                                pieceMovementAttack(y, x, toY, toX, -1, +1);
                                blackCheckersRemaining--;
                                return;
                            }
                        }
                    }
                }
                //first player moves black checkers
                if (!board[y][x].getPiece().isIsColorWhite() && !isSecondPlayer) {
                    if (y + 1 == (toY)) {
                        if (pieceMomeventBasic(y, x, toY, toX)) {
                            return;
                        }
                    }
                    if (((toY) - (y)) == 2) {
                        //jei yra nuimama saske is kaires
                        if (x - 2 == (toX)) {
                            if (board[y + 1][x - 1].getPiece().isIsColorWhite()) {
                                pieceMovementAttack(y, x, toY, toX, +1, -1);
                                whiteCheckersRemaining--;
                                return;
                            }
                        }
                        //jei yra nuimama saske is desines
                        if (x + 2 == (toX)) {
                            if (board[y + 1][x + 1].getPiece().isIsColorWhite()) {
                                pieceMovementAttack(y, x, toY, toX, +1, +1);
                                whiteCheckersRemaining--;
                                return;
                            }
                        }
                    }
                }

            } else {
                System.out.println("Cant move on occupied tile");
            }
        }

    }

    public boolean pieceMomeventBasic(int y, int x, int toY, int toX) {
        if (x + 1 == (toX) || x - 1 == (toX)) {
            board[toY][toX].setPiece(board[y][x].getPiece());
            board[y][x].setPiece(null);
            return true;
        }
        return false;
    }

    public void pieceMovementAttack(int y, int x, int toY, int toX, int directionY, int directionX) {
        board[toY][toX].setPiece(board[y][x].getPiece());
        board[y][x].setPiece(null);
        board[y + (1 * directionY)][x + (1 * directionX)].setPiece(null);
    }

    private String drawLineForSpacing(char symbol, int amount) {
        String returnObject = "  ";
        for (int i = 0; i < amount; i++) {
            returnObject += symbol;
        }
        returnObject += symbol;
        return returnObject;
    }

    private String drawNumbersOnTop(int amount) {
        String returnObject = "   ";
        for (int i = 0; i < amount; i++) {
            returnObject += " " + (i+1) + "  ";
        }
        return returnObject;
    }

    public char getWhiteChecker() {
        return whiteChecker;
    }

    public char getBlackChecker() {
        return blackChecker;
    }

    public int getWhiteCheckersRemaining() {
        return whiteCheckersRemaining;
    }

    public int getBlackCheckersRemaining() {
        return blackCheckersRemaining;
    }

    public char getWhiteTileSymbol() {
        return whiteTileSymbol;
    }

    public void setWhiteTileSymbol(char whiteTileSymbol) {
        this.whiteTileSymbol = whiteTileSymbol;
    }

    public char getBlackTileSymbol() {
        return blackTileSymbol;
    }

    public void setBlackTileSymbol(char blackTileSymbol) {
        this.blackTileSymbol = blackTileSymbol;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getCheckerAmountInRows() {
        return checkerAmountInRows;
    }

    public void setCheckerAmountInRows(int checkerAmountInRows) {
        this.checkerAmountInRows = checkerAmountInRows;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }

}
