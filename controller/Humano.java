package controller;
import java.util.Scanner;

import view.View;
import model.Jogador;
import model.Tabuleiro;

public class Humano extends Jogador {

    public Scanner entrada = new Scanner(System.in);
    
    public Humano(int jogador) {

        super(jogador);

        this.jogador = jogador;

    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro) {

        Tentativa(tabuleiro);

        tabuleiro.setPosicao(tentativa, jogador);

    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro) {

        View v = new View();

        do {
            
            do {

                v.msgLinha();

                tentativa[0] = entrada.nextInt();

                v.msgJogadaLinha(tentativa[0]);
                
            } while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do {

                v.msgColuna();

                tentativa[1] = entrada.nextInt();
                
                v.msgJogadaColuna(tentativa[1]);
                
                
            } while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                v.msgLocalInvalido();

        } while( !checaTentativa(tentativa, tabuleiro) );

    }

}


