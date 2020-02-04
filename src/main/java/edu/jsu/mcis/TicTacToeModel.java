package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++)
            { 
                board[i][j] = Mark.EMPTY;
            }
        }

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE

        if (isValidSquare(row, col) == false) {
            return false;
        }
        else if  (isSquareMarked(row, col) == true) {
            return false;
        }
        else { 
            if (xTurn == true) {
                board[row][col] = Mark.X;
                xTurn = false;
            }
            else if (xTurn == false) { 
                board[row][col] = Mark.O;
                xTurn = true;
            }
            return true;
        }
        
        
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        return -1 < row && (row < width) && (-1 < col) && col < width;
    }
        
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        return board[row][col] != Mark.EMPTY;
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
          return board[row][col];
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        if (isMarkWin(Mark.X) == true) {
            return Result.X;
        }
        else if (isMarkWin(Mark.O) == true) {
            return Result.O;
        }

        else if (isTie() == true) {
            return Result.TIE;
        }
        else {
            return Result.NONE;
        }
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        for (int r = 0; r < width; r++) { 
            for (int c = 0; c < width; c++) {
                if (board[r][c] != mark) {
                    break;
                }
                else if (board.length - 1 == c) {
                    return true;
                }
            }
        }
        for (int c = 0; c < width; c++) {
            for (int r = 0; r < width; r++) {
                if (board[r][c] != mark) {
                    break;
                }
                else if (board.length - 1 == r) {
                    return true;
                }
            }
        }
        for (int j = 0; j < width; j++) {
            if (board[j][j] != mark) {
                break;
            }
            else if (board.length - 1 == j ) {
                return true;
            }
        }
        for (int j = 0; j < width; j++) {
            if (board[j][width - 1 - j] != mark) {
                break;
            }
            else if (board.length - 1 == j) {
                return true;    
            }
        }
        return false;
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == Mark.EMPTY) {
                    return false;
                }
            }
        }

        return true;
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
            
        // INSERT YOUR CODE HERE
         // String s = "\n\n  012\n\n0 ---\n1 ---\n2 ---\n\n";
        
        for (int i = 0; i < width; i++){

            output.append(i);

        }

        output.append("\n\n");



        for (int i = 0; i < width; i++){

            output.append(i).append(" ");
            
            for (int j = 0; j < width; j++){

                output.append(board[i][j].toString());

            }
            if(i < width-1)
                output.append("\n");

        }



        return output.toString();
        
    }
    
}

