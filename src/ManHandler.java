import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 业务处理类
* 创建人：yf-yuanjingkun   
* 创建时间：2018年3月20日 上午11:31:06   
 */
public class ManHandler implements InvocationHandler{

	private Man man;
	
	public ManHandler (Man man) {
		this.man = man;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		method.invoke(man, null);
		after();
		return null;
	}

	/*
	*前置
	 */
	public void before() {
		System.out.println("Beforing finding you, I will try my best to improve myself!");
	}
	
	
	/*
	*后置
	 */
	public void after() {
		System.out.println("After finding you, I will love you forever!");
	}
}
