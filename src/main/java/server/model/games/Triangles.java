
package server.model.games;

public class Triangles {
    private static String symb;
    private final static int N=7;
    
    public static void square()
    {   for (int i = 0; i < N; i++,System.out.println())
        {   for (int j = 0; j < N; j++)
            {   System.out.print( ((i==0)||(i==N-1)||(j==0)||(j==N-1) ) ? "* " : "  " );
            }
        }
    }
    
    public static void triangleLeftDown()
    {   for (int i = 0; i < N; i++,System.out.println())
        {   for (int j = 0; j < N; j++)
            {   System.out.print( ((j==0)||(i==N-1)||(j==i) ) ? "*" : " " );
            }
        }
    }
    
    public static void triangleRightUp()
    {   for (int i = 0; i < N; i++,System.out.println())
        {   for (int j = 0; j < N; j++)
            {   System.out.print( ((i==0)||(j==N-1)||(j==i) ) ? "* " : "  " );
            }
        }
    }
    
    public static void triangleRightDown()
    {   for (int i = 0; i < N; i++,System.out.println())
        {   for (int j = 0; j < N; j++)
            {   System.out.print(((i==N-1)||(j==N-1)||(i==N-1-j) ) ? "* " : "  ");
            }
        }
    }
    public static void triangleLeftUp()
    {   for (int i = 0; i < N; i++,System.out.println())
        {   for (int j = 0; j < N; j++)
            {   System.out.print(((i==0)||(j==0)||(i==N-1-j) ) ? "* " : "  ");
            }
        }
    }

    public static void main(String[] args) {
        Triangles.square();
        System.out.println("______________________________");
        Triangles.triangleLeftDown();
        System.out.println("______________________________");
        Triangles.triangleRightUp();
        System.out.println("______________________________");
        Triangles.triangleRightDown();
        System.out.println("______________________________");
        Triangles.triangleLeftUp();
        System.out.println("______________________________");
    }
}
