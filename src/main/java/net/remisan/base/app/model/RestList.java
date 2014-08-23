package net.remisan.base.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestList<T> {

    protected List<T> list;

    protected int page;

    protected int elementsPerPage;

    protected int totalElements;

    public RestList() {
        this.list = new ArrayList<T>();
        this.page = 1;
        this.elementsPerPage = 20;
        this.totalElements = 0;
    }

    public RestList(List<T> list, int page, int elementsPerPage,
            int totalElements) {
        this.list = list;
        this.page = page;
        this.elementsPerPage = elementsPerPage;
        this.totalElements = elementsPerPage;
    }

    public List<T> getList() {
        return this.list;
    }

    public int getPage() {
        return this.page;
    }

    public int getElementsPerPage() {
        return this.elementsPerPage;
    }

    public int getTotalElements() {
        return this.totalElements;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setElementsPerPage(int elementsPerPage) {
        this.elementsPerPage = elementsPerPage;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}
