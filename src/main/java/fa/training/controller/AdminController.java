package fa.training.controller;

import fa.training.entities.Content;
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
@RequestMapping("/admin/")
public class AdminController {
//    @Autowired
//    private ContentRepository contentRepository;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    //localhost:8080/admin/dashboard
//    @GetMapping("/dashboard")
//    public String dashBoard(){
//        return "admin/dashboard";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/content/createcontent")
//    public String createContentUI(){
//        return "admin/content/createcontent";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/content/createcontent")
//    public String saveContent(
//            @ModelAttribute("content") Content content,
//            Model model,
//            RedirectAttributes redirectAttributes
//    ){
//        //1. validate name
//        if(content == null || "".equals(content.getTitle())) {
//            model.addAttribute("msg", "Content name must be enter");
//            return "admin/content/createcontent";
//        }
//
//        //2. save
//        content.setAuthorId(SecurityContextHolder.getContext().getAuthentication().getName());
//        contentRepository.save(content);
//
//        //3. list
//        redirectAttributes.addFlashAttribute("msg", "Create content is successfully");
//        return "redirect:/admin/content/createcontent";
//    }
//
//    @GetMapping("/content/viewcontent")
//    public String getContentsUI(
//            @RequestParam(defaultValue = "1") Integer pageNum,
//            @RequestParam(defaultValue = "3") Integer pageSize,
//            Model model
//    ){
//        Sort sort = Sort.by("id").descending();
//        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
//
//        Page<Content> pageContents = contentRepository.findAll(pageable);
//        model.addAttribute("pageContent", pageContents);
//        return "admin/content/viewcontent";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/content/delete/{id}")
//    public String deleteContent(@PathVariable Integer id, RedirectAttributes attributes) {
//        contentRepository.deleteById(id);
//        attributes.addFlashAttribute("msg", "Delete content is successfully");
//        return "redirect:/admin/content/viewcontent";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/content/editcontent/{id}")
//    public String editContentUI(
//            @PathVariable Integer id,
//            Model model)
//    {
//        model.addAttribute("content", contentRepository.findById(id).orElse(null));
//        return "admin/content/editcontent";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/content/editcontent")
//    public String updateContent(
//            @ModelAttribute("content") @Validated Content content,
//            BindingResult result,
//            Model model)
//    {
//        //1. validate
//        if(result.hasErrors()) {
//            return "admin/content/editcontent";
//        }
//
//        contentRepository.save(content);
//        return "redirect:/admin/content/viewcontent";
//    }
}
