package DTO;

public class Subscription {

    static private int counter = 1000;

    private Integer id;
    private User user;
    private Integer totalCredit;
    private String Teams;

    public Subscription() {
        this.user = null;
        this.totalCredit = 0;
        this.Teams = "";
        this.id = counter;
        counter += 10;
    }

    public Subscription(User user) {
        this.user = null;
        this.totalCredit = 0;
        this.Teams = "";
        this.id = counter;
        counter += 10;
        this.user = user;
    }

    public void setTeams(Club addClub) {
        this.Teams += "\n" + addClub.getCode() + " $"
                + String.format("%,d", addClub.getValueSub())
                + ';';
        this.totalCredit += addClub.getValueSub();
    }

    public static int getCounter() {
        return counter;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public String getTeams() {
        return Teams;
    }

    public void print() {
        System.out.println(
                "El usuario: " + this.user.getUsername() + " Esta suscrito a"
                + " los siguientes clubes: \n" + this.Teams + "\n\n");
    }

}
