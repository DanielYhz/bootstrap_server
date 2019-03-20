package cmpe273.group6.bootstrap_server.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import java.util.HashMap;

@RestController
@RequestMapping("/bs")
public class BootStrapController {

    private HashMap<String, Integer> map;
    String url = "http://localhost:8088";
    // Here, if the value is 1, means it's being bootstrapped.

    BootStrapController() {
        this.map = new HashMap<>();
        map.put("SJSU", 0);
        System.out.print(map);
    }



    @GetMapping("/bs/{id}")
    public String writeTo( @PathVariable("id") String fid) {
        if (!fid.substring(0,4).equals("SJSU")) {
            // invalid
            return null;
        }
        if (map.containsKey(fid)) {
            map.put(fid,1);
            return url;
        } else {
            return "Invalid Divice";
        }
    }

}
