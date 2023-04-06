package springexamples.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileUploadController {

    @GetMapping("/fileupload")
    public ModelAndView fileUpload() throws IOException {
        ModelAndView response = new ModelAndView("fileupload");

        return response;
    }

    @PostMapping("/fileupload")
    public ModelAndView fileUpload(@RequestParam MultipartFile fileUpload) throws IOException {
        ModelAndView response = new ModelAndView("fileupload");

        // the target location of where I want the file to be saved
        // Intellij considered the root path to be folder inside the RTT-45 folder (SpringBoot)
        // so by using ./ we are saying start at the project root and build the path to where we want to save the file
        // notice we are not using a URL, instaed we are using the filesystem path
        File target = new File("./src/main/webapp/pub/images/" + fileUpload.getOriginalFilename());
        log.debug(target.getAbsolutePath());

        // this line is a convenience method provided from commons-io library
        // the browser offers the file to be uploaded as an inputstream to the server
        // this method does all of the work reading from the input stream and writing it out to a target file on the filesystem
        FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), target);

        // this is just example code so I could display the file on the page after it has been uploaded.
        // all I am doing is adding the URL to the file to our model to pass to the jsp page
        // notice here that we are using a URL address and not a filesystem address
        response.addObject("fileUrl", "/pub/images/" + fileUpload.getOriginalFilename());
        return response;
    }

}
