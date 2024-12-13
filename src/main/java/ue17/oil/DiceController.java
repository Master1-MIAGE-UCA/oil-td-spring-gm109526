package ue17.oil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dice")
public class DiceController {

    @Autowired
    private DiceService diceService;

    @GetMapping("/rollDice")
    public int rollDice() {
        return diceService.rollDices(1)[0];
    }

    @GetMapping("/rollDices/{count}")
    public int[] rollDices(@PathVariable int count) {
        return diceService.rollDices(count);
    }
}
