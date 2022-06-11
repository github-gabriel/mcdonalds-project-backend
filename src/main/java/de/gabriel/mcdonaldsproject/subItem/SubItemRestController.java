package de.gabriel.mcdonaldsproject.subItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subItems")
public class SubItemRestController {

    @Autowired
    SubItemRepository subItemRepository;

    @GetMapping
    List<SubItem> getSubItems(){return subItemRepository.findAll();}

    @PostMapping
    SubItem createSubItem(@RequestBody SubItem subItem){return subItemRepository.save(subItem);}

}
