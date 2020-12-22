package top.jiangyixin.gaea.core.proxy;

import java.net.Proxy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 抽象代理工厂类，由子类来实现具体获取代理方法
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 上午11:53
 */
public abstract class AbstractProxyFactory {
	
	protected List<Proxy> proxies = new CopyOnWriteArrayList<>();
	
	/**
	 * 添加代理
	 * @param proxy         代理
	 * @return              ProxyFactory
	 */
	public AbstractProxyFactory add(Proxy proxy) {
		this.proxies.add(proxy);
		return this;
	}
	
	/**
	 * 批量添加代理
	 * @param proxyList         代理列表
	 * @return                  ProxyFactory
	 */
	public AbstractProxyFactory addList(List<Proxy> proxyList) {
		this.proxies.addAll(proxyList);
		return this;
	}
	
	/**
	 * 清除代理
	 * @return          ProxyFactory
	 */
	public AbstractProxyFactory clear() {
		this.proxies.clear();
		return this;
	}
	
	/**
	 * 获取代理
	 * @return          Proxy
	 */
	public abstract Proxy get();
}
