import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.border.*;
import javax.swing.event.*;

public class Setting extends JFrame {

    // Variables declaration
    public JPanel frameJPanel;
    private JLabel settingJLabel;
    private JLabel integerValueJLabel;
    private JLabel nQueensJLabel;
    private JLabel populationSizeJLabel;
    private JLabel nGenerationsJLabel;
    private JLabel setting2JLabel;
    private JLabel mutationProb1JLabel;
    private JLabel mutationProb2JLabel;
    private JLabel orderCrossJLabel;
    private JLabel orderCrossDisplayJLabel;
    private JLabel cycleCrossJLabel;
    private JLabel cycleCrossDisplayJLabel;
    private JLabel eliteOrderCrossJLabel;
    private JLabel eliteOrderCrossDisplayJLabel;
    private JLabel eliteCycleCrossJLLabel;
    private JLabel eliteCycleCrossDisplayJLabel;
    private JSlider orderP1JSlider;
    private JSlider orderP2JSlider;
    private JSlider cycleP1JSlider;
    private JSlider cycleP2JSlider;
    private JSlider eliteOrderP1JSlider;
    private JSlider eliteOrderP2JSlider;
    private JSlider eliteCycleP1JSlider;
    private JSlider eliteCycleP2JSlider;
    private JButton okJButton;
    private JSpinner nQueensJSpinner;
    private JSpinner populationSizeJSpinner;
    private JSpinner nGenerationsJSpinner;

    public Setting() {
        initComponents();
    }

