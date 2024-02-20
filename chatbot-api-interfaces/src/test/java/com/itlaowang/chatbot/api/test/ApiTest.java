package com.itlaowang.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {


    @Test
    public void query_unanswered_questions() throws IOException {
        //爬取问题
        //创建客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //get请求
        HttpGet httpGet=new HttpGet("https://api.zsxq.com/v2/groups/28888885824521/topics?scope=unanswered_questions&count=20");
        //增加header
        httpGet.addHeader("cookie","zsxq_access_token=24F0BE01-1B8F-782C-6438-C54847D8ADDD_4006C4B01DFFF282; zsxqsessionid=e388a86c7f188fc3a1ddb447e4166298; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22551525844454%22%2C%22first_id%22%3A%2218dc164836e5ad-0271fd0cda48e6e-26001851-921600-18dc164836f48f%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkYzE2NDgzNmU1YWQtMDI3MWZkMGNkYTQ4ZTZlLTI2MDAxODUxLTkyMTYwMC0xOGRjMTY0ODM2ZjQ4ZiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU1MTUyNTg0NDQ1NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22551525844454%22%7D%2C%22%24device_id%22%3A%2218dc164836e5ad-0271fd0cda48e6e-26001851-921600-18dc164836f48f%22%7D");
        httpGet.addHeader("Content-Type","application/json, text/plain, */*");
        //执行

        CloseableHttpResponse response = httpClient.execute(httpGet);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String s = EntityUtils.toString(response.getEntity());
            System.out.println(s);
        }else {
            System.out.println(response.getStatusLine()+"状态码");
        }
    }

}
