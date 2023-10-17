package Auxiliar;

import Singleton.Emailvalidation;

public class Emailadapter {
    public static boolean emailvalido(String email) {
        return Emailvalidation.isValidEmail(email);
    }
}
