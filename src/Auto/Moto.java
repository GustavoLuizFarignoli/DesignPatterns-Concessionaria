package Auto;

import java.io.Serializable;

public class Moto extends Automovel implements Serializable {
    private int cilindradas;

    public Moto(String marca, String modelo, int idade, double valor, boolean disponivel, int cilindradas) {
        super(marca, modelo, idade, valor, disponivel);
        this.cilindradas = cilindradas;
    }

    @Override
    void simular(int anos) {
        double Taxa = 0;
        if (getIdade() <= 3){
            Taxa = 0.03;
        } else if (getIdade() <= 5){
            Taxa = 0.05;
        } else {
            Taxa = 0.10;
        }
        double valor = getValor()  - (getValor() * Taxa);
        System.out.println("O valor do moto seria R$" + valor);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "Marca: " + getMarca() + ", " +
                "Modelo: " + getModelo() + ", " +
                "Idade: " + getIdade() + ", " +
                "Valor: " + getValor() + ", " +
                "Disponivel: " + alugado() + ", " +
                "Cilindradas: " + cilindradas +
                '}';
    }
}
