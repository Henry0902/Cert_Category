package fa.training.controller.api;

import fa.training.entities.Content;
import fa.training.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ContentRestController {

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("/contents")
    public List<Content> getAll(){
        return contentRepository.findAll();
    }

    @GetMapping("/contents/{id}")
    public Content detail(@PathVariable Integer id){
        return contentRepository.findById(id).orElse(null);
    }

    @PostMapping("/contents")
    public Content create(@RequestBody Content content){
        return contentRepository.save(content);
    }

}