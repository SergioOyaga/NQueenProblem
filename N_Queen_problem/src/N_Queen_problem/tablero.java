package N_Queen_problem;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Sergio Oyaga
 */
public class tablero extends javax.swing.JFrame {
    private final javax.swing.JButton [][] jpro;
   
 
    public tablero() {
        this.jpro = new javax.swing.JButton [Population.n][Population.n];
        initComponents();
               
        for(int i=0;i<Population.n;i++){
            for(int j=0;j<Population.n;j++){
            if((i+j)%2==0){
                jpro[i][j] = new javax.swing.JButton();
                jpro[i][j] .setBackground(new java.awt.Color(155,155,155)); //gris oscuro
                jpro[i][j] .setMaximumSize(new java.awt.Dimension(1000, 1000));
                jpro[i][j] .setMinimumSize(new java.awt.Dimension(72, 72));
                jpro[i][j] .setSize(new java.awt.Dimension(72, 72));
                jpro[i][j] .setOpaque(false);
                jpro[i][j] .setPreferredSize(new java.awt.Dimension(72, 72));
                jpro[i][j].setName(i+","+j);
                jPanel1.add(jpro[i][j]);
            }else{
                jpro[i][j] = new javax.swing.JButton();
                jpro[i][j] .setBackground(new java.awt.Color(100,100,100)); //gris claro
                jpro[i][j].setForeground(new java.awt.Color(102, 51, 0));
                jpro[i][j] .setMaximumSize(new java.awt.Dimension(1000, 1000));
                jpro[i][j] .setMinimumSize(new java.awt.Dimension(72, 72));
                jpro[i][j] .setSize(new java.awt.Dimension(72, 72));
                jpro[i][j] .setOpaque(false);
                jpro[i][j] .setPreferredSize(new java.awt.Dimension(72, 72));
                jpro[i][j].setName(i+","+j);
                jPanel1.add(jpro[i][j]);                
            }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(getPreferredSize());
        setType(java.awt.Window.Type.UTILITY);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel7, org.jdesktop.beansbinding.ELProperty.create("${focusable}"), this, org.jdesktop.beansbinding.BeanProperty.create("resizable"));
        bindingGroup.addBinding(binding);

        jPanel6.setRequestFocusEnabled(false);
        jPanel6.setVerifyInputWhenFocusTarget(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Magneto", 1, 11)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("          Designed by Sergio Oyaga.");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel28.setFocusTraversalPolicyProvider(true);
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel28.setMaximumSize(new java.awt.Dimension(888888888, 14));
        jLabel28.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 20));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(100, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setMinimumSize(new java.awt.Dimension(585, 585));
        jPanel1.setPreferredSize(new java.awt.Dimension(585, 585));
        jPanel1.setLayout(new java.awt.GridLayout(Population.n, Population.n));
        jPanel7.add(jPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_START);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private Image getScaledImage(Image srcImg, int h, int w){
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
}
    public void setIcono(javax.swing.JButton j,ImageIcon icon){
        Image im;
        im=getScaledImage(icon.getImage(),j.getHeight(),j.getWidth());
        icon=new ImageIcon(im);
        j.setIcon(icon);
        this.setVisible(true);
    }

    
    // Variables declaration
    
    private javax.swing.JLabel jLabel28;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    public JButton getJ(int i, int j) {
        return jpro[i][j];    
    }
    
    
}
