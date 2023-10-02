package fa.training.controller;

import fa.training.consts.RoleEnum;
import fa.training.entities.Member;
import fa.training.entities.MemberRoles;
import fa.training.entities.MemberRolesId;
import fa.training.entities.Roles;
import fa.training.repositories.MemberRepository;
import fa.training.repositories.MemberRolesRepository;
import fa.training.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AuthController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberRolesRepository memberRolesRepository;

    //authentication
    //authorization
    // access control
    //solid => D (dependency inversion) => IOC => DI
    @Autowired
    private MemberService memberService;
    @GetMapping("/login")
    public String loginUI(Model model){
        model.addAttribute("memberInfo", new Member());
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin(
        @ModelAttribute("userInfo") @Validated Member memberUI,
        BindingResult result,
        Model model,
        HttpSession session
    ){
        // validate
        if(result.hasErrors()) {
            return "login";
        }

        Member member = memberService.checkLogin(memberUI.getEmail(), memberUI.getPassWord());
        if(member == null) {
            model.addAttribute("msg", "Email or password is incorrect");
            return "login";
        }
        session.setAttribute("userLogged", member);
        return "redirect:/admin/content/createcontent";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerUI(Model model){
        model.addAttribute("memberRegister", new Member());
        return "register";
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerToDB(@ModelAttribute("memberRegister") Member members){
        //1. encryt password
        String rawPassword = members.getPassWord();
        String encodePassword = passwordEncoder.encode(rawPassword);
        members.setPassWord(encodePassword);
        memberRepository.save(members);

        //setting role
        Roles roles = new Roles();
        roles.setId(RoleEnum.MEMBER.getId());
        roles.setName(RoleEnum.MEMBER.getName());

        //2. set role default
        MemberRoles memberRoles = new MemberRoles();
        MemberRolesId memberRolesId  = new MemberRolesId();
        memberRolesId.setMemberId(members.getId());
        memberRolesId.setRoleId(RoleEnum.MEMBER.getId());

        memberRoles.setMember(members);
        memberRoles.setRoles(roles);
        memberRoles.setId(memberRolesId);
        memberRolesRepository.save(memberRoles);
        return "redirect:/login";
    }
}
