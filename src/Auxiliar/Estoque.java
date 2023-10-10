package Auxiliar;

import Auto.Automovel;
import Singleton.Login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Estoque implements Serializable {
    private ArrayList<Automovel> estoque = new ArrayList<Automovel>();
    public void addauto (Automovel automovel){
        this.estoque.add(automovel);
    }

    public void  removeauto(Automovel automovel){
        this.estoque.remove(automovel);
    }

    public void viewestoque(){
        for (Automovel a : this.estoque){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println(a);
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public Automovel findauto (String modelo){
        Automovel automovel = null;
        for (Automovel a : this.estoque){
            if (Objects.equals(a.getModelo().toUpperCase(), modelo.toUpperCase())){
                automovel = a;
            }
        }
        return automovel; //Quem for usar tem que tratar do resultado nulo
    }
}
