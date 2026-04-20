public class Position
{
    private int x;
    private int y;
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Position other)
    {
        return this.x == other.getX() && this.y == other.getY();
    }
}