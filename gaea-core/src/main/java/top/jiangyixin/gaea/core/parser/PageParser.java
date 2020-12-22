package top.jiangyixin.gaea.core.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import top.jiangyixin.gaea.core.RequestParam;


/**
 * TODO
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 下午2:14
 */
public interface PageParser<T> {
	
	default void beforeParse(RequestParam requestParam){};
	
	void parse(Document document, Element element, T page);
}
