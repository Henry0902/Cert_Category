package fa.training.controller;

import fa.training.repositories.ContentRepository;
import fa.training.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class MemberController {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private ContentRepository contentRepository;
//
//    @GetMapping("/content/viewcontent")
//    public String contentList(Model model){
//        //model.addAttribute("ABC", departmentRepository.findAll());
//        return "content";
//    }
}
