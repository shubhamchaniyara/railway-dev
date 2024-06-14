import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the home page!";
    }

    @GetMapping("/error")
    public String handleError() {
        // Custom error handling logic
        return "error"; // View name for error page
    }
}
