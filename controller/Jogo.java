package controller;
import java.util.Scanner;

import view.View;
import model.Jogador;
import model.Tabuleiro;

public class Jogo {

    private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);
    
    public Jogo(){

        tabuleiro = new Tabuleiro();

        iniciarJogadores();
        
        while( Jogar() );

    }
    
    public void iniciarJogadores(){
      
      this.jogador1 = new Humano(1);
      this.jogador2 = new Humano(2);
        
    }
    
    public boolean Jogar() {

        View v = new View();

        if(v.msgTela(ganhou(), rodada, vez(), tabuleiro) == 1) {

            if(vez() == 1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);

            vez++;
            rodada++;
        
            return true;

        }

        if(v.msgTela(ganhou(), rodada, vez(), tabuleiro) == 0) {

            return false;

        }

        return false;

    }
    
    public int vez() {

        if(vez%2 == 1)
            return 1;
        else
            return 2;

    }
    
    public int ganhou() {

        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;

    }
    
}


