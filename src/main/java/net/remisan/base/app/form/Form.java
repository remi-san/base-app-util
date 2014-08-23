package net.remisan.base.app.form;

public interface Form<T> {
    
    boolean supports(Class<?> clazz);
    
    void updateObject(T object);
    
    void populate(T object);
}
