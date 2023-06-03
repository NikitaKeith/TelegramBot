package com.github.telegrambot.service;

import com.github.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.github.telegrambot.repository.entity.GroupSub;

import java.util.Optional;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub groupSub);
    Optional<GroupSub> findById(Integer id);
}