package xyz.hmt.ui;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import xyz.hmt.ui.views.HomeView;
import xyz.hmt.ui.views.UIScopedView;
import xyz.hmt.ui.views.ViewScopedView;

public enum DashboardViewType {
    DASHBOARD("dashboard", HomeView.class, FontAwesome.HOME, true), SALES(
            "sales", UIScopedView.class, FontAwesome.BAR_CHART_O, false), TRANSACTIONS(
            "transactions", ViewScopedView.class, FontAwesome.TABLE, false),
    REPORTS(
            "reports", HomeView.class, FontAwesome.FILE_TEXT_O, true);
//    , SCHEDULE(
//            "schedule", ScheduleView.class, FontAwesome.CALENDAR_O, false);

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;

    private DashboardViewType(final String viewName,
                              final Class<? extends View> viewClass, final Resource icon,
                              final boolean stateful) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }

    public boolean isStateful() {
        return stateful;
    }

    public String getViewName() {
        return viewName;
    }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }

    public static DashboardViewType getByViewName(final String viewName) {
        DashboardViewType result = null;
        for (DashboardViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

}
