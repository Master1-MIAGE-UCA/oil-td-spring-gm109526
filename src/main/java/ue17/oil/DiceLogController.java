package ue17.oil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diceLogs")
public class DiceLogController {

    @Autowired
    private DiceRollLogRepository repository;

    @GetMapping
    public List<DiceRollLog> getAllDiceLogs() {
        return repository.findAll();
    }
}