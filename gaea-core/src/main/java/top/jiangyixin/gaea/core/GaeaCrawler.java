package top.jiangyixin.gaea.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.jiangyixin.gaea.core.config.GaeaRuntimeConfig;
import top.jiangyixin.gaea.core.exception.GaeaException;
import top.jiangyixin.gaea.core.runtime.UrlManage;
import top.jiangyixin.gaea.core.thead.GaeaCrawlerThread;

import java.util.List;
import java.util.concurrent.*;

/**
 * Gaea Crawler 核心类
 *
 * @author jiangyixin
 * @version 1.0
 * @date 2020/12/21
 */
public class GaeaCrawler {
	public static final int MAX_THREAD_COUNT = 1000;
	
	private static final Logger logger = LoggerFactory.getLogger(GaeaCrawler.class);
	private volatile UrlManage urlManage;
	private volatile GaeaRuntimeConfig runtimeConfig;
	/**
	 * 线程数
	 */
	private int threadCount = 1;
	private final ExecutorService crawlers = new ThreadPoolExecutor(0, MAX_THREAD_COUNT,
			60L, TimeUnit.SECONDS,
			new SynchronousQueue<Runnable>());
	private final List<GaeaCrawlerThread> crawlerThreads = new CopyOnWriteArrayList<>();
	
	public static class Builder {
		private final GaeaCrawler crawler = new GaeaCrawler();
		
		/**
		 * 设置 url 管理器
		 * @param urlManage     url管理器
		 * @return              Builder
		 */
		public Builder setUrlManage(UrlManage urlManage) {
			crawler.urlManage = urlManage;
			return this;
		}
		
		/**
		 * 设置待爬取URL列表
		 * @param urls          url 列表
		 * @return              Builder
		 */
		public Builder setUrls(List<String> urls) {
			if (crawler.urlManage == null) {
				throw new GaeaException("Set setUrlManage must before set setUrls !");
			}
			if (urls != null && !urls.isEmpty()) {
				for (String url: urls) {
					crawler.urlManage.addUrl(url);
				}
			}
			return this;
		}
		
		/**
		 * 设置爬虫并发线程数
		 * @param threadCount       线程数
		 * @return                  Builder
		 */
		public Builder setThreadCount(int threadCount) {
			crawler.threadCount = threadCount;
			return this;
		}
		
		public GaeaCrawler build() {
			return crawler;
		}
	}
	
	/**
	 * 启动爬虫
	 * @param sync          true=同步，false=异步
	 */
	public void start(boolean sync) {
		if (urlManage == null) {
			throw new GaeaException("Gaea Crawler urlManage can not be null");
		}
		if (urlManage.getUrlNum() <= 0) {
			throw new GaeaException("Gaea Crawler url can not be empty");
		}
		if (threadCount < 1) {
			throw new GaeaException("Gaea Crawler threadCount invalid, thread:" + threadCount);
		}
		if (threadCount > MAX_THREAD_COUNT) {
			throw new GaeaException("Gaea Crawler threadCount overdue max, Please set less than " + MAX_THREAD_COUNT);
		}
		if (runtimeConfig.getPageLoader() == null) {
			throw new GaeaException("Gaea Crawler pageLoader can not be null");
		}
		if (runtimeConfig.getPageParser() == null) {
			throw new GaeaException("Gaea Crawler pageParse can not be null");
		}
		logger.info("Gaea Crawler start...........");
		for (int i = 0; i < threadCount; i++) {
			GaeaCrawlerThread crawlerThread = new GaeaCrawlerThread(this);
			crawlerThreads.add(crawlerThread);
		}
		for (GaeaCrawlerThread crawlerThread : crawlerThreads) {
			crawlers.execute(crawlerThread);
		}
		crawlers.shutdown();
		if (sync) {
			try {
				while (!crawlers.awaitTermination(5, TimeUnit.SECONDS)) {
				
				}
			} catch (InterruptedException e) {
				logger.error("");
			}
		}
	}
	
}
