package revisaoProva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Post {
    private String quote;
    private LocalDate date;
    private int claps;
    private int boos;
    private UserAccount account;

    public Post(UserAccount account, String quote) {
        this.quote = quote;
        this.date = LocalDate.now();
        this.account = account;
    }
    public String show(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s] %s\n" + "says \"%s\" | Claps: %d | Boos: %d", date.format(fmt),quote, account.getName(), claps, boos );
    }
    public void clap(){
        claps++;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getClaps() {
        return claps;
    }

    public String getQuote() {
        return quote;
    }

    public int getBoos() {
        return boos;
    }

    public void boo(){
        boos++;
    }
}
