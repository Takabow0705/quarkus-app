package jp.takabow.domain.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jp.takabow.domain.entity.UserMaster;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface UserMasterService {
    abstract UserMaster findByUserId(Long userId);

    abstract void save(UserMaster userMaster);

    abstract List<UserMaster> findAllUserInfo();

    abstract void deleteUserInfo(UserMaster userMaster);
}
