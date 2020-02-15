package enums;

public enum Password {
    ADMIN_PASSWORD("parola123!"),
    INVALID_PASSWORD("invalid pass");

    private String password;

    Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
