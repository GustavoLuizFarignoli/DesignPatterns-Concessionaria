package Auxiliar;

import Singleton.Login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class BancoLogin implements Serializable {
    private ArrayList<Login> cadastros = new ArrayList<Login>();

    public void addcadastro (Login login){
        this.cadastros.add(login);
    }

    public Login findcadastro (String email){
        Login login = null;
        for (Login l : this.cadastros){
            if (Objects.equals(l.getEmail(), email)){
                login = l;
            }
        }
        return login; //Quem for usar tem que tratar do resultado nulo
    }

    public void setCadastros(ArrayList<Login> cadastros) {
        this.cadastros = cadastros;
    }
}
