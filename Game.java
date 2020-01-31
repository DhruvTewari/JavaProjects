import java.util.Scanner;

public class Game {
    public static int arr[][] = new int[10][10];
    public static int check[][] = new int[10][10];
    static int x, y;

    public static void show() {
        System.out.println("   0 1 2 3 4 5 6 7 8 9 ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.print(" |" + i);

            System.out.println();
        }


        System.out.println("   0 1 2 3 4 5 6 7 8 9 ");
    }
    public static void moves() {
        System.out.println("   0 1 2 3 4 5 6 7 8 9 ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i+"|");
            for(int j=0;j<10;j++)
            {
                System.out.print(" "+check[i][j]);
            }
            System.out.print(" |"+i);
            System.out.println();
        }
        System.out.println("   0 1 2 3 4 5 6 7 8 9 ");
    }
    public static void player(int n)//n is the player number.
    {
        Scanner input = new Scanner(System.in);
        System.out.println("player "+ n +" has to deploy 5 ships,give the coordinates.");
        for(int i=1;i<=5;i++)
        {
            System.out.print("x coordinate of ship "+i+":\n");
            x = input.nextInt();
            System.out.print("y coordinate of ship "+i+":\n");
            y = input.nextInt();
            if(arr[x][y]==1||arr[x][y]==2)
            {
                System.out.println("invalid");
                System.out.println("enter again");
                System.out.print("x coordinate of ship "+i+":");
                x = input.nextInt();
                System.out.print("y coordinate of ship "+i+":");
                y = input.nextInt();
                arr[x][y]=n;
            }
            else
            {
                arr[x][y] = n;
            }

        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String args[])
    {
        System.out.println("welcome to the game of BATTLESHIP  ");
        show();
        clearScreen();
        player(1);
        player(2);
        int[] line = new int[2];
        line[0]=5;
        line[1]=5;
        Scanner input = new Scanner(System.in);
        //show();//to check output was correct
        System.out.println("attacks of player 1 will be denoted by 1 and for player 2 will be denoted by 2");
        System.out.println("if both players attack a point it will be denoted by 3");
        System.out.println("lets start the battle:");
        int flag=0;
        while(flag==0)
        {
            System.out.println("player 1 give the coordinates  you want attack");
            System.out.print("x coordinate:");
            x=input.nextInt();
            System.out.print("y coordinate:");
            y=input.nextInt();
            check[x][y]=1;
            if(arr[x][y]==2)
            {
                System.out.println("player 2 ship has been destroyed");
                line[1]=line[1]-1;
                arr[x][y]=0;
            }
            else
            {
                System.out.println("ships of player 2 have survived.");
            }
            System.out.println("player 2 give the coordinates  you want attack");
            System.out.print("x coordinate:");
            x=input.nextInt();
            System.out.print("y coordinate:");
            y=input.nextInt();
            if(check[x][y]==1)
            {
                check[x][y]=3;
            }
            else
            {
                check[x][y]=2;
            }
            if(arr[x][y]==1)
            {
                System.out.println("player 1 ship has been destroyed");
                line[0]=line[0]-1;
                arr[x][y]=0;
            }
            else
            {
                System.out.println(" ships of player 2 have survived.");
            }
            if(line[1]==0 || line[0]==0)
            {
                flag=1;
            }
            System.out.println("player 1 has "+line[0]+ " ships");
            System.out.println("player 2 has "+line[1]+ " ships");
            clearScreen();
            moves();
        }
        if(line[0]==0)
        {
            System.out.println("player 1 has won.");
        }
        else
        {
            System.out.println("player 2 has won.");
        }
    }
}
