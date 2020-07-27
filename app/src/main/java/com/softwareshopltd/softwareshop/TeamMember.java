package com.softwareshopltd.softwareshop;

public class TeamMember {

    private String name;
    private String idNumber;
    private String role;
    private String summary;
    private int picture;

    public TeamMember(String name, String idNumber, String role, int picture) {
        this.name = name;
        this.idNumber = idNumber;
        this.role = role;
        this.picture = picture;
    }

    public TeamMember(String name, String idNumber, String role, String summary, int picture) {
        this.name = name;
        this.idNumber = idNumber;
        this.role = role;
        this.summary = summary;
        this.picture = picture;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getRole() {
        return role;
    }

    public String getSummary() {
        return summary;
    }

    public int getPicture() {
        return picture;
    }
}
