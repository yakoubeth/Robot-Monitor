public class RobotMonitor
{
    // constants
    public static final int MAX = 6;
    public static final int MIN = 1;

    // state attributes
    private Integer row;
    private Integer col;
    private Move move;

    // invariant
    public boolean inv()
    {
        return (row == null || InRange(row))
        && (col == null || InRange(col))
        && (move == null || move == Move.LEFT || move == Move.RIGHT || move == Move.UP || move == Move.DOWN);
    }
        
    // initialisation
    public RobotMonitor()
    {
        row = 1;
        col = 1;
        move = null;
        if (!inv())
        {
            throw new VDMException
            ("invariant broken");
        }
    }

    // functions
    public boolean InRange(int num) {
        if (num >= MIN && num <= MAX) {
            return true;
        } else {
            return false;
        }
    }

    // operations

    public int GetCol()
    {
        return col;
    }
    public int GetRow()
    {
        return row;
    }
    public Move GetMove()
    {
        return move;
    }
    public void MoveRight()
    {
        if (col != null && col < MAX && move != Move.LEFT)
        {
            col++;
            move = Move.RIGHT;
        }
        else
        {
            throw new VDMException
            ("precondition broken");
        }
        if (!inv())
        {
            throw new VDMException
            ("invariant broken");
        }
    }
    public void MoveLeft()
    {
        if (col != null && col > MIN && move != Move.RIGHT)
        {
            col = col - 1;
            move = Move.LEFT;
        }
        else
        {
            throw new VDMException
            ("precondition broken");
        }
        if (!inv())
        {
            throw new VDMException
            ("invariant broken");
        }
    }
    public void MoveUp()
    {
        if (row != null && row > MIN && move != Move.DOWN)
        {
            row = row - 1;
            move = Move.UP;
        }
        else
        {
            throw new VDMException
            ("precondition broken");
        }
        if (!inv())
        {
            throw new VDMException
            ("invariant broken");
        }
    }
    public void MoveDown()
    {
        if (row != null && row < MAX && move != Move.UP)
        {
            row++;
            move = Move.DOWN;
        }
        else
        {
            throw new VDMException
            ("precondition broken");
        }
        if (!inv())
        {
            throw new VDMException
            ("invariant broken");
        }
    }
    public void Exit()
    {
        if (row == MAX && col == MAX)
        {
        row = 1;
        col = 1;
        move = null;
        } 
        else
        {
            throw new VDMException("precondition broken");
        }
        if (!inv())
        {
            throw new VDMException("invariant broken");
        }
    }
}