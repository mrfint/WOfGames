
package server.model;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


public class TestFWIn {
    
    @Test
    public void testSomeMethod() {
        int n= 3;
        int[][] a;
        
        a = new int[][]{    {2,2,1},
                            {1,2,2},
                            {1,1,1}
                        };
        
        boolean fWin = false;
        int s3 = 0;     int s4 = 0;
        for (int i = 0; i < n; i++) {
            int s1 = 0;     int s2 = 0;
            
            for (int j = 0; j < n; j++) {
                s1+=a[i][j];
                s2+=a[j][i];
                if(i==n-1-j) s3+= a[i][j];
                if(i==j)     s4+= a[i][j];
            }
            if( s1==3 || s1==6 ||  s2==3 || s2==6 
              ||s3==3 || s3==6 ||  s4==3 || s4==6 ){
                fWin = true;
                break;
            }
            
        }
        assertTrue(fWin);
    }
        
    
}
