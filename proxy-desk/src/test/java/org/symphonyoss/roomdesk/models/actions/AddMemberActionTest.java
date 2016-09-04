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

package org.symphonyoss.roomdesk.models.actions;

import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.ai.models.AiCommand;
import org.symphonyoss.client.util.MlMessageParser;
import org.symphonyoss.proxydesk.models.actions.AddMemberAction;
import org.symphonyoss.symphony.agent.model.Message;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

/**
 * Created by nicktarsillo on 6/22/16.
 */
public class AddMemberActionTest {

    @Test
    public void testRespond() throws Exception {
        AddMemberAction action = mock(AddMemberAction.class);
        Mockito.doCallRealMethod().when(action).respond(new MlMessageParser(), null, null);
        Mockito.doCallRealMethod().when(action).respond(new MlMessageParser(), new Message(), new AiCommand("", 0));


        try {
            action.respond(new MlMessageParser(), null, null);
        } catch (Exception e) {
            fail("Action failed.");
        }

        try {
            action.respond(new MlMessageParser(), new Message(), new AiCommand("", 0));
        } catch (Exception e) {
            fail("Action failed.");
        }
    }
}