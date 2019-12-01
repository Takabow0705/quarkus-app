package jp.takabow.domain.repositories;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jp.takabow.domain.entity.UserMaster;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
@Priority(0)
public class UserMasterRepositoryImpl implements PanacheRepository<UserMaster>, UserMasterRepository {
    @Override
    public UserMaster findByUserId(Long id) {
        return find("id", id).firstResult();
    }

    @Override
    public void save(UserMaster userMaster) {
        persist(userMaster);
    }

    @Override
    public List<UserMaster> findAllUserInfo() {
        return findAll().list();
    }

    public void deleteUserInfo(UserMaster userMaster) {
        delete(userMaster);
    }

}
