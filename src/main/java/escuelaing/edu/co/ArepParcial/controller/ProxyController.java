package escuelaing.edu.co.ArepParcial.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/linearsearch")
    public String linearSearch(@RequestParam String list, @RequestParam String value) {
        String url = "http://localhost:8081/linearsearch?list=" + list + "&value=" + value;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/binarysearch")
    public String binarySearch(@RequestParam String list, @RequestParam String value) {
        String url = "http://localhost:8082/binarysearch?list=" + list + "&value=" + value;
        return restTemplate.getForObject(url, String.class);
    }
}