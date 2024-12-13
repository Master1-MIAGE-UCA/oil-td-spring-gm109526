package ue17.oil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Service
public class DiceService {

    @Autowired
    private Dice dice;

    @Autowired
    private DiceRollLogRepository repository;

    public int[] rollDices(int count) {
        int[] results = IntStream.range(0, count)
                .map(i -> dice.roll())
                .toArray();

        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(count);
        log.setResults(convertResultsToString(results));
        log.setTimestamp(LocalDateTime.now());
        repository.save(log);

        return results;
    }

    private String convertResultsToString(int[] results) {
        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(result);
        }
        return sb.toString();
    }
}
