package drafts;

public class Tile implements Cloneable{
    private Piece piece;
    private boolean isBlackTile = false;
    private char defaultIcon;
    private int yCordinate = 0;
    private int xCordinate = 0;

    public Tile(int yCord, int xCord, char defIcon) {
        yCordinate = yCord;
        xCordinate = xCord;
        defaultIcon = defIcon;
    }

    public int getyCordinate() {
        return yCordinate;
    }

    public int getxCordinate() {
        return xCordinate;
    }

    public Piece getPiece() {
        return piece;
    }
    public void changeLocation(int y, int x){
        yCordinate = y;
        xCordinate = x;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isIsBlackTile() {
        return isBlackTile;
    }

    public void setIsBlackTile(boolean isBlackTile) {
        this.isBlackTile = isBlackTile;
    }

    public char getDefaultIcon() {
        return defaultIcon;
    }

    public void setDefaultIcon(char defaultIcon) {
        this.defaultIcon = defaultIcon;
    }
    
    
}
