import java.util.Scanner;
public class Game {
    public static void main(String [] args)
    {
        Scanner input=new Scanner(System.in);
        int move;
        System.out.println("Enter name :");
        Player p=new Player(input.next());
        Player pc=new Player("Computer");
        System.out.println("Enter size of maxit :");
        Maxit maxit=new Maxit(input.nextInt());
        while (Player.getLoop()&&maxit.isPlayable())
        {
            maxit.printMaxit();
            System.out.println("Last column :" + maxit.getLastColumn() + "\tLast line :" + maxit.getLastLine());
            move=input.nextInt();
            p.increase(maxit.move(move-1,maxit.getLastLine()-1));
            pc.increase(maxit.computerMove());
            System.out.println(p.getName()+"'s score :"+p.getScore());
            System.out.println(pc.getName()+"'s score :"+pc.getScore());

        }
        maxit.printMaxit();
        if(p.getScore()>pc.getScore())
        {
            System.out.println(p.getName()+"WON!");
        }
        else if(p.getScore()==pc.getScore())
        {
            System.out.println("Draws");
        }
        else
            System.out.println(pc.getName()+"WON!");
    }
}
