package Auto;

import java.io.Serializable;

public abstract class Automovel implements Serializable {
    private String Marca;
    private String Modelo;
    private int idade;
    private double valor;
    private boolean disponivel;

    public Automovel(String marca, String modelo, int idade, double valor, boolean disponivel) {
        Marca = marca;
        Modelo = modelo;
        this.idade = idade;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    abstract void simular(int anos);

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getIdade() {
        return idade;
    }

    public double getValor() {
        return valor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String alugado(){
        if (this.disponivel){
            return "Sim";
        } else {
            return "Não";
        }
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
