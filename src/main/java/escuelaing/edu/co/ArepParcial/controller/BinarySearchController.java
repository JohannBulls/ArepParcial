package escuelaing.edu.co.ArepParcial.controller;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/binarysearch")
public class BinarySearchController {

    @GetMapping
    public Map<String, Object> binarySearch(@RequestParam String list, @RequestParam String value) {
        List<String> items = Arrays.asList(list.split(","));
        int index = binarySearchRecursive(items, value, 0, items.size() - 1);

        return Map.of(
                "operation", "binarySearch",
                "inputlist", list,
                "value", value,
                "output", index
        );
    }

    private int binarySearchRecursive(List<String> list, String value, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int compareResult = list.get(mid).compareTo(value);

        if (compareResult == 0) {
            return mid;
        } else if (compareResult > 0) {
            return binarySearchRecursive(list, value, left, mid - 1);
        } else {
            return binarySearchRecursive(list, value, mid + 1, right);
        }
    }
}