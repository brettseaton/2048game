public class Game2048 {
    
    
    public static void main(String[] args) {
        
        // Initialize game: create board, add two random tiles, draw everything
        Board myBoard = new Board();
        myBoard.generateTile();
        myBoard.generateTile();
        myBoard.drawBoard();
        
        // create variable to keep track of number of moves
        int moveCounter = 0;
       
        // as long as the game is not over, turn pressed key into move
        while (myBoard.checkIfWon() == false && myBoard.checkIfLost() == false) {
                
           if (PennDraw.hasNextKeyTyped() == true) {  
               char key = PennDraw.nextKeyTyped();
               
               if (key == 'w') {
                    myBoard.moveUp();
                    myBoard.drawBoard();
                    moveCounter++;
                    
                }
           
                else if (key == 's') {
                    myBoard.moveDown();
                    myBoard.drawBoard();
                    moveCounter++;
                   
                }
           
                else if (key == 'a') {
                    myBoard.moveLeft();
                    myBoard.drawBoard();
                    moveCounter++;
                    
                }
          
                else if (key == 'd') {
                    myBoard.moveRight();
                    myBoard.drawBoard();
                    moveCounter++;
                   
                }
            }   
        }
        
        
        // if 2048 is reached, end game and print win message + num of moves 
        
        if (myBoard.checkIfWon() == true) {
            PennDraw.clear();
            PennDraw.setPenColor(PennDraw.GRAY);
            PennDraw.text(0.5, 0.5, "You win with " + moveCounter + " moves!");
        } 

        
        // if board is full with no moves left print lose message + num of moves
        if (myBoard.checkIfLost() == true) {
            PennDraw.clear();
            PennDraw.setPenColor(PennDraw.GRAY);
            PennDraw.text(0.5, 0.5, "You lost with " + moveCounter + " moves.");
       }
    
    }
    
}
