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

package org.symphonyoss.roomdesk.models.calls;

import junit.framework.TestCase;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

/**
 * Created by nicktarsillo on 7/11/16.
 */
public class MultiChatHelpCallTest extends TestCase {
    static MultiChatHelpCall multiChatHelpCall = mock(MultiChatHelpCall.class);


    public void testInitiateCall() throws Exception {
        Mockito.doCallRealMethod().when(multiChatHelpCall).initiateCall();

        try {
            multiChatHelpCall.initiateCall();
        }catch(Exception e){
            fail("Initiate call failed.");
        }

    }

    public void testEndCall() throws Exception {
        Mockito.doCallRealMethod().when(multiChatHelpCall).endCall();

        try {
            multiChatHelpCall.endCall();
        }catch(Exception e){
            fail("Initiate call failed.");
        }
    }
}