package N_Queen_problem;


import java.awt.*;
import javax.swing.*;

public class Board extends JFrame {

    // Variables declaration
    private JLabel authorJLabel;
    private JPanel boardJPanel;
    private final JButton [][] buttonsMatrix; //Matrix containing the buttons.
   
 
    public Board() {
        this.buttonsMatrix = new JButton [Population.numberOfQueens][Population.numberOfQueens];    // Board matrix
        initComponents();           // Initialize the swing/awt components
               
        for(int i = 0; i<Population.numberOfQueens; i++){
            for(int j = 0; j<Population.numberOfQueens; j++){
                if((i+j)%2==0){
                    buttonsMatrix[i][j] = new JButton();
                    buttonsMatrix[i][j] .setBackground(new Color(155,155,155)); //gris oscuro
                    buttonsMatrix[i][j] .setMaximumSize(new Dimension(1000, 1000));
                    buttonsMatrix[i][j] .setMinimumSize(new Dimension(72, 72));
                    buttonsMatrix[i][j] .setSize(new Dimension(72, 72));
                    buttonsMatrix[i][j] .setOpaque(false);
                    buttonsMatrix[i][j] .setPreferredSize(new Dimension(72, 72));
                    buttonsMatrix[i][j].setName(i+","+j);
                    boardJPanel.add(buttonsMatrix[i][j]);
            }else{
                    buttonsMatrix[i][j] = new JButton();
                    buttonsMatrix[i][j] .setBackground(new Color(100,100,100)); //gris claro
                    buttonsMatrix[i][j] .setForeground(new Color(102, 51, 0));
                    buttonsMatrix[i][j] .setMaximumSize(new Dimension(1000, 1000));
                    buttonsMatrix[i][j] .setMinimumSize(new Dimension(72, 72));
                    buttonsMatrix[i][j] .setSize(new Dimension(72, 72));
                    buttonsMatrix[i][j] .setOpaque(false);
                    buttonsMatrix[i][j] .setPreferredSize(new Dimension(72, 72));
                    buttonsMatrix[i][j] .setName(i+","+j);
                    boardJPanel.add(buttonsMatrix[i][j]);
                }
            }
        }   // Create the buttons and set the swing/awt properties.

        pack();         //pack components to match sized in the view.
        setLocationRelativeTo(getOwner());
    }

    // Initializes the swing/awt components and properties.
    private void initComponents() {

        authorJLabel = new JLabel();
        boardJPanel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(getPreferredSize());
        setType(Type.NORMAL);

        authorJLabel.setFont(new Font("Magneto", 1, 11)); //
        authorJLabel.setHorizontalAlignment(SwingConstants.LEFT);
        authorJLabel.setText("Designed by Sergio Oyaga (oyaga.sergio@gmail.com).");
        authorJLabel.setVerticalAlignment(SwingConstants.TOP);
        authorJLabel.setFocusTraversalPolicyProvider(true);
        authorJLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        authorJLabel.setMaximumSize(new Dimension(72, 14));
        authorJLabel.setVerticalTextPosition(SwingConstants.TOP);


        boardJPanel.setBackground(new Color(100, 0, 0));
        boardJPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 0, 0)));
        boardJPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boardJPanel.setMinimumSize(new Dimension(585, 585));
        boardJPanel.setPreferredSize(new Dimension(585, 585));
        boardJPanel.setLayout(new GridLayout(Population.numberOfQueens, Population.numberOfQueens));

        getContentPane().add(boardJPanel);
    }

    // Returns the jButton on the i, j position.
    public JButton getJ(int i, int j) {
        return buttonsMatrix[i][j];
    }

}
