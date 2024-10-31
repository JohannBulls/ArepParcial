package escuelaing.edu.co.ArepParcial.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/linearsearch")
public class LinearSearchController {

    @GetMapping
    public Map<String, Object> linearSearch(@RequestParam String list, @RequestParam String value) {
        List<String> items = Arrays.asList(list.split(","));
        int index = -1;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(value)) {
                index = i;
                break;
            }
        }

        return Map.of(
                "operation", "linearSearch",
                "inputlist", list,
                "value", value,
                "output", index
        );
    }
}