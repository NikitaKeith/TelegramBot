package com.github.telegrambot.command.annotation;

import java.lang.annotation.Retention;
import com.github.telegrambot.command.Command;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Mark if {@link Command} can be viewed only by admins.
 */
@Retention(RUNTIME)
public @interface AdminCommand {
}