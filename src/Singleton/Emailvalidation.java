package Singleton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emailvalidation {
    public static boolean isValidEmail(String email) {
        // Define a expressão regular para validar e-mails com domínio do Gmail ou Outlook
        String regex = "^[A-Za-z0-9+_.-]+@(gmail\\.com|outlook\\.com)$";

        // Compila a expressão regular em um padrão
        Pattern pattern = Pattern.compile(regex);

        // Cria um objeto Matcher para corresponder o padrão ao email fornecido
        Matcher matcher = pattern.matcher(email);

        // Retorna verdadeiro se o email corresponde à expressão regular
        return matcher.matches();
    }
}
