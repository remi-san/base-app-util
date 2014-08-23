package net.remisan.base.app.config;

public class PageConfig {
    
    private String title = "";
    private String description = "";
    private String keywords;
    private String robots;
    private String author;
    
    public PageConfig() {
        super();
    }

    public PageConfig(
        String title,
        String description,
        String keywords,
        String robots,
        String author
    ) {
        super();
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.robots = robots;
        this.author = author;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return this.keywords;
    }

    /**
     * @return the robots
     */
    public String getRobots() {
        return this.robots;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @param robots the robots to set
     */
    public void setRobots(String robots) {
        this.robots = robots;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}
