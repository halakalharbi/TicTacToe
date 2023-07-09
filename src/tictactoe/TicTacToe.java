
package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class TicTacToe extends JFrame {
    //the componant
    private JPanel p1;
    private JPanel p2;
    private JButton[][] xo;
    private JButton newGame;
    private JButton exit;
    private char[][] xy;
    private boolean changeplayer;
        
public TicTacToe() {
    setTitle("Tic-Tac-Toe Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    setSize(200,400);
    p1 = new JPanel(new GridLayout(3, 3));
    xo = new JButton[3][3];
    xy = new char[3][3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            xo[i][j] = new JButton(" "); 
            xo[i][j].setEnabled(true); 
            xo[i][j].addActionListener(new GameListener()); 
            xo[i][j].setActionCommand(i + " " + j);
            p1.add(xo[i][j]);
            xy[i][j] = '.';
    }
}
    this.add(p1, BorderLayout.CENTER);
    changeplayer = true;
    p2=new JPanel();
    p2.setLayout(new FlowLayout(FlowLayout.CENTER));
    newGame=new JButton("New Game");
    newGame.addActionListener(new NewListener());
    exit=new JButton("Exit");
    exit.addActionListener(new ExitListener());
    p2.add(newGame);
    p2.add(exit);
    add(p2,BorderLayout.SOUTH);
	}
private boolean won(char playerMark, char[][] board){
    for (int row = 0; row < 3; row++){
        int count = 0;
	for (int col = 0; col < 3; col++) 
	{
    if (board[row][col] == playerMark)
        count++;
    else
	count = 0;
	}

    if (count == 3)
	return true;
        }
    for (int col = 0; col < 3; col++){
	int count = 0;
	for (int row = 0; row < 3; row++){
	    if (board[row][col] == playerMark)
		count++;
	    else
		count = 0;
	}
        if (count == 3)
                return true;
		}
	if (board[1][1] == playerMark && board[0][0] == playerMark && board[2][2] == playerMark)
		return true;

	if (board[1][1] == playerMark && board[0][2] == playerMark && board[2][0] == playerMark)
		return true;
		return false;
	}

private boolean tie(char[][] board){
    for (int i = 0; i < 3; i++){
	for (int j = 0; j < 3; j++){
            if (board[i][j] == '.')
		return false;
	}
}
		return true;}

private class GameListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
            String s = e.getActionCommand();
            Scanner input = new Scanner(s);
            String rowString = input.next();
	    String colString = input.next();

	    int row = Integer.parseInt(rowString);
	    int column = Integer.parseInt(colString);

	    JButton button = xo[row][column];
            
            if (button.isEnabled()) {
		if (changeplayer) {
                    button.setText("X");
		    xy[row][column] = 'X';
		    button.setEnabled(false);
		    changeplayer = false;		
                }
                else {
                    button.setText("O");
                    xy[row][column] = 'O';
                    button.setEnabled(false);
                    changeplayer = true;
				}
			}
		if (tie(xy)){
                    JOptionPane.showMessageDialog(null, "No winner! ");
                    for (int i = 0; i < 3; i++)
		    for (int j = 0; j < 3; j++)
		    xo[i][j].setEnabled(false);
		}
		if (won('X', xy)){
                    JOptionPane.showMessageDialog(null, "Player X has won! ");		
		    for (int i = 0; i < 3; i++) 
                        for (int j = 0; j < 3; j++)
                        xo[i][j].setEnabled(false);
			}

		if (won('O', xy)){
                    JOptionPane.showMessageDialog(null, "Player O has won! ");
				
                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                            xo[i][j].setEnabled(false);
			}
		
	}
        }
        private class ExitListener implements ActionListener
          {
            public void actionPerformed(ActionEvent e)
            {
               System.exit(0);
            }
          }
         private class NewListener implements ActionListener
          {
            public void actionPerformed(ActionEvent e)
            {
              for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
                                
				xo[i][j].setEnabled(true);
                                xo[i][j].setText("");
				xy[i][j] = '.';
			}
		}
            }
          }
	public static void main(String args[])
	{
		TicTacToe t = new TicTacToe();
		
        }
}
