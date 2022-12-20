
package etc;

public class Computer {
    public static double div(int x, int y) throws Exception {
        if (y==0) {
            throw new Exception();
        }
        else return x/y;
    }
}