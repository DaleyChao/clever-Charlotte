package com.github.charlotte.oa.controller;

import com.github.charlotte.oa.entity.Account;
import com.github.charlotte.oa.entity.Config;
import com.github.charlotte.oa.service.AccountService;
import com.github.charlotte.oa.vo.RespStat;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Daniel
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private Config config;

    @RequestMapping("/page")
    public Object page(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                       @RequestParam(required = false, defaultValue = "5") Integer pageSize) {

        return accountService.findByPage(pageNum, pageSize);
    }

    @RequestMapping("login")
    public String login(Model model) {

        model.addAttribute("config", config);
        return "account/login";
    }


    /**
     * 用户登录异步校验
     * @param loginName
     * @param password
     * @return success 成功
     */


    /**
     *  /Login 1. 如果首次打开（没有任何参数），展示静态的HTML
     *         2. 如果有post请求，验证账号密码是否正确
     * @param loginName
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("validataAccount")
    @ResponseBody
    public String validataAccount(String loginName, String password, HttpServletRequest request) {

        // 1. 直接返回是否登录成功的结果
        // 2. 返回 Account对象，对象是空的 ，在controller里做业务逻辑
        // 在公司里 统一写法


        //让service返回对象，如果登录成功 把用户的对象
        Account account = accountService.findByLoginNameAndPassword(loginName, password);

        if (account == null) {
            return "登录失败";
        }else {
            // 登录成功
            // 写到Session里
            // 在不同的controller 或者前端页面上 都能使用
            // 当前登录用户的Account对象

            request.getSession().setAttribute("account", account);
            return "success";
        }
    }


    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request) {

        request.getSession().removeAttribute("account");
        return "index";
    }
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "5" ) int pageSize,Model model) {

        PageInfo<Account> page = accountService.findByPage(pageNum,pageSize);

        model.addAttribute("page", page);
        return "/account/list";
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public RespStat deleteById(int id) {
        // 标记一下 是否删除成功？  status
        RespStat stat = accountService.deleteById(id);

        return stat;
    }


    // FastDFS



    @RequestMapping("/profile")
    public String profile () {
        return "account/profile";
    }


    /**
     * 中文字符
     * @param filename
     * @param password
     * @return
     */
    @RequestMapping("/fileUploadController")
    public String fileUpload (MultipartFile filename, String password, HttpServletRequest request) {


        Account account = (Account)request.getSession().getAttribute("account");

        try {

            // 当前项目的路径
//		File path = new File(ResourceUtils.getURL("classpath:").getPath());
//        File upload = new File(path.getAbsolutePath(), "static/uploads/");


            // 指定系统存放文件的目录

            // 文件转存
            // 文件重名
            filename.transferTo(new File("uploads/"+filename.getOriginalFilename()));

            account.setPassword(password);
            account.setLocation(filename.getOriginalFilename());

            accountService.update(account);

        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "account/profile";
    }

}
