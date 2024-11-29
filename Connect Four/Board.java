public class Board{
    private int row = 6;
    private int col = 7;
    private char[][] board;
    private char turn = 'r';
    
    // Constructor which initializes the board with empty values.
    public Board(){
        board = new char[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                board[i][j] = ' ';
            }
        }
    }

    // getter and setter methods for player's turn
    public char getTurn() {
        return turn;
    }

    public void setTurn(char x) {
        turn = x;
    }

    public void switchPlayer() {
        if(turn == 'r') {
            turn = 'y';
         } else {
            turn = 'r';
         }
    }
    
    //getter method to get board
    public char[][] getBoard() {
        return board;
    }

    
    
}
