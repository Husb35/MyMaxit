public class Player {
    private int score;
    private String name;
    private static boolean loop=true;
    public Player(String name)
    {
        this.name=name;
        score=0;
    }
    public void increase(int x)
    {
        if(x!=-100)
        {
            score+=x;
        }
        else loop=false;
    }
    public int getScore()
    {
        return score;
    }
    public String getName()
    {
        return name;
    }
    public static boolean getLoop()
    {
        return loop;
    }
}
