package net.remisan.base.app.form;

import net.remisan.base.model.PersistableEntity;


public abstract class AbstractPersistableEntityForm<T extends PersistableEntity>
    extends AbstractForm<T>
    implements PersistableEntityForm<T> {

    protected Long id;
    
    public AbstractPersistableEntityForm(Class<? extends T> typeParameterClass) {
        super(typeParameterClass);
    }
    
    @Override
    public Long getId() {
        return this.id;
    }
}
