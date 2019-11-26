package ru.zdoher.japs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Service;

@Service
public class MyMessageService {
    private PollableChannel sendChannel;
    private DirectChannel receiveChannel;

    public MyMessageService(PollableChannel sendChannel, DirectChannel receiveChannel) {
        this.sendChannel = sendChannel;
        this.receiveChannel = receiveChannel;
        register();
    }

    public void sendMes(Message message) {
        sendChannel.send(message);
    }

    private void register() {
        receiveChannel.subscribe(System.out::println);

        new Thread(() -> {
            while (true) {
                receiveChannel.send(sendChannel.receive());
            }
        }).start();
    }
}
