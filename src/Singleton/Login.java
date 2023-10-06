package Singleton;
public class Login {
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

}
