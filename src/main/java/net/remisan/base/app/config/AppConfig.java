package net.remisan.base.app.config;

public class AppConfig {

    private String titlePrefix;
    private String titleSuffix;
    private String base;
    private String author;
    private String language;
    private String charset;
    private String robots;
    
    public AppConfig() {
        super();
    }
    
    public AppConfig(
        String base,
        String author,
        String language,
        String charset,
        String robots
    ) {
        super();
        this.setBase(base);
        this.setAuthor(author);
        this.setLanguage(language);
        this.setCharset(charset);
        this.setRobots(robots);
    }
    
    
    /**
     * @return the titlePrefix
     */
    public String getTitlePrefix() {
        return this.titlePrefix;
    }

    /**
     * @return the titleSuffix
     */
    public String getTitleSuffix() {
        return this.titleSuffix;
    }

    /**
     * @param titlePrefix the titlePrefix to set
     */
    public void setTitlePrefix(String titlePrefix) {
        if (titlePrefix == null) {
            this.titlePrefix = "";
        }
        this.titlePrefix = titlePrefix.trim();
    }

    /**
     * @param titleSuffix the titleSuffix to set
     */
    public void setTitleSuffix(String titleSuffix) {
        if (titleSuffix == null) {
            this.titleSuffix = "";
        }
        this.titleSuffix = titleSuffix.trim();
    }

    /**
     * @return the base
     */
    public String getBase() {
        return this.base;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * @return the charset
     */
    public String getCharset() {
        return this.charset;
    }

    /**
     * @return the robots
     */
    public String getRobots() {
        return this.robots;
    }

    /**
     * @param base the base to set
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @param charset the charset to set
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * @param robots the robots to set
     */
    public void setRobots(String robots) {
        this.robots = robots;
    }
}
