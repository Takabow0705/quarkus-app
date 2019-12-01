package jp.takabow;

import jp.takabow.app.api.v1.UserMasterResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RestApplication extends Application {
    private Set<Class<?>> resourceClasses;

    public RestApplication() {
        resourceClasses = new HashSet<>();
        resourceClasses.add(UserMasterResource.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return resourceClasses;
    }
}
