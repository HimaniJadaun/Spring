/**
 *  Copyright 2016 SuperHighway Labs (P) Limited . All Rights Reserved.
 *  SUPERHIGHWAY LABS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */  
package hello;

/**
 *  
 *  @version     1.0, Feb 2, 2016
 *  @author himani
 */
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
