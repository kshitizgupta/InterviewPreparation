package machineCoding.bookmyshow.models;

import java.util.List;

public class Theatre {
    private final int id;
    private final List<Screen> screens;

    public Theatre(final int id, final List<Screen> screens) {
        this.id = id;
        this.screens = screens;
    }

    public int getId() {
        return id;
    }

    public List<Screen> getScreens() {
        return List.copyOf(screens);
    }

    public Screen getScreen(final int screenId) {
        for(Screen screen: screens) {
            if(screen.getId() == screenId) {
                return screen;
            }
        }
        throw new IllegalArgumentException("illegal screen id");
    }
}
