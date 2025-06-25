package model;

public class ContadorTag {
    private String nome;
    private int contagem;

    public ContadorTag(String nome) {
        this.nome = nome.toLowerCase();
        this.contagem = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getContagem() {
        return contagem;
    }

    public void incrementar() {
        contagem++;
    }

    @Override
    public String toString() {
        return nome + " - " + contagem;
    }
}