public class Board {
    
    // fields 
    Cell[][] cellArray = new Cell[4][4];
    
    // constructor 
    public Board() {
        
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                double newCenterX = (2 * j + 1) * 0.10625 + (j + 1) * 0.03;
                double newCenterY = 1 - ((2 * i + 1) * 0.10625 + (i + 1) * 0.03); 
                cellArray[i][j] = new Cell(0, j, i, newCenterX, newCenterY);
            }
        }      
    }
    
    
    /**
     * 
     * Input:None
     * Output:None
     * 
     * Description: Draws the board by having each function draw itself 
     * 
     */
    public void drawBoard() {
        
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                cellArray[i][j].drawCell();
            }
        }
    }
    
    
    
    
   /**
     * 
     * Input: None
     * Output: None
     * 
     * Description: Calls helper move funtion in order to handle the move and 
     *              determines when a new tile should be added to the board
     * 
     */ 
    public void moveUp() {
        
        Cell[][] temp = new Cell[4][4];
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                temp[i][j] = cellArray[i][j];
            }
        }
        
        boolean createTile = false;
        
        moveUpHelper();
        
        for (int i = 0; i < cellArray.length; i++) {
                for (int j = 0; j < cellArray[i].length; j++) {
                    if (temp[i][j] == cellArray[i][j]) {
                        createTile = true;
                    }
                }
            }
        
        if (createTile == true) {
            generateTile();
            return;
        }
    }


    
    
    /**
     * Input: None
     * Output: None
     * 
     * Description: Iterates through the board and moves tiles up while its possible.
     *              It also adds tiles that have the same value. Calls itself
     *              recursively in order to make sure tiles move all the way.
     * 
     * 
     */ 
    public void moveUpHelper() {
        
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                
                
                if (i < 3 && cellArray[i][j].getContent() == 0) {
                    cellArray[i][j].setContent(cellArray[i + 1][j].getContent());
                    cellArray[i + 1][j].setContent(0);
                    
                }
                
                if (i < 3 && cellArray[i][j].getContent() == cellArray[i + 1]
                                                            [j].getContent()) {
                    cellArray[i][j].setContent(cellArray[i][j].getContent() * 2);
                    cellArray[i + 1][j].setContent(0);
                     
                }
                
                
                if (i > 0) {
                    if ((cellArray[i - 1][j].getContent() == 0 || cellArray[i - 1]
                         [j].getContent() == cellArray[i][j].getContent()) &&
                                            cellArray[i][j].getContent() != 0) {  
                        moveUpHelper();
                        
                    }
                }
            }
        }
    }

    
    
    
    
    /**
     * Input: None
     * Output: None
     * 
     * Description: Calls helper move funtion in order to handle the move and 
     *              determines when a new tile should be added to the board
     * 
     * 
     */
    public void moveDown() {
       
        Cell[][] temp = new Cell[4][4];
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                temp[i][j] = cellArray[i][j];
            }
        }
        
        boolean createTile = false;
        
        moveDownHelper();
        
        for (int i = 0; i < cellArray.length; i++) {
                for (int j = 0; j < cellArray[i].length; j++) {
                    if (temp[i][j] == cellArray[i][j]) {
                        createTile = true;
                    }
                }
            }
        
        if (createTile == true) {
            generateTile();
            return;
        }
        
    }
    
    
    /**
     * Input: none
     * Output: none
     * 
     * Description: Iterates through the board and moves tiles down while possible.
     *              It also adds tiles that have the same value. Calls itself
     *              recursively in order to make sure tiles move all the way.
     * 
     * 
     */ 
    public void moveDownHelper() {
       
        for (int i = cellArray.length - 1; i >= 0; i--) {
            for (int j = 0; j < cellArray[i].length; j++) {
                
                if (i > 0 && cellArray[i][j].getContent() == 0) {
                    cellArray[i][j].setContent(cellArray[i - 1][j].getContent());
                    cellArray[i - 1][j].setContent(0);
              
                }
                
                if (i > 0 && cellArray[i][j].getContent() == cellArray[i - 1]
                                                            [j].getContent()) {
                    cellArray[i][j].setContent(cellArray[i][j].getContent() * 2);
                    cellArray[i - 1][j].setContent(0);
                    
                }
                
                
                if (i < 3) {
                    if ((cellArray[i + 1][j].getContent() == 0 || cellArray[i + 1]
                         [j].getContent() == cellArray[i][j].getContent()) &&
                                            cellArray[i][j].getContent() != 0) { 
                        
                        moveDownHelper();
                        
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Input: None
     * Output: None
     * 
     * Description: Calls helper move funtion in order to handle the move and 
     *              determines when a new tile should be added to the board
     * 
     * 
     */
    public void moveLeft() {
        
        Cell[][] temp = new Cell[4][4];
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                temp[i][j] = cellArray[i][j];
            }
        }
        
        boolean createTile = false;
        
        moveLeftHelper();
        
        for (int i = 0; i < cellArray.length; i++) {
                for (int j = 0; j < cellArray[i].length; j++) {
                    if (temp[i][j] == cellArray[i][j]) {
                        createTile = true;
                    }
                }
            }
        
        if (createTile == true) {
            generateTile();
            return;
        }
    }
    
    
    /**
     * Input: none
     * Output: none
     * 
     * Description: Iterates through the board and moves tiles left while possible.
     *              It also adds tiles that have the same value. Calls itself
     *              recursively in order to make sure tiles move all the way.
     * 
     * 
     */
    public void moveLeftHelper() {
        
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                
                if (j < 3 && cellArray[i][j].getContent() == 0) {
                    cellArray[i][j].setContent(cellArray[i][j + 1].getContent());
                    cellArray[i][j + 1].setContent(0);
                    
                }
                
                if (j < 3 && cellArray[i][j].getContent() == cellArray[i]
                                                    [j + 1].getContent()) {
                    cellArray[i][j].setContent(cellArray[i][j].getContent() * 2);
                    cellArray[i][j + 1].setContent(0);
                    
                }
                
                if (j > 0) {
                    if ((cellArray[i][j - 1].getContent() == 0 || cellArray[i]
                         [j - 1].getContent() == cellArray[i][j].getContent()) &&
                                         cellArray[i][j].getContent() != 0) {
                        
                        moveLeftHelper();
                        
                        
                    }
                }
            }
        }
    }
    
    
   
    
    
    /**
     * Input: None
     * Output: None
     * 
     * Description: Calls helper move funtion in order to handle the move and 
     *              determines when a new tile should be added to the board
     * 
     * 
     */
    public void moveRight() {
        
        Cell[][] temp = new Cell[4][4];
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                temp[i][j] = cellArray[i][j];
            }
        }
        
        boolean createTile = false;
        
        moveRightHelper();
        
        for (int i = 0; i < cellArray.length; i++) {
                for (int j = 0; j < cellArray[i].length; j++) {
                    if (temp[i][j] == cellArray[i][j]) {
                        createTile = true;
                    }
                }
            }
        
        if (createTile == true) {
            generateTile();
            return;
        }
      
    }

    
    
    /**
     * Input: None
     * Output: None
     * 
     * Description: Iterates through the board and moves tiles right while possible.
     *              It also adds tiles that have the same value. Calls itself
     *              recursively in order to make sure tiles move all the way.
     * 
     * 
     */ 
    public void moveRightHelper() {
        
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = cellArray[i].length - 1; j >= 0; j--) {
                
                if (j > 0 && cellArray[i][j].getContent() == 0) {
                    cellArray[i][j].setContent(cellArray[i][j - 1].getContent());
                    cellArray[i][j - 1].setContent(0);  
                    
                }
                
                if (j > 0 && cellArray[i][j].getContent() == cellArray[i]
                                                    [j - 1].getContent()) {
                    cellArray[i][j].setContent(cellArray[i][j].getContent() * 2);
                    cellArray[i][j - 1].setContent(0);
                    
                }
                
                if (j < 3) {
                    if ((cellArray[i][j + 1].getContent() == 0 || cellArray[i]
                         [j + 1].getContent() == cellArray[i][j].getContent()) &&
                                           cellArray[i][j].getContent() != 0) { 
                       
                        moveRightHelper();
                        
                    }
                }
            }
        }
    }
    
    
    
    
    
    /**
     * 
     * Input: None
     * Output: None
     * 
     * Description: Generates a new tile with a 90% chance of being a 2 and 10%
     *              chance of being a 4 (just like the original game) in a random
     *              empty tile in the board.
     * 
     * 
     */ 
    public void generateTile() {
        
        // determine row and col coordinates
        int randomCoorRow = (int) (Math.random() * 4);
        int randomCoorCol = (int) (Math.random() * 4);
        
        // determine number in tile
        int randomValue;
        if (Math.random() < 0.9) {
            randomValue = 2;
        } else {
            randomValue = 4;
        }
        
        // 
        if (cellArray[randomCoorRow][randomCoorCol].getContent() == 0) {
            cellArray[randomCoorRow][randomCoorCol].setContent(randomValue);
        } else {
            generateTile();
        }
        
        
    }
    
    
    
    /**
     * input: None
     * output: Boolean value to tell if user won
     * 
     * Description: Determines if user won by checking if there are any tiles with
     *              a value of 2048.
     * 
     */ 
    public boolean checkIfWon() {
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                if (cellArray[i][j].getContent() == 2048) {
                    return true; 
                }
            }
        }
        return false;
    }
    
    
    
    /**
     * input: None
     * output: Boolean value to tell if user lost
     * 
     * Description: Determines if user lost by checking if the whole board is full
     *              with no more moves left.
     * 
     */
    public boolean checkIfLost() {
        
        
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray[i].length; j++) {
                
                if (cellArray[i][j].getContent() == 0) {
                    return false;
                }
                
                if (i < cellArray.length - 1) {
                    if (cellArray[i][j].getContent() == cellArray[i + 1]
                                                       [j].getContent()) {
                        return false;
                    }
                }
                
                if (j < (cellArray[i].length - 1)) {
                    if (cellArray[i][j].getContent() == cellArray[i]
                                               [j + 1].getContent()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
     
    
}
