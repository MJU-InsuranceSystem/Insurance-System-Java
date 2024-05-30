package org.example.planTeam;

public enum Status {

    success("200"), fail("400");
    private final String status;
    private static final String KEY = "status";

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static String key() {
        return KEY;
    }
}
