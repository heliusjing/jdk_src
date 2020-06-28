import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author Helius
 * @Create 2020-05-19-11:55 下午
 */
public class webClientTest {

    @Test
    public void homePage() throws IOException {
        final WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("www.baidu.com");
        Assert.assertEquals("html",page.getTitleText());
        String pageAsXml = page.asXml();
        webClient.close();
    }

    @Test
    public void homePage_Firefox() throws Exception {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_68);
        HtmlPage page = webClient.getPage("http://www.baidu.com");
        HtmlDivision some_div_id = page.getHtmlElementById("some_div_id");
        HtmlAnchor anchor = page.getAnchorByName("anchor_name");
        webClient.close();
    }

    //xpath
    @Test
    public void xpath() {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = webClient.getPage("www.baidu.com");
            List<?> divs = page.getByXPath("//div");
            HtmlDivision o = (HtmlDivision) page.getByXPath("//div[@name='John").get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void homePage_proxy() throws Exception {
        //需指定myProxyPort
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX, "myproxyserver",
                3305);
        //设置代理的用户名和密码
        final DefaultCredentialsProvider credentialsProvider = (DefaultCredentialsProvider)webClient.getCredentialsProvider();
        credentialsProvider.addCredentials("username","password");
        final HtmlPage page =webClient.getPage("http://htmlunit.sourceforge.net");
        Assert.assertEquals("HtmlUnit -Welcome to HtmlUnit", page.getTitleText());
        webClient.close();
    }

    //form
    @Test
    public void submittingForm() throws Exception{
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = webClient.getPage("www.baidu.com");
            HtmlForm myform = page.getFormByName("myform");

        }
    }

    //base_test
    @Test
    public void main() throws Exception {
        //使用webClient的构造方法指定以何种浏览器打开网页，此处为以firefox打开,也可以不指定
        WebClient webClient=new WebClient(BrowserVersion.FIREFOX);

        //使用代理IP，这是为了应对网站有反爬系统的情况
        //WebClient webClient2=new WebClient(BrowserVersion.FIREFOX_52,"202.106.16.36",3128);

        //HTMLClient对css和js的支持不好，所以将其关闭
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        HtmlPage page=webClient.getPage("http://www.baidu.com");

        //获取当前页面的html
        String string=page.asXml();
        System.out.println("html内容为："+string);

        //获取当前页面的文本
        String string2=page.asText();
        System.out.println("纯文本内容为："+string2);

        //获取百度首页“百度一下”按钮
        HtmlInput button=(HtmlInput) page.getElementById("su");
        System.out.println("百度一下按钮的默认值为："+button.getDefaultValue());

        //获取百度首页搜索输入框
        HtmlInput input=(HtmlInput) page.getElementById("kw");
        System.out.println("百度首页输入框的最大长度为："+input.getAttribute("maxlength"));

        //找到百度首页所有div并打印第一个的html
        List<?> divs=page.getByXPath("//div");
        HtmlDivision division=(HtmlDivision) divs.get(0);
        System.out.println(division.asXml());

        //查找并获取特定条件的input
        List<?> inputs=page.getByXPath("//input[@id='su']");
        HtmlInput input2=(HtmlInput) inputs.get(0);
        System.out.println(input2.asXml());

        //为百度首页的搜索输入框设置值并提交搜索
        HtmlInput input3=(HtmlInput) page.getElementById("kw");
        //调用setValueAttribute方法设置值
        input3.setValueAttribute("日向優梨");
        HtmlInput button2=(HtmlInput) page.getElementById("su");
        //模拟点击“百度一下”按钮
        HtmlPage page2=button2.click();
        System.out.println(page2.asXml());

        //关闭webclient
        webClient.close();


    }

    @Test
    public void test01() throws Exception {
        //实例化webClent 对象
        WebClient webClient = new WebClient();
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getCookieManager().setCookiesEnabled(true);
        //获取页面
        HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        webClient.waitForBackgroundJavaScript(1000*3);
        //返回此页面的标题或如果指定的标题不是一个空字符串。
        System.out.println("获取的标题是： 与" + page.getTitleText());
        //获取网页中的内容，以XML方法返回
        //返回一个字符串表示XML文档的元素和所有它的孩子(递归)。是当前页面编码使用的字符集。
        String pageAsXml = page.asXml();
        //contains 包含
        System.out.println(pageAsXml.contains("<body class=\"composite\">"));
        //获取网页中的内容以文本方式返回
        //返回一个代表该元素的文本表示会对用户可见的如果这个页面是显示在一个web浏览器。例如,single-selection选择元素将返回当前选中的值为文本。

        String pageAsText = page.asText();
        //是否包含以下内容
        System.out.println(pageAsText.contains("Support for the HTTP and HTTPS protocols"));


    }



}
