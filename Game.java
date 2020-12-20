import java.util.Scanner;

public class Game {

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        boolean playAgain = true;
        
        while (playAgain){
            // New Board
            Connect4 board = new Connect4();
            board.printBoard();
            
            boolean p1Win = false;
            boolean p2Win = false;
            
            while(p1Win == false && p2Win == false && board.getTurn() <= 42){
    
                System.out.println();
                
                // Print player turn
                if(board.getPlayerTurn() == 1){
                    System.out.println("Player 1's Turn (X): ");
                }
                
                else if(board.getPlayerTurn() == 2){
                    System.out.println("Player 2's Turn (O): ");
                }
                
                // Player turn
                boolean validPlacement = false;
                
                while(validPlacement != true){
                    
                    // Takes user placement and converts to int array
                    System.out.println("Enter which column to place the piece: ");
                    int placement = input.nextInt();
                    
                    // Check for valid move and place correct piece
                    if(board.isValidMove(placement)){
                        
                        validPlacement = true;
                        
                        if(board.getPlayerTurn() == 1){
                            
                            board.placePiece(placement, "X");
                            
                            // Check for win
                            if(board.checkWin("X")){
                                
                                p1Win = true;
                                break;
                                
                            }
                        }
                        
                        else if(board.getPlayerTurn() == 2){
                            
                            board.placePiece(placement, "O");
                            
                            // Check for win
                            if(board.checkWin("O")){
                                
                                p2Win = true;
                                break;
                                
                            }
                        }
                        
                    }
                    
                    else{
                        
                        System.out.println("Invalid placement, try again");
                        
                    }
                }
                
                System.out.println();
                
                // Update board
                board.printBoard();
                
            }
            
            // Check for win
            if(p1Win){
                System.out.println("Player 1 Wins");
            }
            
            else if(p2Win){
                System.out.println("Player 2 Wins");
            }
            
            // If no win and board is filled
            if(board.getTurn() > 42){
                
                System.out.println("Tie");
                
            }
            
            System.out.println();
            input.nextLine();
            
            // Repeat program if wanted
            System.out.println("Play again? (y/n) ");
            
            String again = input.nextLine();
            
            if(again.equals("y")){
                playAgain = true;
            }
            
            else if(again.equals("n")){
                System.out.println("Terminating program...");
                playAgain = false;
            }
            
            else{
                System.out.println("Invalid input, stopping...");
                playAgain = false;
            }
        }
    }
    
}