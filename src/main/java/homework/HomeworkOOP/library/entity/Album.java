package homework.HomeworkOOP.library.entity;

public class Album extends  Book {

    private String paperQuality;

    public Album(String paperQuality, String name, int numberOfPages)
    {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }
}
