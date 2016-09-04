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

package org.symphonyoss.roomdesk.listeners.chat;

import junit.framework.TestCase;
import org.mockito.Mockito;
import org.symphonyoss.symphony.agent.model.Message;

import static org.mockito.Mockito.mock;

/**
 * Created by nicktarsillo on 7/11/16.
 */
public class MemberAliasListenerTest extends TestCase {
    static MemberAliasListener memberAliasListener = mock(MemberAliasListener.class);

    public void testOnChatMessage() throws Exception {
        Mockito.doCallRealMethod().when(memberAliasListener).onChatMessage(null);
        Mockito.doCallRealMethod().when(memberAliasListener).onChatMessage(new Message());

        try{
            memberAliasListener.onChatMessage(null);
        }catch(Exception e){
            fail("Member listener test failed.");
        }

        try{
            memberAliasListener.onChatMessage(new Message());
        }catch(Exception e){
            fail("Member listener test failed.");
        }
    }
}