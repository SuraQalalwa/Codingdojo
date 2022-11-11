package com.projectmanager.mvc.controllers;
import com.projectmanager.mvc.models.LoginUser;
import com.projectmanager.mvc.models.Project;
import com.projectmanager.mvc.models.User;
import com.projectmanager.mvc.services.ProjectService;
import com.projectmanager.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userServ;
    @Autowired
    private ProjectService projectService;

    /////////////////LogIn & Registeration//////////////////////
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {

        User user = userServ.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user", newUser.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
    @GetMapping("/projects/new")
    public String newProject(@ModelAttribute("Project") Project project, Long id, HttpSession session , Model model) {
        if ((session.getAttribute("userId") != null)) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            model.addAttribute("currentUser", currentUser);
            return "newProject.jsp";
        }
        else{
            return "redirect:/";
        }
    }
    @PostMapping("/projects/new")
    public String addProject(@Valid @ModelAttribute("Project") Project project, Model model, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "/home";
        } else {
            if ((session.getAttribute("userId") != null)) {
                Long userId = (Long) session.getAttribute("userId");
                User currentUser = userServ.findById(userId);
                project.setTeamlead(currentUser);
                projectService.createProject(project);
            }
            System.out.println(project.getDuedate());
            return "redirect:/projects/new";
        }
    }

    @GetMapping("/home")
    public String showAllProjects(HttpSession session, Model model, @ModelAttribute("Project") Project project) {
        if ((session.getAttribute("userId") != null)) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            List<Project> userNotLeader = projectService.projectNotLeader(currentUser);
            List<Project> userLeader = projectService.projectLeader(currentUser);
            model.addAttribute("userNotLeader", userNotLeader);
            model.addAttribute("userLeader", userLeader);
            model.addAttribute("currentUser", currentUser);
            return "home.jsp";
        }
        return "redirect:/";
    }
    @RequestMapping("/projects/join/{prid}")
    public String joinGroup(@PathVariable(value = "prid") Long prid, HttpSession session, Model model) {
        if ((session.getAttribute("userId") != null)) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            Project thisproject = projectService.findProjectById(prid);
            currentUser.getProjects().add(thisproject);
            userServ.updateUser(currentUser);
            model.addAttribute("userNotLeader", projectService.projectNotLeader(currentUser));
            model.addAttribute("userLeader", projectService.projectLeader(currentUser));
            model.addAttribute("currentUser", currentUser);

        }
        return "redirect:/home";

    }
    @RequestMapping("/projects/leave/{prid}")
    public String leaveGroup(@PathVariable(value = "prid") Long prid, HttpSession session, Model model) {
        if ((session.getAttribute("userId") != null)) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            Project thisproject = projectService.findProjectById(prid);
            currentUser.getProjects().remove(thisproject);
            userServ.updateUser(currentUser);
            model.addAttribute("userNotLeader", projectService.projectNotLeader(currentUser));
            model.addAttribute("userLeader", projectService.projectLeader(currentUser));
            model.addAttribute("currentUser", currentUser);

        }
        return "redirect:/home";

    }
    @GetMapping ("/projects/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model,HttpSession session,@ModelAttribute("project") Project project) {
        if ((session.getAttribute("userId") != null)) {
            project = projectService.findProjectById(id);
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            model.addAttribute("userNotLeader", projectService.projectNotLeader(currentUser));
            model.addAttribute("userLeader", projectService.projectLeader(currentUser));
            model.addAttribute("project", project);
            return "edit.jsp";
        }
        else {
            return "redirect:/home";
        }
    }
    @PostMapping("/projects/{id}")
    public String update(@Valid @ModelAttribute("project") Project updateproject, BindingResult result,
                         @PathVariable("id")Long id, HttpSession session) {
        if ((session.getAttribute("userId") != null)) {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userServ.findById(userId);
            updateproject.setTeamlead(currentUser);
            projectService.update(updateproject);
        }
        return "redirect:/home";
    }

    @GetMapping("/showproject/{projectid}")
    public String showProject(@PathVariable(value = "projectid") Long id, Model model ){
        Project thisproject= projectService.findProjectById(id);
        model.addAttribute("thisproject", thisproject);
        return "showproject.jsp";
    }

    @GetMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
        if ((session.getAttribute("userId") != null)) {
            projectService.deleteProject(id);
        }
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

