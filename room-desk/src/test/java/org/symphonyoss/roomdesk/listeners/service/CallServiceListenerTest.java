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

package org.symphonyoss.roomdesk.listeners.service;

import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.client.model.Chat;
import org.symphonyoss.symphony.pod.model.Stream;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

/**
 * Created by nicktarsillo on 6/22/16.
 */
public class CallServiceListenerTest {

    @Test
    public void testOnRemovedChat() throws Exception {
        CallServiceListener listener = mock(CallServiceListener.class);
        Mockito.doCallRealMethod().when(listener).onRemovedChat(null);
        Mockito.doCallRealMethod().when(listener).onRemovedChat(new Chat());

        try {
            listener.onRemovedChat(null);
        } catch (Exception e) {
            fail("Listen on null test failed.");
        }

        Chat chat = new Chat();
        try {
            listener.onRemovedChat(chat);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Listen on empty web test failed.");
        }

        chat.setStream(new Stream());
        try {
            listener.onRemovedChat(chat);
        } catch (Exception e) {
            fail("Listen on junk stream, empty web test failed.");
        }
    }
}