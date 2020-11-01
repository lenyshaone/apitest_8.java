public class NameDetails {
    private String last;
   private String first;

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String get_first_last() {
        return first+" "+ last;
    }
}
