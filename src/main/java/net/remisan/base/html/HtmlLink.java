package net.remisan.base.html;

import com.google.common.net.MediaType;

public class HtmlLink {

    public static final String REL_STYLESHEET = "stylesheet";
    public static final String REL_CANONICAL = "canonical";
    public static final String REL_ALTERNATE = "alternate";
    public static final String REL_AUTHOR = "author";
    public static final String REL_PUBLISHER = "publisher";
    public static final String REL_FAVICON = "shortcut icon";
    public static final String REL_APPLE_ICON = "apple-touch-icon-precomposed";
    
    public static final String MEDIA_ALL = "all";
    public static final String MEDIA_AURAL = "aural";
    public static final String MEDIA_VRAILLE = "braille";
    public static final String MEDIA_HANDHELD = "handheld";
    public static final String MEDIA_PROJECTION = "projection";
    public static final String MEDIA_PRINT = "print";
    public static final String MEDIA_SCREEN = "screen";
    public static final String MEDIA_TTY = "tty";
    public static final String MEDIA_TV = "tv";
    
    private String href;
    
    private MediaType type;
    
    private String rel;
    
    private String media;
    
    public HtmlLink() {
        super();
    }
    
    public HtmlLink(String href) {
        super();
        this.href = href;
    }

    public HtmlLink(String href, MediaType type, String rel, String media) {
        super();
        this.href = href;
        this.type = type;
        this.rel = rel;
        this.media = media;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public MediaType getType() {
        return this.type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getRel() {
        return this.rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getMedia() {
        return this.media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
    
    /**
     * Checks the validity of the Link
     * 
     * @return true if href is set
     */
    public boolean isValid() {
        return this.href != null;
    }
}
