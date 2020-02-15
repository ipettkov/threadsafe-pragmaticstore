package enums;

public enum Password {
    ADMIN_PASSWORD("parola123!"),
    INVALID_PASSWORD("invalid pass");
    //comment something
    private String password;

    Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
