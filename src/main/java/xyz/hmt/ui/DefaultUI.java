package xyz.hmt.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.hmt.ui.views.UIScopedView;
import xyz.hmt.ui.views.ViewScopedView;

/**
 * Created by hmtma on 10/29/2016.
 */
@Theme("valo")
@SpringUI
public class DefaultUI extends UI {

    @Autowired
    private Greeter greeter;

    // we can use either constructor autowiring or field autowiring
    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        addStyleName(ValoTheme.UI_WITH_MENU);
        final HorizontalLayout root = new HorizontalLayout();
        root.setSizeFull();
//        root.setMargin(true);
//        root.setSpacing(true);
        Responsive.makeResponsive(root);
        setContent(root);
//        hozi.setWidth(100, Unit.PERCENTAGE);
//        hozi.setHeight(100, Unit.PERCENTAGE);
//        hozi.setSizeFull();
//        final CssLayout navigationBar = new CssLayout();
//        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
//        navigationBar.addComponent(createNavigationButton("UI Scoped View",
//                UIScopedView.VIEW_NAME));
//        navigationBar.addComponent(createNavigationButton("View Scoped View",
//                ViewScopedView.VIEW_NAME));
//        root.addComponent(navigationBar);
//        menuPanel.
        Panel menuPanel = new Panel();
//        menuPanel.setSizeFull();
//        menuPanel.setWidth(20, Unit.PERCENTAGE);
        menuPanel.setHeight(100, Unit.PERCENTAGE);
//        Accordion accordion = getAccordion("Borderless");
//        accordion.setWidth(100,Unit.PERCENTAGE);
//        accordion.setHeight(100, Unit.PERCENTAGE);
//        accordion.addStyleName(ValoTheme.ACCORDION_BORDERLESS);
//        accordion.setVisible(true);
//        accordion.setResponsive(true);
//        menuPanel.setContent(accordion);
        menuPanel.setContent(new DashboardMenu());
        root.addComponent(menuPanel);
        root.setExpandRatio(menuPanel, 1.25f);
        final Panel viewContainer = new Panel();
//        viewContainer.setSizeFull();
//        viewContainer.setWidth(80, Unit.PERCENTAGE);
        viewContainer.setHeight(100, Unit.PERCENTAGE);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        root.addComponent(viewContainer);
        root.setResponsive(true);
        root.setExpandRatio(viewContainer, 8.75f);
    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this to an anonymous listener class
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }

    private Accordion getAccordion(String caption) {
        Accordion ac = new Accordion();
        ac.setCaption(caption);
        ac.addTab(new VerticalLayout() {
            {
                setMargin(true);
                addComponent(new Label(
                        "Fabio vel iudice vincam, sunt in culpa qui officia. Ut enim ad minim veniam, quis nostrud exercitation."));
            }
        }, "First Caption", FontAwesome.AMAZON);
        ac.addTab(new VerticalLayout() {
            {
                setMargin(true);
                addComponent(new Label(
                        "Gallia est omnis divisa in partes tres, quarum."));
            }
        }, "Second Caption", FontAwesome.APPLE);
        ac.addTab(new VerticalLayout() {
            {
                setMargin(true);
                addComponent(new Label(
                        "Nihil hic munitissimus habendi senatus locus, nihil horum? Sed haec quis possit intrepidus aestimare tellus."));
            }
        }, "Third Caption", FontAwesome.AMBULANCE);
        return ac;
    }
}
