/*
 *
 *
 * Copyright 2016 The Symphony Software Foundation
 *
 * Licensed to The Symphony Software Foundation (SSF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.symphonyoss.ai.utils;

import org.symphonyoss.client.SymphonyClient;
import org.symphonyoss.client.model.Chat;
import org.symphonyoss.symphony.agent.model.Message;
import org.symphonyoss.symphony.agent.model.MessageSubmission;
import org.symphonyoss.symphony.pod.model.Stream;
import org.symphonyoss.symphony.pod.model.UserIdList;

/**
 * Created by nicktarsillo on 6/14/16.
 */
public class Messenger {
    public static void sendMessage(String message, MessageSubmission.FormatEnum type, Long userID, SymphonyClient symClient) {
        MessageSubmission userMessage = new MessageSubmission();
        userMessage.setFormat(type);
        userMessage.setMessage(message);

        UserIdList list = new UserIdList();
        list.add(userID);
        try {
            symClient.getMessagesClient().sendMessage(symClient.getStreamsClient().getStream(list), userMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(String message, MessageSubmission.FormatEnum type, String email, SymphonyClient symClient) {
        MessageSubmission userMessage = new MessageSubmission();
        userMessage.setFormat(type);
        userMessage.setMessage(message);

        try {
            symClient.getMessageService().sendMessage(email, userMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(String message, MessageSubmission.FormatEnum type, Message refMes, SymphonyClient symClient) {
        MessageSubmission userMessage = new MessageSubmission();
        userMessage.setFormat(type);
        userMessage.setMessage(message);

        Stream stream = new Stream();
        stream.setId(refMes.getStreamId());
        try {
            symClient.getMessagesClient().sendMessage(stream, userMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(String message, MessageSubmission.FormatEnum type, Chat chat, SymphonyClient symClient) {
        MessageSubmission userMessage = new MessageSubmission();
        userMessage.setFormat(type);
        userMessage.setMessage(message);

        try {
            symClient.getMessageService().sendMessage(chat, userMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Chat getChat(Long userID, SymphonyClient symClient) {
        UserIdList list = new UserIdList();
        list.add(userID);
        Stream stream = null;
        try {
            stream = symClient.getStreamsClient().getStream(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return symClient.getChatService().getChatByStream(stream.getId());
    }
}
