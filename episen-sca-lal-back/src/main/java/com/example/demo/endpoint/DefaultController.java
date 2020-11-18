package com.example.demo.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DefaultController {

    List<String> strings = new ArrayList<String>();
    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @PostMapping("/add/order")
    public void addOrder(@RequestBody String data) throws IOException {
        strings.add(data);
        logger.info("Number of word written this time : " + strings.size());

        BufferedWriter writer = new BufferedWriter(new FileWriter("./data/orders.txt", true));
        writer.write(data + " ");
        logger.info("Done, word written on file");

        writer.close();
    }
}
