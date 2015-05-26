import java.util.Random;
public class Maxit {
    private int[][] maxit,sorted;
    private int lastLine,lastColumn,size;
    public Maxit(int size)
    {
        this.size=size;
        generate();
        sorted=sortMaxit(maxit).clone();
        lastColumn=0;
        lastLine=0;
    }
    private void generate()
    {
        Random random=new Random();
        maxit=new int[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                maxit [i][j]=random.nextInt()%20;
            }
        }
    }
    private int[][] sortMaxit(int[][]matrix)
    {
        int[][]result=new int[size][size];
        int[]temp=new int[size];
        for(int i=0;i<size;i++)
        {
            for (int j=0;j<size;j++)
            {
                temp[j]=matrix[j][i];
            }
            temp=sort(temp).clone();
            for(int j=0;j<size;j++)
            {
                result[j][i]=temp[j];
            }
        }
        return result;
    }
    private int[] sort(int[]array)
    {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        return array;
    }
    public void printMaxit()
    {
        for (int i=0;i<size;i++)
        {
            for (int j=0;j<size;j++)
            {
                if(maxit[i][j]==-100)
                {
                    System.out.print("*\t");
                }
                else
                    System.out.print(maxit[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public int move(int column,int line)
    {
        int result;
        int[]tmp=new int[size];
        lastColumn=column;
        lastLine=line;
        result=maxit[column][line];
        maxit[column][line]=-100;
        for(int i=0;i<size;i++)
        {
            tmp[i]=sorted[i][line];
        }
        tmp=sort(tmp).clone();
        for(int i=0;i<size;i++)
        {
            sorted[i][line] = tmp[i];
        }
        return result;
    }
    public int getLastLine()
    {
        return lastLine+1;
    }
    public int getLastColumn()
    {
        return lastColumn+1;
    }
    public int computerMove()
    {
        int min=100;
        int index=-1;
        int[]tmp=maxit[lastColumn].clone();
        for(int i=0;i<size;i++)
        {
            if(tmp[i]!=-100)
            {
                if(sorted[size-1][i]<min)
                {
                    min=sorted[size-1][i];
                    index=i;
                }
                else if(sorted[size-1][i]==min)
                {
                    int a=1;
                while (sorted[size-a][i]==min)
                {
                    a++;
                }
                    if(sorted[size-a][i]<min)
                    {
                        min=sorted[size-a][i];
                        index=i;
                    }
                }
            }
        }
        return move(lastColumn, index);
    }
    public boolean isPlayable()
    {
        for(int i=0;i<size;i++)
        {
            if(maxit[i][lastLine]!=-100)
            {
                return true;
            }
        }
        return false;
    }
}