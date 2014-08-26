package net.remisan.base.app.config;

/**
 * The PageConfig class is aimed at defining the configuration for a web page
 * 
 * @author Remi San<remi.san@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public class PageConfig {
    
    /**
     * The title of the web page (must be unique)
     */
    private String title = "";
    
    /**
     * The description of the web page (must be unique)
     */
    private String description = "";
    
    /**
     * The keywords for the web page (must be separated by commas - no space after)
     */
    private String keywords;
    
    /**
     * The robots configuration for the web page
     */
    private String robots;
    
    /**
     * The author of the web page
     */
    private String author;
    
    /**
     * The default
     */
    public PageConfig() {
        super();
    }

    /**
     * Complete constructor
     * Parameters are set using the setters
     * 
     * @param title       The title
     * @param description The description
     * @param keywords    The keywords
     * @param robots      The robots
     * @param author      The author
     */
    public PageConfig(
        String title,
        String description,
        String keywords,
        String robots,
        String author
    ) {
        super();
        this.setTitle(title);
        this.setDescription(description);
        this.setKeywords(keywords);
        this.setRobots(robots);
        this.setAuthor(author);
    }

    /**
     * Getter for the member variable <strong>title</strong>
     *
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for the member variable <strong>description</strong>
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for the member variable <strong>keywords</strong>
     *
     * @return the keywords
     */
    public String getKeywords() {
        return this.keywords;
    }

    /**
     * Getter for the member variable <strong>robots</strong>
     *
     * @return the robots
     */
    public String getRobots() {
        return this.robots;
    }

    /**
     * Getter for the member variable <strong>author</strong>
     *
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Setter for the member variable <strong>title</strong>
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter for the member variable <strong>description</strong>
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for the member variable <strong>keywords</strong>
     *
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Setter for the member variable <strong>robots</strong>
     *
     * @param robots the robots to set
     */
    public void setRobots(String robots) {
        this.robots = robots;
    }

    /**
     * Setter for the member variable <strong>author</strong>
     *
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}