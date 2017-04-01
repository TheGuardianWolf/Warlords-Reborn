package App.Game.Fort.Warlord;

import java.awt.*;

/**
 * Created by pie on 30/03/17.
 */
public class WarlordService {
    private Dimension size;
    private Point.Double position;

    public WarlordService() {
        this.position = new Point.Double(0, 0);
        this.size = new Dimension(50,50);
    }

    public Point.Double getPosition() {
        return this.position;
    }

    public Dimension getSize(){
        return this.size;
    }
}

