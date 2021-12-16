package test;

import javax.ejb.Remote;

@javax.ejb.Stateless(name = "FcEJB")
@Remote
public class FcBean implements Fc {
    public FcBean() {
    }


    @Override
    public double[] equation(int a, int b, int c) {

        System.out.println("####王乾龙####" + a + "*x^2+" + b + "*x-" + c + "=0");

        double x1 = ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));//运用求根公式，并且Math.sqrt()为开平方根
        double x2 = ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));//运用求根公式，并且Math.sqrt()为开平方根

        double[] result = {x1, x2};
        return result;

    }
}
