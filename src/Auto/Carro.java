package Auto;

import java.io.Serializable;

public class Carro extends Automovel implements Serializable {
    private int cavalos;

    public Carro(String marca, String modelo, int idade, double valor, boolean disponivel, int cavalos) {
        super(marca, modelo, idade, valor, disponivel);
        this.cavalos = cavalos;
    }
    @Override
    public void simular(int anos) {
        double taxa;
        double valor = getValor();
        double idade = getIdade();
        for (int i = 0; i < anos; i++){
            if (idade <= 3){
                taxa = 0.05;
            } else if (idade <= 8){
                taxa = 0.07;
            } else {
                taxa = 0.12;
            }
            idade += 1;
            valor -= valor * taxa;
        }
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
