package view;
import model.Tabuleiro;

public class View {

    public View() {

    }

    public int msgTela(int ganhou, int rodada, int vez, Tabuleiro tabuleiro) {

        if(tabuleiro.tabuleiroCompleto()) {

            System.out.println("Tabuleiro Completo. Jogo empatado");

            return 0;

        }

        if(ganhou == 0 ) {
            
            System.out.println("----------------------");
            System.out.println("\nRodada " + rodada);
            System.out.println("É a vez do jogador " + vez );

            return 1;

        }

        else if(ganhou == -1 ) {

            System.out.println("Jogador 1 ganhou!");

            return 0;

        }

        else {

            System.out.println("Jogador 2 ganhou!");

            return 0;

        }

    }

    public void exibeTabuleiro(int[][] tabuleiro) { // Método que desenha o tabuleiro do jogo

        System.out.println();

        for(int linha=0 ; linha<3 ; linha++) {
        
            for(int coluna=0 ; coluna<3 ; coluna++) { 
                
                if(tabuleiro[linha][coluna]==-1) {

                    System.out.print(" X ");

                }

                if(tabuleiro[linha][coluna]==1) {

                    System.out.print(" O ");

                }
                if(tabuleiro[linha][coluna]==0) {

                    System.out.print("   ");

                }
                
                if(coluna==0 || coluna==1)

                    System.out.print("|");

            }

            System.out.println();

        }
                
    }
    
}


