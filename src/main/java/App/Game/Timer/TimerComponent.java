package App.Game.Timer;

import App.Game.GameService;
import App.Shared.SharedModule;

/**
 * Created by lichk on 27/03/2017.
 */
public class TimerComponent {
    private SharedModule shared;
    private GameService game;

    /**
     * @param shared allows access to JFX scenes and the stage
     * @param game allows access to all other components
     */
    public TimerComponent(SharedModule shared, GameService game) {
        this.shared = shared;
        this.game = game;
        this.shared.getJFX().loadFXML(this, this.getClass(),
                "TimerComponent.fxml");
    }
}
