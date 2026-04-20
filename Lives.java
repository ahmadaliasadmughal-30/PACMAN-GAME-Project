 public class Lives
 {
    private int rLives;
    public Lives()
    {
        this.rLives = 3;
    }
    public void loseLife()
    {
        if (rLives > 0)
            rLives--;
    }
    public int getLives()
    {
        return rLives;
    }
    public boolean isGameOver()
    {
        return rLives <= 0;
    }
    public void reset()
    {
        rLives = 3;
    }
}