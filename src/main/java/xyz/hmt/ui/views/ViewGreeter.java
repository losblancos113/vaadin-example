package xyz.hmt.ui.views;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

/**
 * Created by hmtma on 10/29/2016.
 */
@SpringComponent
@ViewScope
public class ViewGreeter {
    public String sayHello() {
        return "Hello from a view scoped bean " + toString();
    }
}
