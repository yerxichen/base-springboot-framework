package com.sjq.demo.Utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientUtil {

    public String httpGet(String url,JSONObject paramObj) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String rtStr="";
        try {
            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
            httpClient = HttpClientBuilder.create().build();
            URI uri=setUri(url,paramObj);
            // 创建Get请求
            HttpGet httpGet = new HttpGet(uri);
            // 配置信息
            // 将上面的配置信息 运用到这个Get请求里
            httpGet.setConfig(setConfig());

            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);

            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (response.getStatusLine().equals("200")) {
                rtStr=EntityUtils.toString(responseEntity);
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return rtStr;
    }

    public String httpPost(String url,JSONObject paramObj) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String rtStr="";
        try {
            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
            httpClient = HttpClientBuilder.create().build();
            //设置uri
            URI uri=setUri(url,paramObj);
            // 创建Get请求
            HttpPost httpPost = new HttpPost(uri);


            // 将上面的配置信息 运用到这个Get请求里
            httpPost.setConfig(setConfig());

            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpPost);

            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (response.getStatusLine().equals("200")) {
                rtStr=EntityUtils.toString(responseEntity);
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return rtStr;
    }

    private URI setUri(String url,JSONObject paramObj) throws URISyntaxException {
        // 参数
        URI uri = null;
        // 将参数放入键值对类NameValuePair中,再放入集合中
        List<NameValuePair> params = new ArrayList<>();
        for(String key:paramObj.keySet()){
            params.add(new BasicNameValuePair(key, paramObj.getString(key)));
        }
        // 设置uri信息,并将参数集合放入uri;
        // 注:这里也支持一个键值对一个键值对地往里面放setParameter(String key, String value)
        uri = new URIBuilder(url).setParameters(params).build();
        return uri;

    }

    private RequestConfig setConfig(){
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();
        return requestConfig;
    }
}
