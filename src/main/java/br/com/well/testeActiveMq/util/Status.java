package br.com.well.testeActiveMq.util;

public enum Status {
    ADMIN("ADMIN"),
    USER("USER");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
