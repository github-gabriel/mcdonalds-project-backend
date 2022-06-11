package de.gabriel.mcdonaldsproject.extraItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extraItems")
public class ExtraItemRestController {

    @Autowired
    ExtraItemRepository extraItemRepository;

    @GetMapping
    List<ExtraItem> getExtraItems(){return extraItemRepository.findAll();}

    @PostMapping
    ExtraItem createExtraItem(@RequestBody ExtraItem extraItem){return extraItemRepository.save(extraItem);}

}
