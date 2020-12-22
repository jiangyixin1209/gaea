package top.jiangyixin.gaea.core.loader.impl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.jiangyixin.gaea.core.RequestParam;
import top.jiangyixin.gaea.core.loader.PageLoader;
import top.jiangyixin.gaea.core.util.UrlUtil;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * TODO
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/22 上午10:08
 */
public class JsoupPageLoader implements PageLoader {
	
	private final static Logger logger = LoggerFactory.getLogger(PageLoader.class);
	
	@Override
	public Document load(RequestParam requestParam) {
		return loadDocument(requestParam);
	}
	
	/**
	 * 加载Document文档
	 * @param requestParam      请求参数
	 * @return                  Document
	 */
	public static Document loadDocument(RequestParam requestParam) {
		if (!UrlUtil.isUrl(requestParam.getUrl())) {
			return null;
		}
		try {
			
			Connection connect = Jsoup.connect(requestParam.getUrl());
			// 设置请求参数
			if (requestParam.getParamMap() != null && !requestParam.getParamMap().isEmpty()) {
				connect.data(requestParam.getParamMap());
			}
			// 设置Cookie
			if (requestParam.getCookieMap() != null && !requestParam.getCookieMap().isEmpty()) {
				connect.cookies(requestParam.getCookieMap());
			}
			// 设置头信息
			if (requestParam.getHeaderMap() != null && !requestParam.getHeaderMap().isEmpty()) {
				connect.headers(requestParam.getHeaderMap());
			}
			// 设置 UserAgent
			if (requestParam.getUserAgent() != null) {
				connect.userAgent(requestParam.getUserAgent());
			}
			// 设置referer头
			if (requestParam.getReferer() != null) {
				connect.referrer(requestParam.getReferer());
			}
			// 设置超时时间
			connect.timeout(requestParam.getTimeoutMillis());
			// 是否验证TLS
			if (requestParam.isValidateTls()) {
				connect.sslSocketFactory(socketFactory());
			}
			// 取消默认1M限制
			connect.maxBodySize(0);
			// 设置代理
			if (requestParam.getProxy() != null) {
				connect.proxy(requestParam.getProxy());
			}
			Document document;
			
			if (requestParam.getRequestType() == RequestParam.RequestType.GET) {
				document = connect.get();
			} else {
				document = connect.post();
			}
			return document;
		} catch (IOException e) {
			logger.error("Jsoup connect error [{}]", e.getMessage());
		}
		return null;
	}
	
	/**
	 * SSLSocketFactory
	 * @return                  SSLSocketFactory
	 */
	private static SSLSocketFactory socketFactory() {
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		}};
		
		try {
			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			return sslContext.getSocketFactory();
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			throw new RuntimeException("Failed to create a SSL socket factory", e);
		}
	}
}
