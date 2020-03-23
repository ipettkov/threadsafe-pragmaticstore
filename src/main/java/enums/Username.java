package enums;

public enum Username {
    VALID_USERNAME("admin");

    private String username;

    Username(String username) {
       this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
