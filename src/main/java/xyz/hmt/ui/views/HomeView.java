package xyz.hmt.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by hmtma on 10/29/2016.
 */
@SpringView(name = HomeView.VIEW_NAME)
public class HomeView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @PostConstruct
    void init() {
//        setSizeFull();
//        setWidth(80, Unit.PERCENTAGE);
        addComponent(new Label("This is the default view"));
    }
}
