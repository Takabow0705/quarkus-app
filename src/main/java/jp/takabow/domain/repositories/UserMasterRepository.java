package jp.takabow.domain.repositories;

import jp.takabow.domain.entity.UserMaster;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface UserMasterRepository {
    abstract UserMaster findByUserId(Long userId);

    abstract void save(UserMaster userMaster);

    abstract List<UserMaster> findAllUserInfo();

    abstract void deleteUserInfo(UserMaster userMaster);
}
