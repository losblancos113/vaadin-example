package xyz.hmt.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.hmt.ui.Greeter;

import javax.annotation.PostConstruct;

/**
 * Created by hmtma on 10/29/2016.
 */
@UIScope
@SpringView(name = UIScopedView.VIEW_NAME)
public class UIScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "ui";
    @Autowired
    private Greeter greeter;
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("This is a UI scoped view. Greeter says: " + greeter.sayHello()));
    }
}
