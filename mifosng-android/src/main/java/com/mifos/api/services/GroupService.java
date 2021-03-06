/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.group.Group;
import com.mifos.objects.group.GroupWithAssociations;
import com.mifos.services.data.GroupPayload;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * @author fomenkoo
 */
public interface GroupService {
    @GET(APIEndPoint.GROUPS + "/{groupId}?associations=all")
    void getGroupWithAssociations(@Path("groupId") int groupId, Callback<GroupWithAssociations> groupWithAssociationsCallback);

    @GET(APIEndPoint.GROUPS)
    void getAllGroupsInOffice(@Query("officeId") int officeId, @QueryMap Map<String, Object> params, Callback<List<Group>> listOfGroupsCallback);

    @POST(APIEndPoint.GROUPS)
    void createGroup(@Body GroupPayload groupPayload, Callback<Group> callback);

}
