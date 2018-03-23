import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import sun.misc.ProxyGenerator;
public class ProxyTest {

	public static void main(String[] args) {

		Man man = new Rainyn();
		ManHandler manHandler = new ManHandler(man);
//		Man proxyMan = (Man) Proxy.newProxyInstance(man.getClass().getClassLoader(),new Class[] { Man.class }, manHandler);
		System.out.println(Rainyn.class.getInterfaces()[0]);
		Man proxyMan = (Man) Proxy.newProxyInstance(man.getClass().getClassLoader(),Rainyn.class.getInterfaces(), manHandler);
		System.out.println(proxyMan.getClass().getName());
		proxyMan.findObject();
		createProxyClassFile(Man.class);
	}
	
	
	
	private static void  createProxyClassFile(Class c) {
		
		byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[] {c});
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("$Proxy0.class");

			try {
				fileOutputStream.write(data);
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
