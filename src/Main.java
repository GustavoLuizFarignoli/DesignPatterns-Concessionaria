import Facade.LoginFacade;
import Singleton.LoginSingleton;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int op = 0;
        Scanner teclado = new Scanner(System.in);

        while(op != 5){
            System.out.println("1-Login\n2-Verificar Login\n3-Logout\n4-Fazer Cadastro\n5-Sair\n");
            op = teclado.nextInt();
            switch(op){
                case 1:
                    System.out.println("Digite o seu email: ");
                    teclado.nextLine();
                    String email = teclado.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senha = teclado.nextLine();
                    LoginFacade.logar(email,senha);
                    break;
                case 2:
                    if(LoginSingleton.instancia != null) {
                        System.out.println(LoginSingleton.instancia);
                    } else{
                        System.out.println("Usuário não logado!");
                    }
                    break;
                case 3:
                    LoginSingleton.logout();
                    break;
                case 4:
                    System.out.println("Digite o seu email: ");
                    teclado.nextLine();
                    String emailcad = teclado.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senhacad = teclado.nextLine();
                    LoginFacade.cadastrar(emailcad,senhacad);
                    break;
                case 5:
                    break;
                case 6:
                    LoginFacade.debug();
                    break;
            }
        }

    }
}