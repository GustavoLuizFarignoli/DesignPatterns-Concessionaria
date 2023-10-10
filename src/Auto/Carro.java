package Auto;

import java.io.Serializable;

public class Carro extends Automovel implements Serializable {
    private int cavalos;

    public Carro(String marca, String modelo, int idade, double valor, boolean disponivel, int cavalos) {
        super(marca, modelo, idade, valor, disponivel);
        this.cavalos = cavalos;
    }
    @Override
    void simular(int anos) {
        double taxa;
        if ((getIdade() + anos) <= 3){
            taxa = 0.05;
        } else if ((getIdade() + anos) <= 8){
            taxa = 0.07;
        } else {
            taxa = 0.12;
        }
        double valor = getValor() - (getValor() * taxa);
        System.out.println("O valor do carro seria R$" + valor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "Marca: " + getMarca() + ", " +
                "Modelo: " + getModelo() + ", " +
                "Idade: " + getIdade() + ", " +
                "Valor: " + getValor() + ", " +
                "Disponivel: " + alugado() + ", " +
                "Cavalos=" + this.cavalos +
                '}';
    }
}
