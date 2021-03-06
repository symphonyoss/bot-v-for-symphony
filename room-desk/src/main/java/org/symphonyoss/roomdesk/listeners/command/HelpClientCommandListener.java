/*
 *
 *
 * Copyright 2016 Symphony Communication Services, LLC
 *
 * Licensed to Symphony Communication Services, LLC under one
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

package org.symphonyoss.roomdesk.listeners.command;

import org.symphonyoss.ai.listeners.AiCommandListener;
import org.symphonyoss.ai.models.AiCommand;
import org.symphonyoss.client.SymphonyClient;
import org.symphonyoss.roomdesk.config.RoomBotConfig;
import org.symphonyoss.roomdesk.models.actions.OnlineMembersAction;

import static org.symphonyoss.roomdesk.config.RoomBotConfig.Config;

/**
 * Created by nicktarsillo on 6/20/16.
 * A extension of the ai command listener.
 * Initializes the required commands, used inside a help client listener.
 */
public class HelpClientCommandListener extends AiCommandListener {
    public HelpClientCommandListener(SymphonyClient symClient) {
        super(symClient);
        init();
    }

    private void init() {
        AiCommand command = new AiCommand(Config.getString(RoomBotConfig.ONLINE_MEMBERS), 0);
        command.addAction(new OnlineMembersAction());

        getActiveCommands().add(command);
    }


}
