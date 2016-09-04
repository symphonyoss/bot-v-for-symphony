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
public class TranscriptListenerTest extends TestCase {
    static TranscriptListener transcriptListener = mock(TranscriptListener.class);

    public void testOnChatMessage() throws Exception {
        Mockito.doCallRealMethod().when(transcriptListener).onChatMessage(null);
        Mockito.doCallRealMethod().when(transcriptListener).onChatMessage(new Message());

        try{
            transcriptListener.onChatMessage(null);
        }catch(Exception e){
            fail("Transcript test failed.");
        }

        try{
            transcriptListener.onChatMessage(new Message());
        }catch(Exception e){
            fail("Transcript test failed.");
        }
    }

    public void testWrite() throws Exception {
        Mockito.doCallRealMethod().when(transcriptListener).write(null);

        try{
            transcriptListener.onChatMessage(null);
        }catch(Exception e){
            fail("Transcript test failed.");
        }
    }
}