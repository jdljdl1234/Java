import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * The simple NIM game GUI.
 * There are 21 sticks in the pile. On each move, each user take turns picking
 * up 1, 2, or 3 sticks until there are no more sticks left.
 * The one who picks up the last stick loses.
 * @author Namita Singla, Robert Cohen
 */
public class SimpleNIMGUI
    extends JFrame {

  private SimpleNIM game;
  private int sticksPicked;
  private int totalSticksPicked;
  private JCheckBox sticks[] = new JCheckBox[21];
  private ButtonGroup buttonGroup = new ButtonGroup();
  private JRadioButton oneStickButton = new JRadioButton();
  private JRadioButton twoStickButton = new JRadioButton();
  private JRadioButton threeStickButton = new JRadioButton();
  protected JLabel messageBar =
      new JLabel("Press Start button to start playing");

  /**
   * The constructor
   */
  public SimpleNIMGUI() {
    game = new SimpleNIM(this);
    setTitle("Simple NIM Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new BorderLayout());

    //Create panel for game choice
    JPanel gameChoicePanel = createGameChoicePanel();
    getContentPane().add(gameChoicePanel, BorderLayout.NORTH);

    // Create panel for choices for sticks to be picked up
    JPanel howManySticksPanel = createHowManySticksPanel();

    //Create panel for buttons
    JPanel buttonPanel = createButtonPanel();

    //Create panel for sticks
    JPanel sticksPanel = createSticksPanel();

    //Create a vertical box and add buttons panel, no of sticks panel and sticks panel
    Box buttonAndGameBox = Box.createVerticalBox();
    buttonAndGameBox.add(howManySticksPanel);
    buttonAndGameBox.add(buttonPanel);
    buttonAndGameBox.add(sticksPanel);
    getContentPane().add(buttonAndGameBox, BorderLayout.CENTER);

    messageBar.setForeground(Color.RED);
    getContentPane().add(messageBar, BorderLayout.SOUTH);
    setResizable(false);
    display(); //Display frame
  }

  /**
   * Creates the Sticks Panel
   * @return panel
   */
  private JPanel createSticksPanel() {
    JPanel sticksPanel = new JPanel();
    sticksPanel.setLayout(new GridLayout(3, 7));
    for (int i = 0; i < 21; i++) {
      sticks[i] = new JCheckBox();
      sticks[i].setEnabled(false);
      sticksPanel.add(sticks[i]);
    }
    return sticksPanel;
  }

  /**
   * Creates the game choice panel
   * @return panel
   */

  private JPanel createGameChoicePanel() {
    JPanel gameChoicePanel = new JPanel();
    gameChoicePanel.setLayout(new FlowLayout());
    JLabel whoGoFirst = new JLabel("Who go first:");
    Choice gameTypeChoice = new Choice();
    gameTypeChoice.addItem("Machine");
    gameTypeChoice.addItem("Human");
    gameTypeChoice.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        if (event != null
            && event.getStateChange() == ItemEvent.SELECTED) {
          game.setWhoGoFirst( (String) event.getItem());
        }
      }
    });
    gameChoicePanel.add(whoGoFirst);
    gameChoicePanel.add(gameTypeChoice);
    JButton startButton = new JButton("Start");
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        reset();
        game.start();
      }
    });
    gameChoicePanel.add(startButton);
    return gameChoicePanel;
  }

  /**
   * Creates the button panel
   * @return panel
   */
  private JPanel createButtonPanel() {
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    JButton pickUpSticksButton = new JButton("Pick Up Sticks");
    pickUpSticksButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        if (oneStickButton.isSelected()) {
          sticksPicked = 1;
        }
        else if (twoStickButton.isSelected()) {
          sticksPicked = 2;
        }
        else if (threeStickButton.isSelected()) {
          sticksPicked = 3;
        }
        if (game.getCurrentPlayer() != null) {
          game.getCurrentPlayer().pickSticks(sticksPicked);
        }
      }
    });
    buttonPanel.add(pickUpSticksButton);
    JButton restartButton = new JButton("Restart");
    restartButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        reset();
        game.start();
      }
    });
    buttonPanel.add(restartButton);
    return buttonPanel;
  }

  /**
   * Creates the panel for the number of sticks to be picked up
   * @return panel
   */
  private JPanel createHowManySticksPanel() {
    JPanel howManySticks = new JPanel();
    howManySticks.setLayout(new FlowLayout());
    JLabel oneStickLabel = new JLabel("One Stick");
    buttonGroup.add(oneStickButton);
    JLabel twoStickLabel = new JLabel("Two Sticks");
    buttonGroup.add(twoStickButton);
    JLabel threeStickLabel = new JLabel("Three Sticks");
    buttonGroup.add(threeStickButton);
    howManySticks.add(oneStickButton);
    howManySticks.add(oneStickLabel);
    howManySticks.add(twoStickButton);
    howManySticks.add(twoStickLabel);
    howManySticks.add(threeStickButton);
    howManySticks.add(threeStickLabel);
    return howManySticks;
  }

  /**
   * Resets the frame
   */
  protected void reset() {
    sticksPicked = 0;
    totalSticksPicked = 0;
    for (int i = 0; i < 21; i++) {
      sticks[i].setSelected(false);
      sticks[i].setEnabled(false);
      sticks[i].setBackground(Color.white);
    }
  }

  /**
   * Pick up Sticks
   * @param noOfSticks Number of sticks to be picked up
   * @param turn The current player.
   */
  public void pickSticks(int noOfSticks, Player turn) {
    for (int i = totalSticksPicked;
         i < totalSticksPicked + noOfSticks;
         i++) {
      sticks[i].setSelected(true);
      if (turn instanceof HumanPlayer) {
        sticks[i].setBackground(Color.RED);
      }
      else {
        sticks[i].setBackground(Color.BLUE);
      }
    }
    totalSticksPicked = totalSticksPicked + noOfSticks;
  }

  /**
   * Display frame
   *
   */
  public void display() {
    pack();
    setVisible(true);
  }

  /**
   * Display message on messsage  bar
   * @param msg string to be displayed
   */
  public void displayMessage(String msg) {
    messageBar.setText(msg);
  }

  /**
   * Main entry point
   */
  public static void main(String[] args) {
    SimpleNIMGUI simpleNIMGUI = new SimpleNIMGUI();
  }
}