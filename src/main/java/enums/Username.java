package enums;

public enum Username {
    VALID_USERNAME("admin"),
    INVALID_USERNAME("hsadasda");

    private String username;

    Username(String username) {
       this.username = username;
    }

    public String getUsername() {
        return username;
    }
//change2222
}
