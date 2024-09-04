package spring_lotto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@Controller
public class LotteryController {

    @GetMapping("/")
    public String showLotteryPage(Model model) {
        model.addAttribute("numbers", new ArrayList<Integer>());
        return "lottery";
    }

    @GetMapping("/generate")
    public String generateNumbers(Model model) {
        List<Integer> numbers = generateLotteryNumbers();
        model.addAttribute("numbers", numbers);
        return "lottery";
    }

    private List<Integer> generateLotteryNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 6) {
            uniqueNumbers.add(random.nextInt(36) + 1);
        }

        numbers.addAll(uniqueNumbers);
        Collections.sort(numbers);
        return numbers;
    }
}

