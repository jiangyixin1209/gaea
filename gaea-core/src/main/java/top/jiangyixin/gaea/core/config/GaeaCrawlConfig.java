package top.jiangyixin.gaea.core.config;

/**
 * Gaea Crawl 配置文件
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/21 下午5:43
 */
public class GaeaCrawlConfig {
	/**
	 * User-Agent
	 */
	public static final String USER_AGENT_CHROME = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36";
	public static final String USER_AGENT_FIREFOX_45 = "Mozilla/5.0 (Windows NT 6.1; rv:45.0) Gecko/20100101 Firefox/45.0";
	public static final String USER_AGENT_IE = "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko";
	public static final String USER_AGENT_EDGE = "Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586";
	
	/**
	 * Default Timeout (单位/毫秒)
	 */
	public static final int TIMEOUT_MILLIS_DEFAULT = 5 * 1000;
	
	public enum ParseType {
		/**
		 * .html()
		 */
		HTML,
		/**
		 * .val()
		 */
		VAL,
		/**
		 * .text()
		 */
		TEXT,
		/**
		 * .attr("attribute")
		 */
		ATTR,
		/**
		 * .hasClass("className")
		 */
		HAS_CLASS
	}
	
}
