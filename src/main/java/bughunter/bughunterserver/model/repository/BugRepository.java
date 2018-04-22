package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugBaseInfo;
import bughunter.bughunterserver.model.entity.BugInfoKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<BugBaseInfo, BugInfoKeys> {

    List<BugBaseInfo> findAllByAppKey(String appKey);

    List<BugBaseInfo> findAllByAppKeyAndCurrent(String appKey,String current);

}
