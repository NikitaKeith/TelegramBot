package com.github.telegrambot.command;

import com.github.telegrambot.command.Command;
import com.github.telegrambot.repository.entity.TelegramUser;
import com.github.telegrambot.service.SendBotMessageService;
import com.github.telegrambot.service.TelegramUserService ;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

/**
 * Statistics {@link Command}.
 */

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
