package com.github.telegrambot.service;

import com.github.telegrambot.bot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * Implementation of {@link SendBotMessageService} interface.
 */
/**
 * Implementation of {@link SendBotMessageService} interface.
 */
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final TelegramBot javarushBot;

    @Autowired
    public SendBotMessageServiceImpl(TelegramBot javarushBot) {
        this.javarushBot = javarushBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        if (isBlank(message)) return;

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            javarushBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging to the project.
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String chatId, List<String> messages) {
        if (isEmpty(messages)) return;

        messages.forEach(m -> sendMessage(chatId, m));
    }
}