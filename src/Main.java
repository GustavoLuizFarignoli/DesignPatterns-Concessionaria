import Auxiliar.Estoque;
import Facade.EstoqueFacade;
import Facade.LoginFacade;
import Singleton.LoginSingleton;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean running = true;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        while(running) {
            if (LoginSingleton.instancia == null) {
                running = loginmenu(teclado);
            } else {
                menu(teclado);
            }
        }
    }

    public static boolean loginmenu(Scanner teclado){
        int op = 0;
        boolean running = true;
        System.out.println("1-Login\n2-Verificar Login\n3-Fazer Cadastro\n4-Sair");
        op = teclado.nextInt();
        switch(op) {
            case 1:
                System.out.println("Digite o seu email: ");
                teclado.nextLine();
                String email = teclado.nextLine();
                System.out.println("Digite sua senha: ");
                String senha = teclado.nextLine();
                LoginFacade.logar(email, senha);
                break;
            case 2:
                if (LoginSingleton.instancia != null) {
                    System.out.println(LoginSingleton.instancia);
                } else {
                    System.out.println("Usuário não logado!");
                }
                break;
            case 3:
                System.out.println("Digite o seu email: ");
                teclado.nextLine();
                String emailcad = teclado.nextLine();
                System.out.println("Digite sua senha: ");
                String senhacad = teclado.nextLine();
                LoginFacade.cadastrar(emailcad, senhacad);
                break;
            case 4:
                running = false;
                break;
            case 5:
                LoginFacade.debug();
                break;
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        return running;
    }

    public static void menu (Scanner teclado){
        int op = 0;
        System.out.println("1-Ver Estoque\n2-Realizar Compra\n3-Realizar Aluguel\n4-Simular Desvalorização\n5-Fazer Logout");
        op = teclado.nextInt();
        switch(op) {
            case 1:
                EstoqueFacade.visualizarestoque();
                break;
            case 2:
                System.out.println("Compra");
                break;
            case 3:
                System.out.println("Digite o modelo a ser alugado: ");
                teclado.nextLine();
                String modelo = teclado.nextLine();
                EstoqueFacade.alugarautomovel(modelo);
                break;
            case 4:
                System.out.println("Simulando");
                break;
            case 5:
                System.out.println("Realizando log out...");
                LoginSingleton.logout();
                break;
            case 6:
                EstoqueFacade.debug();
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
}