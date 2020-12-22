package top.jiangyixin.gaea.core.proxy;

import java.net.Proxy;
import java.util.Random;

/**
 * 代理工厂类 随机选择一个代理
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 上午11:58
 */
public class RandomProxyFactory extends AbstractProxyFactory {
	
	private final Random random = new Random();
	
	@Override
	public Proxy get() {
		if (proxies == null || proxies.isEmpty()) {
			return null;
		}
		if (proxies.size() == 1) {
			return proxies.get(0);
		}
		return proxies.get(random.nextInt(proxies.size()));
	}
}
