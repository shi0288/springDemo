package com.mcp.myself.controller;

import com.mcp.myself.model.Book;
import com.mcp.myself.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller   //类似Struts的Action
@Component
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;



    @Scheduled(fixedDelay = 2000)
    public void dealWithPayResult(){
        System.out.println("发送到发送到发送到");
    }


    @RequestMapping("/addBook")
    public String contextInitialized(@RequestParam(value = "username", required = false) String username, String password) {
        System.out.println("----------   start");
        Book book = new Book();
        book.setName(username);
        book.setDescription(password);
        bookService.save(book);
        System.out.println("----------   end");
        return "/success";
    }


    @RequestMapping(value = "/test")
    public String test(String username, String password) {
        Book book = new Book();
        System.out.println("open");
        book.setName(username);
        book.setDescription(password);
        bookService.save(book);
        return "/success";
    }

    @RequestMapping(value = "/test", params = "method=2", method = RequestMethod.GET)
    public ModelAndView test1(String username, String password) {
        System.out.println("open2");
        Map<String, String> values = new HashMap<String, String>();
        values.put("username", username);
        values.put("password", password);
        return new ModelAndView(new RedirectView("addBook"), values);

    }


    @RequestMapping("/login")  // 请求url地址映射，类似Struts的action-mapping
    public String testLogin(@RequestParam(value = "username") String username, String password) {
        // @RequestParam是指请求url地址映射中必须含有的参数(除非属性required=false)
        // @RequestParam可简写为：@RequestParam("username")

        if (!"admin".equals(username) || !"admin".equals(password)) {
            return "success"; // 跳转页面路径（默认为转发），该路径不需要包含spring-servlet配置文件中配置的前缀和后缀
        }
        return "success";
    }

    @RequestMapping("/test/login2.do")
    public ModelAndView testLogin2(String username, String password, int age) {
        // request和response不必非要出现在方法中，如果用不上的话可以去掉
        // 参数的名称是与页面控件的name相匹配，参数类型会自动被转换

        if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {
            return new ModelAndView("loginError"); // 手动实例化ModelAndView完成跳转页面（转发），效果等同于上面的方法返回字符串
        }
        return new ModelAndView(new RedirectView("../index.jsp"));  // 采用重定向方式跳转页面
        // 重定向还有一种简单写法
        // return new ModelAndView("redirect:../index.jsp");
    }

    @RequestMapping("/test/login3.do")
    public ModelAndView testLogin3(Book book) {
        // 同样支持参数为表单对象，类似于Struts的ActionForm，User不需要任何配置，直接写即可
        String username = book.getName();
        String password = book.getDescription();

        if (!"admin".equals(username) || !"admin".equals(password)) {
            return new ModelAndView("loginError");
        }
        return new ModelAndView("loginSuccess");
    }


    @RequestMapping("/test/login4.do")
    public String testLogin4(Book book) {

        book.getId();
        return "loginSuccess";
    }


}
