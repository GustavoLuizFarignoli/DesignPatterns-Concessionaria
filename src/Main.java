import Singleton.LoginSingleton;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int op = 0;
        Scanner teclado = new Scanner(System.in);

        while(op != 4){
            print("1-Login\n2-Verificar Login\n3-Logout\n4-Sair\n");
            op = teclado.nextInt();
            switch(op){
                case 1:
                    print("Digite o seu email: ");
                    teclado.nextLine();
                    String email = teclado.nextLine();
                    print("Digite sua senha: ");
                    String senha = teclado.nextLine();
                    LoginSingleton.getInstance(email, senha);
                    break;
                case 2:
                    if(LoginSingleton.instancia != null) {
                        print(LoginSingleton.instancia.toString());
                    } else{
                        print("Usuário não logado!");
                    }
                    break;
                case 3:
                    LoginSingleton.logout();
                case 4:
                    break;
            }
        }

    }

    public static void print(String mensagem){
        System.out.println(mensagem);
    }
}