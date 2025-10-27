public class Person {

    public boolean checkUser(String username) {
        // Deve ter no mínimo 8 caracteres
        if (username == null || username.length() < 8) {
            return false;
        }

        // Não pode conter caracteres especiais — apenas letras e números
        return username.matches("[A-Za-z0-9]+");
    }

    public boolean checkPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        // Pelo menos 1 letra maiúscula
        boolean hasUpperCase = password.matches(".*[A-Z].*");

        // Pelo menos 1 número
        boolean hasDigit = password.matches(".*[0-9].*");

        // Pelo menos 1 caractere especial
        boolean hasSpecial = password.matches(".*[^A-Za-z0-9].*");

        return hasUpperCase && hasDigit && hasSpecial;
    }
}