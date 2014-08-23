package net.remisan.base.app.form;

import org.springframework.beans.BeanUtils;

public abstract class AbstractForm<T> implements Form<T> {
    
    protected Class<? extends T> typeParameterClass;
    
    public AbstractForm(Class<? extends T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }
    
    @Override
    public boolean supports(Class<?> clazz) {
        return this.typeParameterClass.isAssignableFrom(clazz);
    }

    @Override
    public void updateObject(T object) {
        if (!this.supports(object.getClass())) {
            throw new IllegalArgumentException("Can't update the object passed in parameter.");
        }
        
        this.copyPropertiesTo(object);
    }
    
    @Override
    public void populate(T object) {
        if (!this.supports(object.getClass())) {
            throw new IllegalArgumentException("Can't populate from the object passed in parameter.");
        }
        
        this.copyPropertiesFrom(object);
    }
    
    protected void copyPropertiesTo(T target) {
        BeanUtils.copyProperties(this, target);
    }
    
    protected void copyPropertiesFrom(T source) {
        BeanUtils.copyProperties(source, this);
    }

}
