package top.jiangyixin.gaea.core.thead;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.jiangyixin.gaea.core.GaeaCrawler;

/**
 * TODO
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 下午2:20
 */
public class GaeaCrawlerThread implements Runnable {
	
	private final static Logger logger = LoggerFactory.getLogger(GaeaCrawlerThread.class);
	
	private GaeaCrawler crawler;
	private boolean running;
	private boolean stop;
	
	public GaeaCrawlerThread(GaeaCrawler crawler) {
		this.crawler = crawler;
		this.running = true;
		this.stop = false;
	}
	
	@Override
	public void run() {
	
	}
	
	public void setStop() {
		this.stop = true;
	}
	
	public boolean isRunning() {
		return running;
	}
}
