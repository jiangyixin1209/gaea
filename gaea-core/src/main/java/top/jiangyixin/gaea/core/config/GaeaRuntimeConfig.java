package top.jiangyixin.gaea.core.config;

import top.jiangyixin.gaea.core.loader.PageLoader;
import top.jiangyixin.gaea.core.parser.PageParser;
import top.jiangyixin.gaea.core.proxy.AbstractProxyFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Gaea 运行时配置
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 上午9:56
 */
public class GaeaRuntimeConfig {
	
	private volatile AbstractProxyFactory proxyFactory;
	private volatile int retryCount;
	private PageLoader pageLoader;
	private PageParser<?> pageParser;
	
	public AbstractProxyFactory getProxyFactory() {
		return proxyFactory;
	}
	
	public void setProxyFactory(AbstractProxyFactory proxyFactory) {
		this.proxyFactory = proxyFactory;
	}
	
	public int getRetryCount() {
		return retryCount;
	}
	
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}
	
	public PageLoader getPageLoader() {
		return pageLoader;
	}
	
	public void setPageLoader(PageLoader pageLoader) {
		this.pageLoader = pageLoader;
	}
	
	public PageParser<?> getPageParser() {
		return pageParser;
	}
	
	public void setPageParser(PageParser<?> pageParser) {
		this.pageParser = pageParser;
	}
}
