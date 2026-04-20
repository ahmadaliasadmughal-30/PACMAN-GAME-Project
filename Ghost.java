import java.util.Random;

class Ghost 
{
    private Position p;
    private Map m;
    private Random r;
    public Ghost(Position startPos, Map m) 
    {
        this.p = startPos;
        this.m = m;
        this.r = new Random();
    }
    public void moveRandom() 
    {
        int nx = p.getX();
        int ny = p.getY();
        int dir = r.nextInt(4);
        if (dir == 0) 
            ny--;      
        else if (dir == 1) 
            ny++; 
        else if (dir == 2) 
            nx--; 
        else 
            nx++;               
        if (!m.isWall(nx, ny))
        {
            p.setPosition(nx, ny);
        }
    }
    public Position getPosition()
    {
        return p;
    }
    public void resetPosition()
    {
        p.setPosition(5, 3);
    }
}