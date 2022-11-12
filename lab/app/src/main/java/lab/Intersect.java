package lab;

public class Intersect {

    // public static double [] intersect(int[] line1, int[] line2) throws Exception {

    //     double r =0;
    //     if (line1.length != 3 || line2.length != 3) {
    //         throw new Exception("Wrong formula");
    //     }

        // int a1 = line1[0], b1=line1[1], c1=line1[2];
        // int a2 = line2[0], b2=line2[1], c2=line2[2];
        // double slope1, slope2;
        // if (b1 != 0) slope1 = a1/b1;
        // if (b2 != 0) slope2 = a2/b2;
        
        
        // if (a1==0) {
        //     if (a2==0);
        // }
        // int lcm = getLCM(a1, a2);
        // int rate = lcm/a1;

        // int b1 = rate * line1[1];
        // int b2 = rate * line2[1];

        // int c1 = rate * line1[2];
        // int c2 = rate * line2[2];

        // double cor_y = (c1-c2)/(b1-b2);
        // double cor_x = (c1 - b1*cor_y)/(a1*rate);
        // double[] r = {cor_x, cor_y};
    //     return r;       
    // }

    public static int getLCM(int x, int y) {
        int max = x>y ? x : y;
        int r=1;
        for (int i=max; i <= x*y; i++) {
            System.out.println(i);
            if (i%x==0 && i%y==0) {
                r = i;
                break;
            }
        }
        return r;
    }
}