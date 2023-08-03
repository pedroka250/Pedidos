package devandroid.kauamatheus.listadepedidos.Model;

public class Item {

    private String nome;
    private String qntd;
    private double preco;

    public Item(){

    }
    public Item(String nome, String qntd){
        this.nome = nome;
        this.qntd = qntd;
    }

    public Item(String nome, double preco, String qntd) {
        this.nome = nome;
        this.preco = preco;
        this.qntd = qntd;
    }

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQntd() {
        return qntd;
    }

    public void setQntd(String qntd) {
        this.qntd = qntd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome +": R$"+ preco +" " +qntd;
    }
}
