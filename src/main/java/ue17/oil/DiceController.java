package ue17.oil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dice")
public class DiceController {

    @Autowired
    private Dice dice;

    @GetMapping("/rollDice")
    public int rollDice() {
        return dice.roll();
    }

    @GetMapping("/rollDices/{count}")
    public int[] rollDices(@PathVariable int count) {
        int[] results = new int[count];
        for (int i = 0; i < count; i++) {
            results[i] = dice.roll();
        }
        return results;
    }
}
