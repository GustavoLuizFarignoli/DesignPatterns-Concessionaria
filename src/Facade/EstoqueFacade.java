package Facade;

import Auto.Automovel;
import Auto.Carro;
import Auto.Moto;
import Auxiliar.Estoque;
import Auxiliar.Serializador;

import java.io.IOException;

public class EstoqueFacade {

    public static void visualizarestoque(){
        Estoque estoque = leitura();
        estoque.viewestoque();
    }

    public static void alugarautomovel(String modelo){
        Estoque estoque = leitura();
        Automovel automovel = estoque.findauto(modelo);
        if (automovel == null){
            System.out.println("Não foi possível encontrar esse modelo");
        } else {
            if (automovel.isDisponivel()){
                System.out.println("Automovel Alugado com sucesso");
                automovel.setDisponivel(false);
            } else {
                System.out.println("Este automovel já está alugado");
            }
        }
        gravar(estoque);
    }

    public static void comprarautomovel(String modelo){
        Estoque estoque = leitura();
        Automovel automovel = estoque.findauto(modelo);
        if (automovel == null){
            System.out.println("Não foi possível encontrar esse modelo");
        } else {
            if (automovel.isDisponivel()){
                System.out.println("Automovel Comprado com sucesso");
                estoque.removeauto(automovel);
            } else {
                System.out.println("Este automovel está alugado e não está disponivel pra ser vendido");
            }
        }
        gravar(estoque);
    }

    public  static void simularvalorização(String modelo, int anos){
        Estoque estoque = leitura();
        Automovel automovel = estoque.findauto(modelo);
        if (automovel == null){
            System.out.println("Não foi possível encontrar esse modelo");
        } else {
            automovel.simular(anos);
        }
    }


    public static void debug(){
        Automovel automovel = new Carro ("Volkswagen","Palio",5,35000,true,55);
        Automovel automovel1 = new Carro ("Fiat","Uno",10,44190,false,77);
        Automovel automovel2 = new Moto("Honda","Hornet",0,25500,true,755);
        Automovel automovel3 = new Moto ("Yamaha","FACTOR 150",2,14790,true,149);
        Estoque estoque = new Estoque();
        estoque.addauto(automovel);
        estoque.addauto(automovel1);
        estoque.addauto(automovel2);
        estoque.addauto(automovel3);
        gravar(estoque);
    }

    public static Estoque leitura(){
        Estoque estoque;
        try {
            estoque = (Estoque) Serializador.ler("Estoque");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return estoque;
    }

    public static void gravar(Estoque estoque){
        try {
            Serializador.gravar("Estoque", estoque);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
