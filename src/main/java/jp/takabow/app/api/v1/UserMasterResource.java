package jp.takabow.app.api.v1;

import jp.takabow.domain.entity.UserMaster;
import jp.takabow.domain.service.UserMasterService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Path("/api/v1/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserMasterResource {

    private UserMasterService userMasterService;

    @Inject
    public UserMasterResource(UserMasterService userMasterService) {
        this.userMasterService = userMasterService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserMaster fetchUserInfo(@QueryParam("userId") Long userId) {
        return this.userMasterService.findByUserId(userId);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserMaster> fetchAllUserInfo() {
        return this.userMasterService.findAllUserInfo();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUserInfo(Map<String, String> json) {
        UserMaster userMaster = new UserMaster();
        try {

            userMaster.setUserName(json.get("userName"));
            userMaster.setMailAddress(json.get("mailAddress"));
            userMaster.setAddress(json.get("address"));

            this.userMasterService.save(userMaster);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.fillInStackTrace()).build();
        }
        return Response.accepted().entity(userMaster).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserInfo(Map<String, String> json) {
        try {
            UserMaster target = this.userMasterService.findByUserId(Long.valueOf(json.get("userId")));
            if (target == null) {
                return Response.notModified().entity("対象のIDに紐つくユーザ情報は存在しません").build();
            }
            this.userMasterService.deleteUserInfo(target);
            target.setUserName(json.get("userName"));
            target.setMailAddress(json.get("mailAddress"));
            target.setAddress(json.get("address"));

            this.userMasterService.save(target);
        } catch (Exception e) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(e.fillInStackTrace()).build();
        }
        return Response.accepted().build();
    }
}