    private void initComponents() {
        this.setResizable(false);
        frameJPanel = new JPanel();
        settingJLabel = new JLabel();
        integerValueJLabel = new JLabel();
        nQueensJLabel = new JLabel();
        populationSizeJLabel = new JLabel();
        nGenerationsJLabel = new JLabel();
        setting2JLabel = new JLabel();
        mutationProb1JLabel = new JLabel();
        mutationProb2JLabel = new JLabel();
        orderCrossJLabel = new JLabel();
        orderCrossDisplayJLabel = new JLabel();
        cycleCrossJLabel = new JLabel();
        cycleCrossDisplayJLabel = new JLabel();
        eliteOrderCrossJLabel = new JLabel();
        eliteOrderCrossDisplayJLabel = new JLabel();
        eliteCycleCrossJLLabel = new JLabel();
        eliteCycleCrossDisplayJLabel = new JLabel();
        orderP1JSlider = new JSlider();
        orderP2JSlider = new JSlider();
        cycleP1JSlider = new JSlider();
        cycleP2JSlider = new JSlider();
        eliteOrderP1JSlider = new JSlider();
        eliteOrderP2JSlider = new JSlider();
        eliteCycleP1JSlider = new JSlider();
        eliteCycleP2JSlider = new JSlider();
        okJButton = new JButton();
        nQueensJSpinner = new JSpinner();
        populationSizeJSpinner = new JSpinner();
        nGenerationsJSpinner = new JSpinner();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        //======== frameJPanel ========
        {
            frameJPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(153, 0, 153)));
            frameJPanel.setLayout(new GridBagLayout());
            ((GridBagLayout) frameJPanel.getLayout()).columnWidths = new int[] {0, 3, 0, 3, 0, 3, 0, 15, 0};
            ((GridBagLayout) frameJPanel.getLayout()).rowHeights = new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};

            //---- settingJLabel ----
            settingJLabel.setHorizontalAlignment(SwingConstants.CENTER);
            settingJLabel.setText("Setting");
            settingJLabel.setAlignmentX(0.5F);
            settingJLabel.setBorder(new LineBorder(Color.black, 2));
            settingJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            settingJLabel.setOpaque(true);
            frameJPanel.add(settingJLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- integerValueJLabel ----
            integerValueJLabel.setText("Integer Number");
            integerValueJLabel.setAlignmentX(0.5F);
            integerValueJLabel.setBorder(new LineBorder(Color.black, 2));
            integerValueJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            integerValueJLabel.setHorizontalAlignment(SwingConstants.CENTER);
            integerValueJLabel.setOpaque(true);
            frameJPanel.add(integerValueJLabel, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- nQueensJLabel ----
            nQueensJLabel.setText("N\u00ba Queens");
            nQueensJLabel.setAlignmentX(0.5F);
            nQueensJLabel.setBorder(new LineBorder(Color.black, 2));
            nQueensJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            nQueensJLabel.setOpaque(true);
            frameJPanel.add(nQueensJLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- populationSizeJLabel ----
            populationSizeJLabel.setText("Population Size");
            populationSizeJLabel.setAlignmentX(0.5F);
            populationSizeJLabel.setBorder(new LineBorder(Color.black, 2));
            populationSizeJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            populationSizeJLabel.setOpaque(true);
            frameJPanel.add(populationSizeJLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- nGenerationsJLabel ----
            nGenerationsJLabel.setText("N\u00ba of Generations");
            nGenerationsJLabel.setAlignmentX(0.5F);
            nGenerationsJLabel.setBorder(new LineBorder(Color.black, 2));
            nGenerationsJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            nGenerationsJLabel.setOpaque(true);
            frameJPanel.add(nGenerationsJLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- setting2JLabel ----
            setting2JLabel.setHorizontalAlignment(SwingConstants.CENTER);
            setting2JLabel.setText("Setting");
            setting2JLabel.setAlignmentX(0.5F);
            setting2JLabel.setBorder(new LineBorder(Color.black, 2));
            setting2JLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            setting2JLabel.setOpaque(true);
            frameJPanel.add(setting2JLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- mutationProb1JLabel ----
            mutationProb1JLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mutationProb1JLabel.setText(" 1\u00ba Mutation Prob");
            mutationProb1JLabel.setAlignmentX(0.5F);
            mutationProb1JLabel.setBorder(new LineBorder(Color.black, 2));
            mutationProb1JLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            mutationProb1JLabel.setOpaque(true);
            frameJPanel.add(mutationProb1JLabel, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- mutationProb2JLabel ----
            mutationProb2JLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mutationProb2JLabel.setText(" 2\u00ba Mutation Prob");
            mutationProb2JLabel.setAlignmentX(0.5F);
            mutationProb2JLabel.setBorder(new LineBorder(Color.black, 2));
            mutationProb2JLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            mutationProb2JLabel.setOpaque(true);
            frameJPanel.add(mutationProb2JLabel, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- orderCrossJLabel ----
            orderCrossJLabel.setText("Order Crossover ");
            orderCrossJLabel.setAlignmentX(0.5F);
            orderCrossJLabel.setBorder(new LineBorder(Color.black, 2));
            orderCrossJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            orderCrossJLabel.setOpaque(true);
            frameJPanel.add(orderCrossJLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- orderCrossDisplayJLabel ----
            orderCrossDisplayJLabel.setHorizontalAlignment(SwingConstants.LEFT);
            orderCrossDisplayJLabel.setText("(0.0,0.0)    ");
            orderCrossDisplayJLabel.setToolTipText("");
            orderCrossDisplayJLabel.setAlignmentY(0.0F);
            orderCrossDisplayJLabel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 102, 0)), "Mutation Probabilities", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 8)));
            orderCrossDisplayJLabel.setFocusCycleRoot(true);
            orderCrossDisplayJLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            orderCrossDisplayJLabel.setName("");
            orderCrossDisplayJLabel.setOpaque(true);
            frameJPanel.add(orderCrossDisplayJLabel, new GridBagConstraints(3, 5, 15, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- cycleCrossJLabel ----
            cycleCrossJLabel.setText("Cycle Crossover ");
            cycleCrossJLabel.setAlignmentX(0.5F);
            cycleCrossJLabel.setBorder(new LineBorder(Color.black, 2));
            cycleCrossJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            cycleCrossJLabel.setOpaque(true);
            frameJPanel.add(cycleCrossJLabel, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- cycleCrossDisplayJLabel ----
            cycleCrossDisplayJLabel.setHorizontalAlignment(SwingConstants.LEFT);
            cycleCrossDisplayJLabel.setText("(0.0,0.0)    ");
            cycleCrossDisplayJLabel.setToolTipText("");
            cycleCrossDisplayJLabel.setAlignmentY(0.0F);
            cycleCrossDisplayJLabel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 102, 0)), "Mutation Probabilities", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 8)));
            cycleCrossDisplayJLabel.setFocusCycleRoot(true);
            cycleCrossDisplayJLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            cycleCrossDisplayJLabel.setName("");
            cycleCrossDisplayJLabel.setOpaque(true);
            frameJPanel.add(cycleCrossDisplayJLabel, new GridBagConstraints(3, 6, 15, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- eliteOrderCrossJLabel ----
            eliteOrderCrossJLabel.setText("Elit-Order Crossover ");
            eliteOrderCrossJLabel.setAlignmentX(0.5F);
            eliteOrderCrossJLabel.setBorder(new LineBorder(Color.black, 2));
            eliteOrderCrossJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            eliteOrderCrossJLabel.setOpaque(true);
            frameJPanel.add(eliteOrderCrossJLabel, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- eliteOrderCrossDisplayJLabel ----
            eliteOrderCrossDisplayJLabel.setHorizontalAlignment(SwingConstants.LEFT);
            eliteOrderCrossDisplayJLabel.setText("(0.0,0.0)    ");
            eliteOrderCrossDisplayJLabel.setAlignmentY(0.0F);
            eliteOrderCrossDisplayJLabel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 102, 0)), "Mutation Probabilities", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 8)));
            eliteOrderCrossDisplayJLabel.setFocusCycleRoot(true);
            eliteOrderCrossDisplayJLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            eliteOrderCrossDisplayJLabel.setName("");
            eliteOrderCrossDisplayJLabel.setOpaque(true);
            frameJPanel.add(eliteOrderCrossDisplayJLabel, new GridBagConstraints(3, 7, 15, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- eliteCycleCrossJLLabel ----
            eliteCycleCrossJLLabel.setText("Elit-Cycle Crossover");
            eliteCycleCrossJLLabel.setAlignmentX(0.5F);
            eliteCycleCrossJLLabel.setBorder(new LineBorder(Color.black, 2));
            eliteCycleCrossJLLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            eliteCycleCrossJLLabel.setOpaque(true);
            frameJPanel.add(eliteCycleCrossJLLabel, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- eliteCycleCrossDisplayJLabel ----
            eliteCycleCrossDisplayJLabel.setHorizontalAlignment(SwingConstants.LEFT);
            eliteCycleCrossDisplayJLabel.setText("(0.0,0.0)    ");
            eliteCycleCrossDisplayJLabel.setToolTipText("");
            eliteCycleCrossDisplayJLabel.setAlignmentY(0.0F);
            eliteCycleCrossDisplayJLabel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 102, 0)), "Mutation Probabilities", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 8)));
            eliteCycleCrossDisplayJLabel.setFocusCycleRoot(true);
            eliteCycleCrossDisplayJLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            eliteCycleCrossDisplayJLabel.setName("");
            eliteCycleCrossDisplayJLabel.setOpaque(true);
            frameJPanel.add(eliteCycleCrossDisplayJLabel, new GridBagConstraints(3, 8, 15, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- orderP1JSlider ----
            orderP1JSlider.setMajorTickSpacing(100);
            orderP1JSlider.setMaximum(1000);
            orderP1JSlider.setMinorTickSpacing(1);
            orderP1JSlider.setPaintTicks(true);
            orderP1JSlider.setSnapToTicks(true);
            orderP1JSlider.setValue(0);
            orderP1JSlider.setBorder(new LineBorder(Color.black, 2));
            orderP1JSlider.addChangeListener(e -> orderCrossJSliderStateChanged(e));
            frameJPanel.add(orderP1JSlider, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- orderP2JSlider ----
            orderP2JSlider.setMajorTickSpacing(100);
            orderP2JSlider.setMaximum(1000);
            orderP2JSlider.setMinorTickSpacing(1);
            orderP2JSlider.setPaintTicks(true);
            orderP2JSlider.setSnapToTicks(true);
            orderP2JSlider.setValue(0);
            orderP2JSlider.setBorder(new LineBorder(Color.black, 2));
            orderP2JSlider.addChangeListener(e -> orderCrossJSliderStateChanged(e));
            frameJPanel.add(orderP2JSlider, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- cycleP1JSlider ----
            cycleP1JSlider.setMajorTickSpacing(100);
            cycleP1JSlider.setMaximum(1000);
            cycleP1JSlider.setMinorTickSpacing(1);
            cycleP1JSlider.setPaintTicks(true);
            cycleP1JSlider.setSnapToTicks(true);
            cycleP1JSlider.setValue(0);
            cycleP1JSlider.setBorder(new LineBorder(Color.black, 2));
            cycleP1JSlider.addChangeListener(e -> cycleCrossJSliderStateChanged(e));
            frameJPanel.add(cycleP1JSlider, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- cycleP2JSlider ----
            cycleP2JSlider.setMajorTickSpacing(100);
            cycleP2JSlider.setMaximum(1000);
            cycleP2JSlider.setMinorTickSpacing(1);
            cycleP2JSlider.setPaintTicks(true);
            cycleP2JSlider.setSnapToTicks(true);
            cycleP2JSlider.setValue(0);
            cycleP2JSlider.setBorder(new LineBorder(Color.black, 2));
            cycleP2JSlider.addChangeListener(e -> cycleCrossJSliderStateChanged(e));
            frameJPanel.add(cycleP2JSlider, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- eliteOrderP1JSlider ----
            eliteOrderP1JSlider.setMajorTickSpacing(100);
            eliteOrderP1JSlider.setMaximum(1000);
            eliteOrderP1JSlider.setMinorTickSpacing(1);
            eliteOrderP1JSlider.setPaintTicks(true);
            eliteOrderP1JSlider.setSnapToTicks(true);
            eliteOrderP1JSlider.setValue(0);
            eliteOrderP1JSlider.setBorder(new LineBorder(Color.black, 2));
            eliteOrderP1JSlider.addChangeListener(e -> eliteOrderCrossJSliderStateChanged(e));
            frameJPanel.add(eliteOrderP1JSlider, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- eliteOrderP2JSlider ----
            eliteOrderP2JSlider.setMajorTickSpacing(100);
            eliteOrderP2JSlider.setMaximum(1000);
            eliteOrderP2JSlider.setMinorTickSpacing(1);
            eliteOrderP2JSlider.setPaintTicks(true);
            eliteOrderP2JSlider.setSnapToTicks(true);
            eliteOrderP2JSlider.setValue(0);
            eliteOrderP2JSlider.setBorder(new LineBorder(Color.black, 2));
            eliteOrderP2JSlider.addChangeListener(e -> eliteOrderCrossJSliderStateChanged(e));
            frameJPanel.add(eliteOrderP2JSlider, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- eliteCycleP1JSlider ----
            eliteCycleP1JSlider.setMajorTickSpacing(100);
            eliteCycleP1JSlider.setMaximum(1000);
            eliteCycleP1JSlider.setMinorTickSpacing(1);
            eliteCycleP1JSlider.setPaintTicks(true);
            eliteCycleP1JSlider.setSnapToTicks(true);
            eliteCycleP1JSlider.setValue(0);
            eliteCycleP1JSlider.setBorder(new LineBorder(Color.black, 2));
            eliteCycleP1JSlider.addChangeListener(e -> eliteCycleCrossJSliderStateChanged(e));
            frameJPanel.add(eliteCycleP1JSlider, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- eliteCycleP2JSlider ----
            eliteCycleP2JSlider.setMajorTickSpacing(100);
            eliteCycleP2JSlider.setMaximum(1000);
            eliteCycleP2JSlider.setMinorTickSpacing(1);
            eliteCycleP2JSlider.setPaintTicks(true);
            eliteCycleP2JSlider.setSnapToTicks(true);
            eliteCycleP2JSlider.setValue(0);
            eliteCycleP2JSlider.setBorder(new LineBorder(Color.black, 2));
            eliteCycleP2JSlider.addChangeListener(e -> eliteCycleCrossJSliderStateChanged(e));
            frameJPanel.add(eliteCycleP2JSlider, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- okJButton ----
            okJButton.setText("OK");
            okJButton.setToolTipText("");
            okJButton.setAutoscrolls(true);
            okJButton.setDoubleBuffered(true);
            okJButton.setFocusCycleRoot(true);
            okJButton.setHorizontalTextPosition(SwingConstants.CENTER);
            okJButton.addActionListener(e -> okJButtonActionPerformed(e));
            frameJPanel.add(okJButton, new GridBagConstraints(3, 1, 15, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- nQueensJSpinner ----
            nQueensJSpinner.setModel(new SpinnerNumberModel(8, 1, null, 1));
            frameJPanel.add(nQueensJSpinner, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- populationSizeJSpinner ----
            populationSizeJSpinner.setModel(new SpinnerNumberModel(20, 1, null, 1));
            frameJPanel.add(populationSizeJSpinner, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- nGenerationsJSpinner ----
            nGenerationsJSpinner.setModel(new SpinnerNumberModel(100, 1, null, 1));
            frameJPanel.add(nGenerationsJSpinner, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(frameJPanel, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(frameJPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }


    private void okJButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        try {
            Population.setVars((int) populationSizeJSpinner.getValue(),(int) nQueensJSpinner.getValue());
            NQueenProblem.runGenetic((int) nGenerationsJSpinner.getValue(), orderP1JSlider.getValue()/1000.0,
                    orderP2JSlider.getValue()/1000.0, cycleP1JSlider.getValue()/1000.0,
                    cycleP2JSlider.getValue()/1000.0, eliteOrderP1JSlider.getValue()/1000.0,
                    eliteOrderP2JSlider.getValue()/1000.0, eliteCycleP1JSlider.getValue()/1000.0, eliteCycleP2JSlider.getValue()/1000.0);
        } catch (IOException ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void orderCrossJSliderStateChanged(ChangeEvent evt) {
        orderCrossDisplayJLabel.setText("("+orderP1JSlider.getValue()/1000.0+","+orderP2JSlider.getValue()/1000.0+")");
    }

    private void eliteOrderCrossJSliderStateChanged(ChangeEvent evt) {
    eliteOrderCrossDisplayJLabel.setText("("+eliteOrderP1JSlider.getValue()/1000.0+","+eliteOrderP2JSlider.getValue()/1000.0+")");
    }

    private void cycleCrossJSliderStateChanged(ChangeEvent evt) {
       cycleCrossDisplayJLabel.setText("("+cycleP1JSlider.getValue()/1000.0+","+cycleP2JSlider.getValue()/1000.0+")");
   
    }

    private void eliteCycleCrossJSliderStateChanged(ChangeEvent evt) {//GEN-FIRST:event_jSlider4StateChanged
            eliteCycleCrossDisplayJLabel.setText("("+eliteCycleP1JSlider.getValue()/1000.0+","+eliteCycleP2JSlider.getValue()/1000.0+")");
    }

}
