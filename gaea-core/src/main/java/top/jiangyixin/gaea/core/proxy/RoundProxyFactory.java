package top.jiangyixin.gaea.core.proxy;

import java.net.Proxy;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 代理工厂类 轮询选择一个代理
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 下午1:45
 */
public class RoundProxyFactory extends AbstractProxyFactory {
	
	public final static int MAX = 100000;
	private final AtomicInteger count = new AtomicInteger(0);
	
	@Override
	public Proxy get() {
		if (proxies == null || proxies.isEmpty()) {
			return null;
		}
		if (proxies.size() == 1) {
			return proxies.get(0);
		}
		int index = count.getAndIncrement();
		if (index > MAX) {
			index = 0;
			count.set(index);
		}
		return proxies.get(index % proxies.size());
	}
}
