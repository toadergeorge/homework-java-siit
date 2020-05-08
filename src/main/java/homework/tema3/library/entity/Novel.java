package homework.tema3.library.entity;

public class Novel extends  Book {

    private String type;

    public Novel(String type, String name, int numberOfPages)
    {
        super(name, numberOfPages);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
