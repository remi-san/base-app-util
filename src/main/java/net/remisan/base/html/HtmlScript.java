package net.remisan.base.html;

import com.google.common.net.MediaType;

public class HtmlScript {
    
    private MediaType type;
    
    private String src;
    
    public HtmlScript() {
        super();
    }
    
    public HtmlScript(String src) {
        super();
        this.src = src;
    }

    public HtmlScript(MediaType type, String src) {
        super();
        this.type = type;
        this.src = src;
    }

    public MediaType getType() {
        return this.type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getSrc() {
        return this.src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
    
    /**
     * Checks the validity of the Link
     * 
     * @return true if href is set
     */
    public boolean isValid() {
        return this.src != null;
    }
}
