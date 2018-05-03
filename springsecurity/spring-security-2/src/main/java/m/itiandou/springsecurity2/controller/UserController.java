package m.itiandou.springsecurity2.controller;

import m.itiandou.springsecurity2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

/**
 * @author fengqigui
 * @description controller
 * @date 2018/05/02 11:37
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginIndex(Model model){

        model.addAttribute("title","首页");
        return "/index";
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        Object springSecurityContext = session.getAttribute(SPRING_SECURITY_CONTEXT_KEY);
        if(springSecurityContext != null){

            model.addAttribute("title","page2");
            return "/page2";
        }
        model.addAttribute("title","登录页");
        return "/loginH";
    }
    @RequestMapping(value = "/pageOne",method = RequestMethod.GET)
    public String page1(Model model){
        model.addAttribute("title","page1");
        return "/page1";
    }

    @RequestMapping(value = "/pageTwo",method = RequestMethod.GET)
    public String page2(Model model){
        model.addAttribute("title","page2");
        return "/page2";
    }

    @RequestMapping(value = "/user/delete/{id}",method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('admin')")
    public String deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "/page2";
    }


}
