package App.Game.Powerup;

/**
 * Enum created to set power properties. Can be modified for game balancing.
 * Created by Jerry Fan on 9/04/2017.
 */
public enum Power {
    HASTE(0, 5.0),
    INVISIBLITY(1, 2.0),
    BOUNTY(2, 0.0),
    DOUBLE_DAMAGE(3, 10.0);

    public int number;
    public double lifeSpan;

    Power(int i, double lifeSpan) {
        this.number = i;
        this.lifeSpan = lifeSpan;
    }
}
