package App.Game;

import App.Game.Canvas.Fort.Wall.WallService;
import App.Game.Canvas.Fort.Warlord.WarlordService;
import App.Game.Canvas.Ball.BallService;
import App.Game.Canvas.Fort.Shield.ShieldComponent;
import App.Game.Canvas.Fort.Shield.ShieldService;
import App.Game.Timer.TimerService;

import java.awt.*;

/**
 * Created by lichk on 27/03/2017.
 */
public class GameService {
    private Boolean started;
    private Boolean finished;
    private Long timeLimitMs;

    TimerService timer;
    BallService ball;
    WallService wall;
    WarlordService warlord;
    ShieldService shield;
//    List<Player> players;


    public GameService() {
        this.timer = new TimerService();
        this.ball = new BallService();
        this.wall = new WallService();
        this.warlord = new WarlordService();
        this.shield = new ShieldService();

        this.started = false;
        this.finished = false;
        this.timeLimitMs = 0L;
    }

    public WarlordService getWarlord(){
        return this.warlord;
    }

    public WallService getWall(){
        return this.wall;
    }

    public TimerService getTimer() {
        return this.timer;
    }

    public BallService getBall() {
        return this.ball;

    }

    public ShieldService getShield() {
        return this.shield;
    }

    public Boolean getStarted() {
        return this.started;
    }

//    public List<Player> getPlayers() {
//        return this.players;
//    }

    public void setStarted(Boolean value) {
            this.started = started;
        if (!value.equals(this.started)) {
        }
    }

    public Boolean getFinished() {
        return this.finished;
    }

    public void setFinished(Boolean value) {
        if (!value.equals(this.finished)) {
            this.finished = finished;
        }
    }

    public Long getTimeLimitMs() {
        return this.timeLimitMs;
    }

    public void setTimeLimitMs(Long value) {
        if (!value.equals(this.timeLimitMs)) {
            this.timeLimitMs = value;
        }
    }
}
