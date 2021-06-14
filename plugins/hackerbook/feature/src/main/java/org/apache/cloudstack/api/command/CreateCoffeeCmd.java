// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.cloudstack.api.command;

import com.cloud.user.Account;
import org.apache.cloudstack.acl.RoleType;
import org.apache.cloudstack.api.APICommand;
import org.apache.cloudstack.api.ApiConstants;
//import org.apache.cloudstack.api.ApiErrorCode;
import org.apache.cloudstack.api.BaseCmd;
import org.apache.cloudstack.api.Parameter;
//import org.apache.cloudstack.api.ServerApiException;
//import org.apache.cloudstack.api.ApiArgValidator;
import org.apache.cloudstack.api.response.CreateCoffeeRes;
//import org.apache.cloudstack.context.CallContext;
import javax.inject.Inject;
//import org.apache.cloudstack.feature.Coffee;
import org.apache.cloudstack.feature.CoffeeManager;
import org.apache.cloudstack.api.response.ListResponse;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.log4j.Logger;

@APICommand(name = CreateCoffeeCmd.APINAME, description = "Create a coffee", responseObject = CreateCoffeeRes.class, since = "4.16.0", requestHasSensitiveInfo = false, responseHasSensitiveInfo = false, authorized = {RoleType.Admin, RoleType.ResourceAdmin, RoleType.DomainAdmin, RoleType.User})
public class CreateCoffeeCmd extends BaseCmd {
    public static final Logger LOG = Logger.getLogger(CreateCoffeeCmd.class);
    public static final String APINAME = "createCoffee";

    @Parameter(name = ApiConstants.NAME, type = CommandType.STRING, required = true, description = "Create a coffee with this name")
    private String name;

    @Inject
    private CoffeeManager coffeeManager;

    public String getCoffeeName() {
        return name;
    }

    @Override
    public String getCommandName() {
        return APINAME.toLowerCase() + BaseCmd.RESPONSE_SUFFIX;
    }

    @Override
    public long getEntityOwnerId() {
        return Account.ACCOUNT_ID_SYSTEM;
    }

    @Override
    public void execute() {
        final Hashtable<String, String> coffee = coffeeManager.createCoffee(this);
        final CreateCoffeeRes coffeeResponse = new CreateCoffeeRes();
        coffeeResponse.setId(coffee.get("id"));
        coffeeResponse.setName(coffee.get("name"));
        ArrayList<CreateCoffeeRes> responseList = new ArrayList<CreateCoffeeRes>();
        responseList.add(coffeeResponse);
        final ListResponse<CreateCoffeeRes> response = new ListResponse<>();
        response.setResponseName(getCommandName());
        response.setResponses(responseList);
        response.setObjectName("coffee");
        setResponseObject(response);
    }

}