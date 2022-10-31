public class Cell {
    
    // Fields for Cell object
    private int content;
    private int arrayPosX;
    private int arrayPosY;
    private double centerX;
    private double centerY;
   
    
    // Conctructor for Cell object
    public Cell(int content, int arrayPosX, int arrayPosY, 
                 double centerX, double centerY) {
        
        this.content = content;
        this.arrayPosX = arrayPosX;
        this.arrayPosY = arrayPosY;
        this.centerX = centerX;
        this.centerY = centerY;
        
    }
    
    
    /**
     * 
     * Input:None
     * Output: integer value of the tile
     * 
     * Description: Getter for the content of the cell
     * 
     */
    public int getContent() {
        return content;
    }
    
    
    /**
     * 
     * Input: None
     * Output: double value for the X center coordinate of the tile
     * 
     * Description: Getter for the X coordinate of the cell
     * 
     * 
     */ 
    public double getCenterX() {
        return centerX;
    }
    
    
    /**
     * Input: None
     * Output: double value for the Y center coordinate of the tile
     * 
     * Description: Getter for the Y coordinate of the cell
     * 
     */
    public double getCenterY() {
        return centerY;
    }
    
    
    /**
     * Input:None
     * Output: double value for the cell position (row) in the 2D board
     * 
     * Description: Getter for the row in which the cell is found in the board 
     * 
     */ 
    public int getArrayPosX() {
        return arrayPosX;
    }
    
    
    /**
     * 
     * Input: None
     * Output: double value for the cell position (col) in the 2D board
     * 
     * Description: Getter for the column in which the cell is found in the board 
     * 
     * 
     */ 
    public int getArrayPosY() {
        return arrayPosY;
    }
    
    
    /**
     * Input: new int value for the tile
     * Output: None
     * 
     * Description: assigns a new value to the cell content
     * 
     */ 
    public void setContent(int newContent) {
        content = newContent;
    }
    
    
    /**
     * Input: new double value for X coordinate of the cell in the image 
     * Output: None
     * 
     * Description: Assigns a new physical X position to the cell in the image
     * 
     * 
     */ 
    public void setCenterX(double newCenterX) {
        centerX = newCenterX;
    }
    
    
    
    /**
     * 
     * Input: new double value for Y coordinate of the cell in the image 
     * Output: None
     * 
     * Description: Assigns a new physical Y position to the cell in the image
     * 
     */ 
    public void setCenterY(double newCenterY) {
        centerY = newCenterY;
    }
    
    
    
    /**
     * Input: new integer value for the row the cell occupies in the board
     * Output: none
     * 
     * Description: assigns the cell to a new row in the board
     * 
     */ 
    public void setArrayPosX(int newArrayPosX) {
        arrayPosX = newArrayPosX;
    }
    
    
    
    /**
     * Input: new integer value for the column the cell occupies in the board
     * Output: none
     * 
     * Description: assigns the cell to a new column in the board
     * 
     */ 
    public void setArrayPosY(int newArrayPosY) {
        arrayPosY = newArrayPosY;
    }
     
    
   
    
    /**
     * Input: None
     * Output: None
     * 
     * Description: makes a cell draw itself on a cartesian plane. Depending on 
     *              value of the tile content, the text color changes.
     * 
     */ 
    public void drawCell() {
        determineColor();
        PennDraw.filledSquare(centerX, centerY, 0.10625);
        if (content > 0 && content < 32) {
            PennDraw.setFontSize(34);
            PennDraw.setPenColor(PennDraw.GRAY);
            PennDraw.text(centerX, centerY, "" + content);
        }
        if (content >= 32) {
            PennDraw.setFontSize(34);
            PennDraw.setPenColor(PennDraw.WHITE);
            PennDraw.text(centerX, centerY, "" + content);
        }
    }
    
    
    /**
     * Input: None
     * Output: None
     * 
     * Description: Determines the color of a tile backgroung according to 
     *              its content. (I spent - unfortunately - a lot of time 
     *              figuring out the pastel tones).
     * 
     * 
     */ 
    public void determineColor() {
        
        if (content == 0) {
            PennDraw.setPenColor(PennDraw.LIGHT_GRAY);
        }
        if (content == 2) {
            PennDraw.setPenColor(255, 229, 204);
        }
        if (content == 4) {
            PennDraw.setPenColor(255, 255, 204);
        }
        if (content == 8) {
            PennDraw.setPenColor(255, 204, 204);
        }
        if (content == 16) {
            PennDraw.setPenColor(229, 255, 204);
        }
        if (content == 32) {
            PennDraw.setPenColor(151, 245, 245);
        }
        if (content == 64) {
            PennDraw.setPenColor(229, 204, 255);
        }
        if (content == 128) {
            PennDraw.setPenColor(204, 204, 255);
        }
        if (content == 256) {
            PennDraw.setPenColor(255, 204, 153);
        }
        if (content == 512) {
            PennDraw.setPenColor(180, 219, 253);
        }
        if (content == 1024) {
            PennDraw.setPenColor(255, 204, 255);
        }
        if (content == 2048) {
            PennDraw.setPenColor(204, 153, 255);
        }
   
    }
    
    
}
