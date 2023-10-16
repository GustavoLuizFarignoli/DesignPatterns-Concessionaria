package Auto;

import java.io.Serializable;

public class Moto extends Automovel implements Serializable {
    private int cilindradas;

    public Moto(String marca, String modelo, int idade, double valor, boolean disponivel, int cilindradas) {
        super(marca, modelo, idade, valor, disponivel);
        this.cilindradas = cilindradas;
    }

    @Override
    public void simular(int anos) {
        double taxa = 0;
        double valor = getValor();
        double idade = getIdade();
        for (int i = 0; i < anos; i++){
            if (idade <= 3){
                taxa = 0.03;
            } else if (idade <= 5){
                taxa = 0.05;
            } else {
                taxa = 0.10;
            }
            idade += 1;
            valor -= valor * taxa;
        }
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
