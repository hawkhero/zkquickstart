package quickstart.nav;

public class TabState implements Cloneable {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
