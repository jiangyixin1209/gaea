package top.jiangyixin.gaea.core.runtime.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.jiangyixin.gaea.core.exception.GaeaException;
import top.jiangyixin.gaea.core.runtime.UrlManage;
import top.jiangyixin.gaea.core.util.UrlUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 本地内存实现运行 Url管理
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 上午11:30
 */
public class LocalUrlManage implements UrlManage {
	
	private final static Logger logger = LoggerFactory.getLogger(LocalUrlManage.class);
	private final LinkedBlockingDeque<String> unVisitUrlQueue = new LinkedBlockingDeque<>();
	private final Set<String> visitUrlSet = Collections.synchronizedSet(new HashSet<>());
	
	@Override
	public boolean addUrl(String url) {
		if (!UrlUtil.isUrl(url)) {
			logger.info("Gaea LocalUrlManage.addUrl fail, url not valid: {}", url);
			return false;
		}
		if (visitUrlSet.contains(url)) {
			logger.info("Gaea LocalUrlManage.addUrl fail, url add visited: {}", url);
			return false;
		}
		if (unVisitUrlQueue.contains(url)) {
			logger.info("Gaea LocalUrlManage.addUrl fail, url add repeat: {}", url);
			return false;
		}
		unVisitUrlQueue.add(url);
		logger.info("Gaea LocalUrlManage.addUrl success, url: {}", url);
		return true;
	}
	
	@Override
	public String getUrl() {
		String url;
		try {
			url = unVisitUrlQueue.take();
		} catch (InterruptedException e) {
			throw new GaeaException("LocalUrlManage.getUrl interrupted");
		}
		visitUrlSet.add(url);
		return url;
	}
	
	@Override
	public int getUrlNum() {
		return unVisitUrlQueue.size();
	}
}
