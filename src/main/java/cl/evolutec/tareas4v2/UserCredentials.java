package cl.evolutec.tareas4v2;

public class UserCredentials {

    private String username;
    private int password;

    public UserCredentials(String username, String password)  throws NumberFormatException{
        this.username = username;
        try {
            this.password = Integer.parseInt(password);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("La contraseña debe ser numérica.");
        }
    }

    public String getUsername() {
        return username;
    }
    public int getPassword() {
        return password;
    }

}
