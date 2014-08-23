package net.remisan.base.html;

public class HtmlMeta {
    
    public static final String LANGUAGE = "language";
    public static final String DESCRIPTION = "description";
    public static final String KEYWORDS = "keywords";
    public static final String ROBOTS = "robots";
    
    public static final String OPENGRAPH_DESCRIPTION = "og:description";
    public static final String OPENGRAPH_TITLE = "og:title";
    public static final String OPENGRAPH_URL = "og:url";
    public static final String OPENGRAPH_IMAGE = "og:image";
    public static final String OPENGRAPH_TYPE = "og:type";
    
    private String name;
    
    private String property;
    
    private String charset;
    
    private String content;

    public HtmlMeta() {
        super();
    }
    
    public HtmlMeta(String charset) {
        super();
        this.charset = charset;
    }

    public HtmlMeta(String name, String property, String content) {
        super();
        this.name = name;
        this.property = property;
        this.content = content;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
    
    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * 
     * @return the key for the Meta
     */
    public String getKey() {
        if (this.property != null) {
            return this.property;
        }
        return this.name;
    }
    
    /**
     * Checks the validity of the Meta
     * 
     * @return true if name or property is set but not both and content is set too
     */
    public boolean isValid() {
        return
            this.charset != null
            || (
                this.content != null
                && (this.name != null || this.property != null)
                && !(this.name != null && this.property != null)
            );
    }
    
    public static HtmlMeta createMetaCharset(String charset) {
        return new HtmlMeta(charset);
    }
    
    public static HtmlMeta createMetaName(String name, String content) {
        return new HtmlMeta(name, null, content);
    }
    
    public static HtmlMeta createMetaProperty(String property, String content) {
        return new HtmlMeta(null, property, content);
    }
}
