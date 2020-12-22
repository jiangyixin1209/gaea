package top.jiangyixin.gaea.core;

import java.net.Proxy;
import java.util.Map;

/**
 * 请求参数
 *
 * @author jiangyixin
 * @version 1.0
 * @date 2020/12/21
 */
public class RequestParam {
    
    /**
     * 请求方法
     */
    public enum RequestType {
        /**
         * GET请求
         */
        GET,
        /**
         * POST请求
         */
        POST
    }

    private String url;
    private Map<String, String> paramMap;
    private Map<String, String> cookieMap;
    private Map<String, String> headerMap;
    private String userAgent;
    private String referer;
    private int timeoutMillis;
    private Proxy proxy;
    private boolean isValidateTls;
    private RequestType requestType;

    public RequestParam() {
    }

    public RequestParam(String url, Map<String, String> paramMap,
                        Map<String, String> cookieMap, Map<String, String> headerMap,
                        String userAgent, String referer, int timeoutMillis,
                        Proxy proxy, boolean isValidateTls,
                        RequestType requestType) {
        this.url = url;
        this.paramMap = paramMap;
        this.cookieMap = cookieMap;
        this.headerMap = headerMap;
        this.userAgent = userAgent;
        this.referer = referer;
        this.timeoutMillis = timeoutMillis;
        this.proxy = proxy;
        this.isValidateTls = isValidateTls;
        this.requestType = requestType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, String> getCookieMap() {
        return cookieMap;
    }

    public void setCookieMap(Map<String, String> cookieMap) {
        this.cookieMap = cookieMap;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public int getTimeoutMillis() {
        return timeoutMillis;
    }

    public void setTimeoutMillis(int timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }
    
    public boolean isValidateTls() {
        return isValidateTls;
    }
    
    public void setValidateTls(boolean validateTls) {
        isValidateTls = validateTls;
    }
    
    public RequestType getRequestType() {
        return requestType;
    }
    
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }
}
