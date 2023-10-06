package Singleton;

public class LoginSingleton {
    public static Login instancia;

    public static Login getInstance(String email, String senha){
        if(instancia == null){
            instancia = new Login(email, senha);
        }
        return instancia;
    }

    public static void logout(){
        instancia = null;
    }

}
