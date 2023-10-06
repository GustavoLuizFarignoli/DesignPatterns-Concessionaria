package Singleton;

import java.io.Serializable;

public class Login implements Serializable {
    public String email, senha;

    public Login(String email, String senha){
        if(email != null && senha != null){
            this.email = email;
            this.senha = senha;
        }
    }

    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
