package net.remisan.base.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.Formatter;

public class SortFormatter implements Formatter<Sort> {

    @Override
    public String print(Sort object, Locale locale) {
        for (Sort.Order order : object) {
            return order.getProperty() + "," + order.getDirection();
        }
        return null;
    }

    @Override
    public Sort parse(String text, Locale locale) throws ParseException {
        
        Direction direction = Direction.ASC;
        String property = "id";
        
        String[] orders = text.split(",");
        
        if (orders.length > 0) {
            property = orders[0];
            
            if (
                orders.length > 1
                    && ("asc".equals(orders[1].toLowerCase()) || "desc".equals(orders[1].toLowerCase()))
            ) {
                direction = Direction.fromString(orders[1]);
            }
        }
        
        Sort.Order order = new Sort.Order(direction, property);
        Sort sort = new Sort(order);
        
        return sort;
    }

}
