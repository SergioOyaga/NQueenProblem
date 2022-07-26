package N_Queen_problem;

/**
 * Parent class containing the piece types.
 */
public class Pieces {
    public static Pieces pieces =new Pieces();  // object containing the piece types.

    // Method to know what type is each piece.
    public String getType(){
        return this.getType();
    }

    /**
     * Children class for an empty board piece, This represents a place in the board without pieces.
     */
    public class Empty extends Pieces {
        private final String type ="";
        private int[] position =new int [2];
        
        public Empty(int i, int j) {
            position[0]=i;
            position[1]=j;
        }
        @Override
        public String getType(){
            return type;
        }

    }

    /**
     * Children class for a Queen board piece, This represents a place in the board with a Queen.
     */
    public class Queen extends Pieces {
        private final String type ="Q";
        private int[] position =new int [2];

        public Queen(int i, int j) {
            position[0]=i;
            position[1]=j;
        }
        @Override
            public String getType(){
        return type;
        }

    }

}
