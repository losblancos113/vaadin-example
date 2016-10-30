package xyz.hmt.ui;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

/**
 * Created by hmtma on 10/29/2016.
 */

@SpringComponent
@UIScope
public class Greeter {
    public String sayHello(){
        return "Hello from bean: "+toString();
    }
}
