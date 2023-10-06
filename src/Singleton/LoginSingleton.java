package Singleton;

public class LoginSingleton {
    public static Login instancia;

    public static Login getInstance(String email, String senha){
        if(instancia == null){
            instancia = new Login(email, senha);
        } else {
            System.out.println("Já há um login ativo, faça logout antes de fazer um novo login");
        }
        return instancia;
    }

    public static void logout(){
        instancia = null;
    }

}
