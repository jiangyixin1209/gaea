package top.jiangyixin.gaea.core.util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 上午10:01
 */
public class JsoupUtil {
	
	/**
	 * 获取页面上所有超链接地址 （<a>标签的href值）
	 * @param document          页面文档
	 * @return                  链接集合
	 */
	public static Set<String> findLinks(Document document) {
		if (document == null) {
			return null;
		}
		
		Elements hrefElements = document.select("a[href]");
		Set<String> links = new HashSet<>();
		if (hrefElements != null && hrefElements.size() > 0) {
			for (Element element : hrefElements) {
				String href = element.attr("abs:href");
				if (UrlUtil.isUrl(href)) {
					links.add(href);
				}
			}
		}
		return links;
	}
}
