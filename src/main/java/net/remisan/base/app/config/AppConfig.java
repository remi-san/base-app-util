package net.remisan.base.app.config;

/**
 * The AppConfig class is aimed at keeping the default configuration for the
 * application (which will be usefull to build the {@link PageConfig}
 * configuration.
 * 
 * @author Remi San<remi.san@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public class AppConfig {

    /**
     * The prefix for the page title
     */
    private String titlePrefix;

    /**
     * The suffix for the page title
     */
    private String titleSuffix;

    /**
     * The base URL (I guess, I can't remember)
     */
    private String base;

    /**
     * The author of the website (can be overridden by the {@link PageConfig}
     * attribute)
     */
    private String author;

    /**
     * The language for the website (iso2 or iso2-ISO2 format)
     */
    private String language;

    /**
     * The charset for the website (can't be overridden)
     */
    private String charset;

    /**
     * The default robots configuration (ie. index,follow)
     */
    private String robots;

    /**
     * Empty constructor (sets and does nothing)
     */
    public AppConfig() {
        super();
    }

    /**
     * Complete constructor
     * Parameters are set using the setters
     * 
     * @param base     The base URL
     * @param author   The author
     * @param language The language (iso2)
     * @param charset  The charset
     * @param robots   The robots configuration
     */
    public AppConfig(String base, String author, String language,
            String charset, String robots) {
        super();
        this.setBase(base);
        this.setAuthor(author);
        this.setLanguage(language);
        this.setCharset(charset);
        this.setRobots(robots);
    }

    /**
     * Getter for the member variable <strong>titlePrefix</strong>
     *
     * @return the titlePrefix
     */
    public String getTitlePrefix() {
        return this.titlePrefix;
    }

    /**
     * Getter for the member variable <strong>titleSuffix</strong>
     *
     * @return the titleSuffix
     */
    public String getTitleSuffix() {
        return this.titleSuffix;
    }

    /**
     * Getter for the member variable <strong>base</strong>
     *
     * @return the base
     */
    public String getBase() {
        return this.base;
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
     * Getter for the member variable <strong>language</strong>
     *
     * @return the language
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Getter for the member variable <strong>charset</strong>
     *
     * @return the charset
     */
    public String getCharset() {
        return this.charset;
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
     * Setter for the member variable <strong>titlePrefix</strong>
     *
     * @param titlePrefix the titlePrefix to set
     */
    public void setTitlePrefix(String titlePrefix) {
        if (titlePrefix == null) {
            this.titlePrefix = "";
        }
        this.titlePrefix = titlePrefix.trim();
    }

    /**
     * Setter for the member variable <strong>titleSuffix</strong>
     *
     * @param titleSuffix the titleSuffix to set
     */
    public void setTitleSuffix(String titleSuffix) {
        if (titleSuffix == null) {
            this.titleSuffix = "";
        }
        this.titleSuffix = titleSuffix.trim();
    }

    /**
     * Setter for the member variable <strong>base</strong>
     *
     * @param base the base to set
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Setter for the member variable <strong>author</strong>
     *
     * @param author  the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Setter for the member variable <strong>language</strong>
     *
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Setter for the member variable <strong>charset</strong>
     *
     * @param charset the charset to set
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * Setter for the member variable <strong>robots</strong>
     *
     * @param robots the robots to set
     */
    public void setRobots(String robots) {
        this.robots = robots;
    }
}
