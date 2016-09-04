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

package org.symphonyoss.proxydesk.models.calls;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nicktarsillo on 7/21/16.
 */
public class TimerThread extends Thread{
    public static Set<Timer> timerSet = new HashSet<Timer>();

    static{
        TimerThread timerThread = new TimerThread();
        timerThread.start();
    }

    public void run(){


        while(true){

            for(Timer timer: timerSet) {
                timer.setTime(timer.getTime() + 1);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }



}
