package top.jiangyixin.gaea.core.util;

/**
 * Url 工具类
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 上午10:05
 */
public class UrlUtil {
	
	/**
	 * 是否为合法的url
	 * @param url       url链接
	 * @return          true/false
	 */
	public static boolean isUrl(String url) {
		return url != null && url.trim().length() > 0 && url.startsWith("http");
	}
}
