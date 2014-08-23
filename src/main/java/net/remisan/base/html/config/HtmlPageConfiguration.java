package net.remisan.base.html.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.remisan.base.html.HtmlLink;
import net.remisan.base.html.HtmlMeta;
import net.remisan.base.html.HtmlScript;

import com.google.common.net.MediaType;

public class HtmlPageConfiguration {

    private String title;
    
    private String base;
    
    private String language;
    
    private Map<String, HtmlMeta> metas;
    
    private List<HtmlLink> links;
    
    private List<HtmlScript> scripts;

    public HtmlPageConfiguration() {
        super();
        this.metas = new HashMap<String, HtmlMeta>();
        this.links = new ArrayList<HtmlLink>();
        this.scripts = new ArrayList<HtmlScript>();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.addMeta(HtmlMeta.createMetaProperty(HtmlMeta.OPENGRAPH_TITLE, title));
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLanguage() {
        return this.language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
        this.addMeta(HtmlMeta.createMetaName(HtmlMeta.LANGUAGE, language));
    }
    

    public Map<String, HtmlMeta> getMetas() {
        return this.metas;
    }
    
    public void addMeta(HtmlMeta meta) {
        if (meta.isValid()) {
            this.metas.put(meta.getKey(), meta);
        }
    }

    
    public List<HtmlLink> getLinks() {
        return this.links;
    }
    
    public void addLink(HtmlLink link) {
        if (link.isValid()) {
            this.links.add(link);
        }
    }
    

    public List<HtmlScript> getScripts() {
        return this.scripts;
    }
    
    public void addScript(HtmlScript script) {
        if (!script.isValid()) {
            this.scripts.add(script);
        }
    }
    
    
    
    public void setDescription(String description) {
        this.addMeta(HtmlMeta.createMetaName(HtmlMeta.DESCRIPTION, description));
        this.addMeta(HtmlMeta.createMetaProperty(HtmlMeta.OPENGRAPH_DESCRIPTION, description));
    }
    
    public void setUrl(String url) {
        this.addMeta(HtmlMeta.createMetaProperty(HtmlMeta.OPENGRAPH_URL, url));
    }
    
    public void setCharset(String charset) {
        this.addMeta(HtmlMeta.createMetaCharset(charset));
    }
    
    public void setKeywords(String keywords) {
        this.addMeta(HtmlMeta.createMetaName(HtmlMeta.KEYWORDS, keywords));
    }
    
    public void setRobotsConfiguration(String robots) {
        this.addMeta(HtmlMeta.createMetaName(HtmlMeta.ROBOTS, robots));
    }
    
    public void setAuthor(String author) {
        this.addLink(new HtmlLink(author, null, HtmlLink.REL_AUTHOR, null));
    }
    
    
    
    public void addJavaScript(String script) {
        this.addScript(new HtmlScript(MediaType.JAVASCRIPT_UTF_8, script));
    }
    
    public void addStyleSheet(String css, String media) {
        this.addLink(new HtmlLink(css, MediaType.CSS_UTF_8, HtmlLink.REL_STYLESHEET, media));
    }
}
