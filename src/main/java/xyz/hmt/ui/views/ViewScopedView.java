package xyz.hmt.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.hmt.ui.Greeter;

import javax.annotation.PostConstruct;

/**
 * Created by hmtma on 10/29/2016.
 */
@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "view";

    @Autowired
    private ViewGreeter viewGreeter;

    @Autowired
    private Greeter greeter;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("This is a view scoped view"));
        addComponent(new Label(greeter.sayHello()));
        addComponent(new Label(viewGreeter.sayHello()));
    }
}
