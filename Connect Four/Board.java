public class Board{
    private char[][] board;
    private int row = 6;
    private int col = 7;
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
    //switch player method
    public void switchPlayer() {
        if (turn == 'r') {
        turn = 'y'; 
        } else {
        turn = 'r'; 
        }
    }
    //getter methods for row and col
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
    
    //getter method to get board
    public char[][] getBoard() {
        return board;
    }
    // this method allows users to drop their token
    public boolean drop(int column){
        if(column<0||column>=col){ 
            return false;
        }
        for (int i = row - 1; i >= 0; i--) { 
            if (board[i][column] == ' ') { //if the slot is empty, it replaces the empty spot and returns true
                board[i][column] = turn; 
                return true; 
            }
        }
    
        return false; 
    }
    
}
