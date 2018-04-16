package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugBaseInfo;
import bughunter.bughunterserver.model.entity.BugInfoKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<BugBaseInfo, BugInfoKeys> {

    List<BugBaseInfo> findAllByAppId(int appId);

    List<BugBaseInfo> findAllByBugId(int bugId);

    List<BugBaseInfo> findAllByBugIdAAndAndAppId(int bugId,int appId);

}
