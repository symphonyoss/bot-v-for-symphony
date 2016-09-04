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

import org.symphonyoss.client.model.Chat;
import org.symphonyoss.roomdesk.listeners.service.CallServiceListener;

/**
 * A model that acts a skeleton for a MultiChatCall
 */
public abstract class MultiChatCall {
    protected CallServiceListener callServiceListener;

    public MultiChatCall() {
        callServiceListener = new CallServiceListener(this);
    }

    public abstract void initiateCall();

    public abstract void endCall();

    public abstract Chat getCallChat();

    public abstract CallTypes getCallType();

    public enum CallTypes {HELP_CALL}


}
