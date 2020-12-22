package top.jiangyixin.gaea.core.loader;

import org.jsoup.nodes.Document;
import top.jiangyixin.gaea.core.RequestParam;

/**
 * TODO
 *
 * @author jiangyixin
 * @version 1.0
 * @date 2020/12/21
 */
public interface PageLoader {
	
	/**
	 * 加载url数据
	 * @param requestParam      请求参数
	 * @return                  Document 对象
	 */
	Document load(RequestParam requestParam);
}
