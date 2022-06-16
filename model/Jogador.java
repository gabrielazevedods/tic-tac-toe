package model;

// Classe que representa um modelo de jogador, podendo ser um humano ou um computador (O computador não foi implementado).
public abstract class Jogador {
    
    protected int[] tentativa = new int[2];
    protected int jogador;

    
    public Jogador(int jogador) {

        this.jogador = jogador;

    }
    
    public abstract void jogar(Tabuleiro tabuleiro);
    
    public abstract void Tentativa(Tabuleiro tabuleiro);

    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro) {

        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
            
    }

}

