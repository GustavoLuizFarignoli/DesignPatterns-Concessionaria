package Facade;

import Auxiliar.BancoLogin;
import Auxiliar.Emailadapter;
import Auxiliar.Serializador;
import Singleton.Login;
import Singleton.LoginSingleton;

import java.io.IOException;
import java.util.Objects;

public class LoginFacade {
    public static void cadastrar(String email, String senha){
        BancoLogin bancoLogin = leitura();
        Login login = bancoLogin.findcadastro(email);
        if (login == null && Emailadapter.emailvalido(email)){
            Login cadastro = new Login(email, senha);
            bancoLogin.addcadastro(cadastro);
            gravar(bancoLogin);
        } else if (Emailadapter.emailvalido(email)) {
            System.out.println("Esse email já foi cadastrado");
        } else {
            System.out.println("Esse email não é válido, por favor use uma conta de gmail ou outlook");
        }
    }

    public static void logar(String email, String senha){
        BancoLogin bancoLogin = leitura();
        Login login = bancoLogin.findcadastro(email);
        if (login == null){
            System.out.println("Esse email não foi cadastrado ainda");
        } else if (verificarsenha(login,senha)) {
            Login cadastro = new Login(email, senha);
            LoginSingleton.getInstance(email, senha);
        } else {
            System.out.println("Senha incorreta tente novamente");
        }
    }

    public static void debug(){
        Login login = new Login("Gustavo@gmail.com","123");
        BancoLogin bancoLogin = new BancoLogin();
        bancoLogin.addcadastro(login);
        gravar(bancoLogin);
    }

    public static boolean verificarsenha(Login login, String senha){
        if (Objects.equals(login.getSenha(), senha)){
            return true;
        } else {
            return false;
        }
    }

    public static BancoLogin leitura(){
        BancoLogin bancoLogin;
        try {
            bancoLogin = (BancoLogin) Serializador.ler("Cadastros");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bancoLogin;
    }

    public static void gravar(BancoLogin bancoLogin){
        try {
            Serializador.gravar("Cadastros", bancoLogin);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


}
