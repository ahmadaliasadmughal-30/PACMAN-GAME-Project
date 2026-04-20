class PacMan 
{
    private Position p;
    private Map m;
    private Score sc;
    public PacMan(Position startPos, Map m, Score sc) 
    {
        this.p = startPos;
        this.m = m;
        this.sc = sc;
    }
    public void move(String direction) 
    {
        int nx = p.getX();
        int ny = p.getY();
        direction = direction.toUpperCase().trim();
        if (direction.equals("W")) 
            ny--;        
        else if (direction.equals("S")) 
            ny++;   
        else if (direction.equals("A")) 
            nx--;   
        else if (direction.equals("D")) 
            nx++;   
        else 
            return;
        if (!m.isWall(nx, ny)) 
        {
            p.setPosition(nx, ny);
            if (m.hasDot(nx, ny)) 
            {
                m.eatDot(nx, ny);
                sc.addPoints(10);
            }
        }
    }
    public Position getPosition() 
    {
        return p;
    }
    public void resetPosition() 
    {
        p.setPosition(1, 1);   
    }
}