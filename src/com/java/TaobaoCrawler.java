package com.java;/*
 *   Java爬虫，爬取淘宝首页源代码。
 */
// io中封装了许多操控数据流的类与方法。
import java.io.BufferedReader;
import java.io.InputStreamReader;
//net包中封装了许多和网络相关的API。
import java.net.URL;
import java.net.URLConnection;

//类名TaobaoCrawler
public class TaobaoCrawler
{    //程序主入口
    public static void main(String[] args)
    {
        // 声明一个String类型用来定义即将访问的链接
        String url = "https://www.taobao.com/";
        // 声明一个String类型用来存储网页内容
        String result = "";
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        //监听代码块，如有异常则抛出异常
        try
        {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null)
            {
                // 遍历抓取到的每一行并将其存储到result里面
                result += line + "\n";
            }
        } catch (Exception e) //异常处理，抛出异常。
        {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } // 使用finally来关闭输入流
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            } catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        System.out.println(result);
    }
}