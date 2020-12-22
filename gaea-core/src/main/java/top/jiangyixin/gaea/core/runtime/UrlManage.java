package top.jiangyixin.gaea.core.runtime;

/**
 * Url 管理接口
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 上午11:28
 */
public interface UrlManage {
	
	/**
	 * 添加 url
	 * @param url       url
	 * @return          true/false
	 */
	boolean addUrl(String url);
	
	/**
	 * 获取 url
	 * @return          url
	 */
	String getUrl();
	
	/**
	 * 获取 url 数量
	 * @return          url数量
	 */
	int getUrlNum();
}
