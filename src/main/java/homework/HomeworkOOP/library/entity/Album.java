package homework.HomeworkOOP.library.entity;

public class Album extends  Book {

    private int paperQuality;

    public Album(int paperQuality, String name, int numberOfPages)
    {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public int getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(int paperQuality) {
        this.paperQuality = paperQuality;
    }
}
