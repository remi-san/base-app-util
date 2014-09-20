package net.remisan.base.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Page;

@XmlRootElement
public class RestList<T> {

    protected List<T> elements;
    
    protected int page;

    protected int totalPages;

    protected long totalElements;

    public RestList() {
        this.elements = new ArrayList<T>();
        this.page = 1;
        this.totalPages = 1;
        this.totalElements = 0;
    }

    public RestList(List<T> elements, int page, int totalPages, long totalElements) {
        this.elements = elements;
        this.page = page;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
    
    public RestList(Page<T> page) {
        this.elements = page.getContent();
        this.page = page.getNumber();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }
    
    public List<T> getElements() {
        return this.elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public int getPage() {
        return this.page;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
