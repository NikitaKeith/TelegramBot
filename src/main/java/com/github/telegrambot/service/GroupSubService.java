package com.github.telegrambot.service;

import com.github.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.github.telegrambot.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}