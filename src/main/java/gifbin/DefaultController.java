package gifbin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String redirect() {
        return "redirect:/gifs";
    }

    @GetMapping("/gifs")
    public String gifs(){
        return "gifs";
    }


    @PostMapping("/gifs")
    public String create(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getSize());
        System.out.println(file.getContentType());

        return "redirect:/gifs";
    }

    @GetMapping(path = "/bananas", produces = "image/gif")
    public void copyImage(OutputStream out) throws IOException {
        Files.copy(Paths.get("C:\\Users\\k5001199\\bananas.gif"), out);
    }


    @GetMapping(path = "/images/1", produces = "image/png")
    public String copyImage() {
        return "redirect:/img/bananas.gif";
    }
}
