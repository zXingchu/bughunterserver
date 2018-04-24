package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugBaseInfo;
import bughunter.bughunterserver.model.entity.BugInfoKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<BugBaseInfo, BugInfoKeys> {

    List<BugBaseInfo> findAllByAppKey(String appKey);

    List<BugBaseInfo> findByAppKeyAndAppVersion(String appKey,String appVersion);

    List<BugBaseInfo> findAllByAppKeyAndCurrent(String appKey, String current);

    List<BugBaseInfo> findByAppKeyAndStatusInAndTypeInAndPriorityIn(String appKey, Collection<String> status, Collection<String> type, Collection<String> priority);

}
