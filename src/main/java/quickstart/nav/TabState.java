package quickstart.nav;

public class TabState {
    private String iconClass;
    private String name;

    public TabState( String name, String iconClass) {
        this.iconClass = iconClass;
        this.name = name;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
