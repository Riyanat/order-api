package io.riyanat.orderapi.web;

import io.riyanat.orderapi.messaging.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    public MessagePublisher messagePublisher;

    @PostMapping("/{id}")
    public void postOrder(@PathVariable("id") String id) {
        messagePublisher.publish(id);
    }



}
