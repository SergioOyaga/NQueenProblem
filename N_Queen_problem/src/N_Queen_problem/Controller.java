package N_Queen_problem;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Controller {
    public static Pieces[][] boardMatrix;   // Board array matrix
    public Board board;                     // Board object
    private final BufferedImage whiteQueen = ImageIO.read(getClass().getResource("/Images/whiteQueen.png"));    // Queen Image
    
    //Set the queens in the board.
    public Controller(Board board, int [] positions) throws IOException {
        this.board = board;                                                                     // Board Object
        this.boardMatrix = new Pieces[Population.numberOfQueens][Population.numberOfQueens];    // Board Matrix

        // Fill all with empty pieces
        for (int i = 0; i<Population.numberOfQueens; i++){
            for(int j = 0; j<Population.numberOfQueens; j++){
                this.boardMatrix[i][j]= Pieces.pieces.new Empty(i,j);
            }
        }
        // Fill the positions with the queens.
        for(int i = 0; i<Population.numberOfQueens; i++){
           this.boardMatrix[i][positions[i]]= Pieces.pieces.new Queen(i,positions[i]);
       }
        
        // Add a listener to resize the icons in the buttons when the board is resized.
        this.board.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Board board = (Board) e.getComponent();
                for(int i = 0; i<Population.numberOfQueens; i++){
                    for(int j = 0; j<Population.numberOfQueens; j++){
                        if ("Q".equals(boardMatrix[i][j].getType())){
                            board.getJ(i,j).setIcon(new ImageIcon(whiteQueen.getScaledInstance(
                                    board.getJ(i,j).getWidth(), board.getJ(i,j).getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            board.getJ(i,j).setIcon(null);
                        }
                    }
                }
            }
        });

        board.setVisible(true);
      }
}
