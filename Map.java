 public class Map
 {
    private char[][] m;
    private int r;
    private int c;
    public Map()
    {
        r = 9;
        c = 12;
        m = new char[][]
                {
                        {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','.','.','.','#','.','.','.','.','.','.','#'},
                        {'#','.','#','.','#','.','#','#','.','#','.','#'},
                        {'#','.','#','.','.','.','.','#','.','#','.','#'},
                        {'#','.','#','#','#','.','#','#','.','#','.','#'},
                        {'#','.','.','.','.','.','#','.','.','.','.','#'},
                        {'#','.','#','#','#','#','#','#','#','#','.','#'},
                        {'#','.','.','.','.','.','.','.','.','.','.','#'},
                        {'#','#','#','#','#','#','#','#','#','#','#','#'}
                };
    }
    public void printMap(Position pacPos, Position[] ghostPos) {
        System.out.println("\n========== PAC-MAN ==========");
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                Position current = new Position(j, i);
                if (current.equals(pacPos))
                {
                    System.out.print("P ");
                }
                else
                {
                    boolean ghostHere = false;
                    for (Position g : ghostPos)
                    {
                        if (current.equals(g))
                        {
                            System.out.print("G ");
                            ghostHere = true;
                            break;
                        }
                    }
                    if (!ghostHere)
                    {
                        System.out.print(m[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    public boolean isWall(int x, int y)
    {
        if (x < 0 || x >= c || y < 0 || y >= r)
            return true;
        return m[y][x] == '#';
    }
    public boolean hasDot(int x, int y)
    {
        return m[y][x] == '.';
    }
    public void eatDot(int x, int y)
    {
        if (m[y][x] == '.')
        {
            m[y][x] = ' ';
        }
    }
    public boolean allDotsEaten()
    {
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (m[i][j] == '.')
                    return false;
            }
        }
        return true;
    }
}