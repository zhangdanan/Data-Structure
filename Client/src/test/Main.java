package test; /**
 * @author wangqianlong
 * @create 2019-11-18 18:08
 */


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Hashtable <String, String> jndiProperties = new Hashtable <>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        try {
            final Context context = new InitialContext(jndiProperties);
            Fc fc = (Fc) context.lookup("ejb:/Fc_Ser_war_exploded/FcEJB!test.Fc");

            Scanner in = new Scanner(System.in);//创建scanner，控制台会一直等待输入，直到敲回车结束
            System.out.print("请输入a的值：");//输出“提示”
            int a = in.nextInt();//用户可自行定义a的值
            System.out.print("请输入b的值：");//输出“提示”
            int b = in.nextInt();//用户可自行定义b的值
            System.out.print("请输入c的值：");//输出“提示”
            int c = in.nextInt();//用户可自行定义c的值
            double[] result = fc.equation(a, b, c);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}

