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

package org.symphonyoss.proxydesk.models.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.symphonyoss.ai.constants.MLTypes;
import org.symphonyoss.proxydesk.models.calls.Call;
import org.symphonyoss.proxydesk.models.calls.Timer;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by nicktarsillo on 6/14/16.
 * A model that represents a help client.
 */
public class HelpClient implements DeskUser {
    @JsonIgnore
    protected Call call;
    private String email;
    private Long userID;
    private boolean onCall;
    private Set<String> helpRequests = new LinkedHashSet<String>();
    private Timer pickUpTimer;

    public HelpClient(String email, Long userID) {
        setEmail(email);
        setUserID(userID);
        setPickUpTimer(new Timer());
    }

    /**
     * @return the type of user (Help Client)
     */
    public DeskUserType getUserType() {
        return DeskUserType.HELP_CLIENT;
    }

    /**
     * @return a summary of all the clients help requests
     */
    public String getHelpSummary() {
        String help;


        if (email != null && !email.equalsIgnoreCase("")) {

            help = MLTypes.START_BOLD + "    For " + email + ": "
                    + MLTypes.END_BOLD + MLTypes.BREAK;

        } else {

            help = MLTypes.START_BOLD + "    For " + userID + ": "
                    + MLTypes.END_BOLD + MLTypes.BREAK;

        }


        for (String line : helpRequests) {
            help += "       " + line + MLTypes.BREAK + MLTypes.BREAK;
        }

        return help;
    }

    public Set<String> getHelpRequests() {
        return helpRequests;
    }

    public void setHelpRequests(Set<String> helpRequests) {
        this.helpRequests = helpRequests;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public boolean isOnCall() {
        return onCall;
    }

    public void setOnCall(boolean onCall) {
        this.onCall = onCall;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Timer getPickUpTimer() {
        return pickUpTimer;
    }

    public void setPickUpTimer(Timer pickUpTimer) {
        this.pickUpTimer = pickUpTimer;
    }
}
