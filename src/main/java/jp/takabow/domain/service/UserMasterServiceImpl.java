package jp.takabow.domain.service;

import jp.takabow.domain.entity.UserMaster;
import jp.takabow.domain.repositories.UserMasterRepository;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Priority(0)
public class UserMasterServiceImpl implements UserMasterService {

    /**
     * ユーザ情報のレポジトリ
     */
    private UserMasterRepository userMasterRepository;

    UserMasterServiceImpl() {
    }

    /**
     * ネイティブ化を見越してコンストラクターインジェクションで実装する。
     *
     * @param userMasterRepository
     */
    @Inject
    public UserMasterServiceImpl(UserMasterRepository userMasterRepository) {
        this.userMasterRepository = userMasterRepository;
    }

    @Override
    public UserMaster findByUserId(Long userId) {
        return this.userMasterRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void save(UserMaster userMaster) {
        this.userMasterRepository.save(userMaster);
    }

    @Override
    public List<UserMaster> findAllUserInfo() {
        return this.userMasterRepository.findAllUserInfo();
    }

    @Override
    @Transactional
    public void deleteUserInfo(UserMaster userMaster) {
        this.userMasterRepository.deleteUserInfo(userMaster);
    }

}
