package core;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class JogoDaVelha implements ActionListener {

    private JFrame mainFrame;

    JPanel t_panel = new JPanel(); // Painel de Texto.
    JPanel bt_panel = new JPanel(); // Painel que é responsável por alocar os botões que atuarão como marcações X e O, ele é adicionado a um Layout de Grid 3x3.

    JLabel textfield = new JLabel();

    JButton[] bton = new JButton[9];

    int chance_flag = 0;

    Random random = new Random();

    boolean pl1_chance;

    public JogoDaVelha() {

        mainFrame = new JFrame("Jogo da Velha - Tic Tac Toe");

        mainFrame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowEvent) {

                System.exit(0);

            }

        });

        mainFrame.setLayout(new GridLayout(3, 3));
        mainFrame.getContentPane().setBackground(new Color(50, 50, 50));
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textfield.setBackground(new Color(120, 20, 124));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);
        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {

            bton[i] = new JButton(); // Como é um painel que utiliza um layout 3x3, então precisaremos de 9 butões que representarão as marcações.

            bt_panel.add(bton[i]);

            bton[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);

        }
        
        t_panel.add(textfield);

        mainFrame.add(t_panel, BorderLayout.NORTH);
        mainFrame.add(bt_panel);
    
        mainFrame.setVisible(true);

        startGame();

    }

    public void startGame() {

        try {

            textfield.setText("Carregando...");

            Thread.sleep(4000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        int chance = random.nextInt(100);

        if (chance % 2 == 0) {

            pl1_chance = true;

            textfield.setText("Vez do X");

        } else {

            pl1_chance = false;

            textfield.setText("Vez do O");

        }

    }
    public void gameOver(String s){

        chance_flag = 0;

        Object[] option = {"Reiniciar", "Sair"};

        int n = JOptionPane.showOptionDialog(mainFrame, "Fim do jogo\n"+s,"Fim do jogo",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
      
        if(n == 0){

            mainFrame.dispose();

            new JogoDaVelha();

        }

        else{

            mainFrame.dispose();
            
        }
    
    }
    public void matchCheck() {// In this function we are checking wining condition's using conditional statments

        if ((bton[0].getText() == "X") && (bton[1].getText() == "X") && (bton[2].getText() == "X")) {

            xWins(0, 1, 2);

        }

        else if ((bton[0].getText() == "X") && (bton[4].getText() == "X") && (bton[8].getText() == "X")) {

            xWins(0, 4, 8);

        }

        else if ((bton[0].getText() == "X") && (bton[3].getText() == "X") && (bton[6].getText() == "X")) {

            xWins(0, 3, 6);

        }
        else if ((bton[1].getText() == "X") && (bton[4].getText() == "X") && (bton[7].getText() == "X")) {

            xWins(1, 4, 7);

        }

        else if ((bton[2].getText() == "X") && (bton[4].getText() == "X") && (bton[6].getText() == "X")) {

            xWins(2, 4, 6);

        }

        else if ((bton[2].getText() == "X") && (bton[5].getText() == "X") && (bton[8].getText() == "X")) {

            xWins(2, 5, 8);

        }

        else if ((bton[3].getText() == "X") && (bton[4].getText() == "X") && (bton[5].getText() == "X")) {

            xWins(3, 4, 5);

        }

        else if ((bton[6].getText() == "X") && (bton[7].getText() == "X") && (bton[8].getText() == "X")) {

            xWins(6, 7, 8);

        }
      
        else if ((bton[0].getText() == "O") && (bton[1].getText() == "O") && (bton[2].getText() == "O")) {

            oWins(0, 1, 2);

        }

        else if ((bton[0].getText() == "O") && (bton[3].getText() == "O") && (bton[6].getText() == "O")) {

            oWins(0, 3, 6);

        }

        else if ((bton[0].getText() == "O") && (bton[4].getText() == "O") && (bton[8].getText() == "O")) {

            oWins(0, 4, 8);

        }
        
        else if ((bton[1].getText() == "O") && (bton[4].getText() == "O") && (bton[7].getText() == "O")) {

            oWins(1, 4, 7);

        }

        else if ((bton[2].getText() == "O") && (bton[4].getText() == "O") && (bton[6].getText() == "O")) {

            oWins(2, 4, 6);

        }

        else if ((bton[2].getText() == "O") && (bton[5].getText() == "O") && (bton[8].getText() == "O")) {

            oWins(2, 5, 8);

        }

        else if ((bton[3].getText() == "O") && (bton[4].getText() == "O") && (bton[5].getText() == "O")) {

            oWins(3, 4, 5);

        } else if ((bton[6].getText() == "O") && (bton[7].getText() == "O") && (bton[8].getText() == "O")) {

            oWins(6, 7, 8);

        }

        else if(chance_flag == 9) {

            textfield.setText("A partida resultou em um empate.");

            gameOver("A partida resultou em um empate.");

        }

    }

    public void xWins(int x1, int x2, int x3) {

        bton[x1].setBackground(Color.RED);
        bton[x2].setBackground(Color.RED);
        bton[x3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            
            bton[i].setEnabled(false);

        }

        textfield.setText("X ganhou!");

        gameOver("X ganhou!");

    }

    public void oWins(int x1, int x2, int x3) {

        bton[x1].setBackground(Color.RED);
        bton[x2].setBackground(Color.RED);
        bton[x3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {

            bton[i].setEnabled(false);

        }
        
        textfield.setText("O ganhou!");

        gameOver("O ganhou!");

    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == bton[i]) {

                if (pl1_chance) {

                    if (bton[i].getText() == "") {
                        
                        bton[i].setForeground(new Color(255, 0, 0));
                        bton[i].setText("X");

                        pl1_chance = false;

                        textfield.setText("Vez do O");

                        chance_flag++;

                        matchCheck();

                    }

                } else {

                    if (bton[i].getText() == "") {
                        
                        bton[i].setForeground(new Color(0, 0, 255));
                        bton[i].setText("O");

                        pl1_chance = true;

                        textfield.setText("Vez do X");

                        chance_flag++;

                        matchCheck();
                    }
                }
            }
        }
    }

}

