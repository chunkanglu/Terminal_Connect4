public class Connect4 {
    
    private String[][] board = new String[6][7];
    private int turn;
    private int[] numPieces = {5,5,5,5,5,5,5}; // Num of pieces you can place in each column
    
    // Constructor
    public Connect4(){
        
        // Create new board with empty slots
        for(int row=0; row<6; row++){
            
            for(int col=0; col<7; col++ ){
                
                board[row][col] = "-";
            }
        }
        turn = 1; // Start game at turn 1
        
    }
    
    public void printBoard(){
        
        System.out.println("  0 1 2 3 4 5 6");
        
        for(int row=0; row<6; row++){
            
            System.out.print(row + " ");
            
            for(int col=0; col<7; col++){
                
                System.out.print(board[row][col] + " ");
            }
           System.out.println();
           
        }
    }
    
    public boolean isValidMove(int col){
        
        // valid if in accepted columns and top layer is not filled
        if(col>=0 && col<7){
            
            if(board[0][col] == "-" && numPieces[col] >= 0){
                return true;
            }
        }
        return false;
        
    }
    
    public void placePiece(int col, String piece){
        
        board[numPieces[col]][col] = piece;
        numPieces[col]--;
        turn++;
        
    }
    
    public boolean checkWin(String piece){
        
        if(checkRow(piece) || checkCol(piece) || checkUpDiag(piece) || checkDownDiag(piece)){
            return true;
        }
        return false;
        
    }
    
    public boolean checkRow(String piece){
        
        for(int row=0; row<6; row++){
            
            for(int col=0; col<4; col++){
                
                if (board[row][col].equals(piece) &&
                    board[row][col+1].equals(piece) &&
                    board[row][col+2].equals(piece) &&
                    board[row][col+3].equals(piece)){
                    return true;    
                }
            }
        }
        return false;
        
    }
    
    public boolean checkCol(String piece){
        
        for(int row=0; row<3; row++){
            
            for(int col=0; col<7; col++){
                
                if (board[row][col].equals(piece) &&
                    board[row+1][col].equals(piece) &&
                    board[row+2][col].equals(piece) &&
                    board[row+3][col].equals(piece)){
                    return true;    
                }
            }
        }
        return false;
        
    }
    
    public boolean checkUpDiag(String piece){
        
        for(int row=3; row<6; row++){
            
            for(int col=0; col<4; col++){
                
                if (board[row][col].equals(piece) &&
                    board[row-1][col+1].equals(piece) &&
                    board[row-2][col+2].equals(piece) &&
                    board[row-3][col+3].equals(piece)){
                    return true;    
                }
            }
        }
        return false;
        
    }
    
    public boolean checkDownDiag(String piece){
        
        for(int row=2; row>=0; row--){
            
            for(int col=0; col<4; col++){
                
                if (board[row][col].equals(piece) &&
                    board[row+1][col+1].equals(piece) &&
                    board[row+2][col+2].equals(piece) &&
                    board[row+3][col+3].equals(piece)){
                    return true;  
                }
            }
        }
        return false;
        
    }
    
    public int getTurn(){
        
        return turn;
        
    }
    
    public int getPlayerTurn(){
        
        if(turn % 2 == 1){
            return 1;
        }
        
        else{
            return 2;
        }
    }
    
}