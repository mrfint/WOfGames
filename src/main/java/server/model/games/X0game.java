
package server.model.games;


public class X0game extends Game{
    private final int n = 3;
    private int[][] a = new int[n][n];

    private int x, y;
    private boolean fWin = false;
    

    @Override
    void control() {
        parse(getInLine());
        a[x][y] = current+1; // x or o = 1 or 2
        
        // control of win
        for (int i = 0; i < n; i++) {
            int s1 = 0;     int s2 = 0;
            int s3 = 0;     int s4 = 0;
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
 
    }

    @Override
    void send() {
//        for (int i = 0; i < lst.size(); i++) {
//            if(i!=current) lst.get(i).send("next: "+x+","+y);
//        }
//        if(fWin){
//            for (int i = 0; i < lst.size(); i++) {
//                lst.get(i).send("Winner: "+lst.get(current).getName());
//        }
//        }
    }

    private void parse(String inLine) {
        
        String args = inLine.substring(inLine.indexOf(':')+1).trim();
        String[] q = args.split(",");
        
        x = Integer.parseInt(q[0].trim());
        y = Integer.parseInt(q[1].trim());
    }
    
}
