package com.sontn.demo.controller;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sqs")
public class SQSController {

    @Autowired
    AmazonSQS amazonSQS;

    @PostMapping("/send")
    public ResponseEntity getTimeout(@RequestBody String abc){
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl("http://localhost:4566/000000000000/localstack-queue")
                .withMessageBody(abc)
                .withDelaySeconds(5);
        return ResponseEntity.ok(amazonSQS.sendMessage(send_msg_request));
    }

    @GetMapping("/receive")
    public List<Message> receive(){
        return amazonSQS.receiveMessage("http://localhost:4566/000000000000/localstack-queue").getMessages();
    }
}
