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

package org.symphonyoss.proxydesk.models.permissions;

import org.symphonyoss.ai.models.AiPermission;
import org.symphonyoss.proxydesk.utils.DeskUserCache;

/**
 * Created by nicktarsillo on 6/20/16.
 * A permission, that denies access to those who are in a call
 */
public class OffCall implements AiPermission {

    public boolean userHasPermission(Long userID) {
        return !DeskUserCache.getDeskUser(userID.toString()).isOnCall();
    }


}
