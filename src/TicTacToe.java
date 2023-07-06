import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random(); //Instance of who turns it is
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();//title
    JPanel buttons_panel = new JPanel(); //Hold all the buttons
    JLabel textField = new JLabel();//Display a message
    JButton[] buttons = new JButton[9]; //Array of buttons
    boolean player1_turn; //true = player1's turn, false= player2's turn

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Poppy", Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        buttons_panel.setLayout(new GridLayout(3,3));
        buttons_panel.setBackground(new Color(150,150,150));

        //A For loop to create one-nine buttons(a grid)
        for (int i =0; i<9;i++){
            buttons[i] = new JButton();
            buttons_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Open Sans", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(buttons_panel);

        //Method call
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

        //Method determines first move
        public void firstTurn() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (random.nextInt(2) == 0) {
                player1_turn = true;
                textField.setText("X turn");
            } else {
                player1_turn = false;
                textField.setText("O turn");
            }
        }

        //Checks on who wins
        public void check () {

        //check X win conditions
            if(
                    //First Row has all matching Xs
                    (buttons[0].getText()=="X") &&
                    (buttons[1].getText()=="X") &&
                    (buttons[2].getText()=="X")
            ) {
                xWins(0,1,2);
            }

            if(
                    (buttons[3].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[5].getText()=="X")
            ) {
                xWins(3,4,5);
            }

            if(
                    (buttons[6].getText()=="X") &&
                    (buttons[7].getText()=="X") &&
                    (buttons[8].getText()=="X")
            ) {
                xWins(6,7,8);
            }
            if(
                    (buttons[0].getText()=="X") &&
                    (buttons[3].getText()=="X") &&
                    (buttons[6].getText()=="X")
            ) {
                xWins(0,3,6);
            }
            if(
                    (buttons[1].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[7].getText()=="X")
            ) {
                xWins(1,4,7);
            }
            if(
                    (buttons[2].getText()=="X") &&
                    (buttons[5].getText()=="X") &&
                    (buttons[8].getText()=="X")
            ) {
                xWins(2,5,8);
            }
            if(
                    (buttons[0].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[8].getText()=="X")
            ) {
                xWins(0,4,8);
            }
            if(
                    (buttons[2].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[6].getText()=="X")
            ) {
                xWins(2,5,8);
            }

        //check O win conditions
            if(
                //First Row has all matching Os
                    (buttons[0].getText()=="O") &&
                            (buttons[1].getText()=="O") &&
                            (buttons[2].getText()=="O")
            ) {
                oWins(0,1,2);
            }

            if(
                    (buttons[3].getText()=="O") &&
                            (buttons[4].getText()=="O") &&
                            (buttons[5].getText()=="O")
            ) {
                oWins(3,4,5);
            }

            if(
                    (buttons[6].getText()=="O") &&
                            (buttons[7].getText()=="O") &&
                            (buttons[8].getText()=="O")
            ) {
                oWins(6,7,8);
            }
            if(
                    (buttons[0].getText()=="O") &&
                            (buttons[3].getText()=="O") &&
                            (buttons[6].getText()=="O")
            ) {
                oWins(0,3,6);
            }
            if(
                    (buttons[1].getText()=="O") &&
                            (buttons[4].getText()=="O") &&
                            (buttons[7].getText()=="O")
            ) {
                oWins(1,4,7);
            }
            if(
                    (buttons[2].getText()=="O") &&
                            (buttons[5].getText()=="O") &&
                            (buttons[8].getText()=="O")
            ) {
                oWins(2,5,8);
            }
            if(
                    (buttons[0].getText()=="O") &&
                            (buttons[4].getText()=="O") &&
                            (buttons[8].getText()=="O")
            ) {
                oWins(0,4,8);
            }
            if(
                    (buttons[2].getText()=="O") &&
                            (buttons[4].getText()=="O") &&
                            (buttons[6].getText()=="O")
            ) {
                oWins(2,5,8);
            }
        }
        public void xWins ( int a, int b, int c){
            buttons[a].setBackground(Color.green);
            buttons[b].setBackground(Color.green);
            buttons[c].setBackground(Color.green);

            //disable button
            for (int i =0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textField.setText("X wins");
        }
        public void oWins ( int a, int b, int c){
            buttons[a].setBackground(Color.green);
            buttons[b].setBackground(Color.green);
            buttons[c].setBackground(Color.green);

            //disable button
            for (int i =0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textField.setText("O wins");

        }
     }
