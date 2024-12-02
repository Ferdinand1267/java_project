public class Logic{
    private Board board;
    // "private Stack<Point> moves;" might not be needed
	private String error;
	private boolean gameOver;
	private boolean redWins;
	private boolean yellowWins;
    
    public Logic(Board board){
        this.board = board;
        // "moves = new Stack<>();" might not be needed
        gameOver = false;
        redWins = false;
        yellowWins = false;
    }
    
    public boolean checkWin(){ //this method uses the methods below to check if there is a winner
        gameOver = false;
        redWins = false;
        yellowWins = false;
        char[][] gameBoard = board.getBoard();
        char turn = board.getTurn();
	//this if statement checks for the winner    
        if (checkRows(gameBoard,turn) == true|| checkColumns(gameBoard,turn) == true || checkDiagonal(gameBoard,turn) == true){
            if(turn == 'r'){
                redWins = true;
                gameOver = true;
                return true;
            }
            else{
                yellowWins = true;
                gameOver = true;
                return true;
            }
        }
        else{
            for (int i = 0;i<gameBoard.length;i++){
                if(gameBoard[i][gameBoard[0].length-1]==' '){
                    break;
                }
                else if(i == gameBoard.length - 1){ //if there are no spaces left then the game is over
                    gameOver = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRows(char[][] gameBoard, char turn){ //this method uses two for loops to count the players' tokens to see if there is 4 in a row
        int count = 0;
        for (int i = 0; i < board.getRow();i++){
            for (int j = 0;j < board.getCol();j++){
                if(gameBoard[i][j] == ' ' || gameBoard[i][j]!= turn){
                    count = 0;
                }
                else { 
                    count += 1;
                    if(count==4){
                        return true;
                    }
                }
                
            }
        }
        return false;   
    }

    public boolean checkColumns(char[][] gameBoard, char turn){ //this method switches the i and j coordinates to check the columns instead of the rows.
        int count = 0;
        for (int i = 0; i < board.getCol();i++){
            for (int j = 0;j < board.getRow();j++){
                if(gameBoard[j][i] == ' ' || gameBoard[j][i]!= turn){
                    count = 0;
                }
                else { 
                    count += 1;
                    if(count==4){
                        return true;
                    }
                }
                
            }
        }
        return false;   
    }

    public boolean checkDiagonal(char[][] gameBoard, char turn){
	//this double for loop checks for diagonal from top left to bottom right
        for (int i = 0; i < 3;i++){
            for (int j = 0; j < 4;j++){
                if (gameBoard[i][j] == turn && gameBoard[i+1][j+1] == turn && gameBoard[i+2][j+2] == turn &&gameBoard[i+3][j+3] == turn){
                    return true;
                }
            }
        }
        //for (int i = board.getRow();i>board.getRow()-3;i--){
          //  for (int j = 0; j<4;j++){
            //    if (gameBoard[i][j] == turn && gameBoard[i-1][j+1] == turn && gameBoard[i-2][j+2] == turn &&gameBoard[i-3][j+3] == turn){
              //      return true;
                //}
           // }
        //}

	//this double for loop checks diagonals for bottom left to top right.
        for (int i = board.getRow()-1; i >= board.getRow()-3;i--){
            for (int j = board.getCol()-1;j>=board.getCol()-4;j--){
                if(gameBoard[i][j] == turn && gameBoard[i-1][j-1] == turn && gameBoard[i-2][j-2] == turn &&gameBoard[i-3][j-3] == turn){
                    return true;
                }   
            }
        }
        return false;
    }
}
