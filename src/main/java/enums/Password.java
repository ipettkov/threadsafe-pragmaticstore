package enums;

public enum Password {
    ADMIN_PASSWORD("parola123!");

    private String password;

    Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
