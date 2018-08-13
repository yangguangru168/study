package Entity;

/**
 * @author 杨光儒
 * @Title: Film
 * @ProjectName projectStudy
 * @Description: TODO
 * @date 2018/8/1311:57
 */
public class Film {
    private int file_id;
    private String title;
    private String description;
    private int language_id;

    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Film{" +
                "file_id=" + file_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language_id + '\'' +
                '}';
    }
}
