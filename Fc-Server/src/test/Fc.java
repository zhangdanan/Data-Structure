package test;

import javax.ejb.Remote;

/**
 * @author wangqianlong
 * @create 2019-11-18 18:02
 */
@Remote
public interface Fc {

    double[] equation(int a, int b, int c);

}
