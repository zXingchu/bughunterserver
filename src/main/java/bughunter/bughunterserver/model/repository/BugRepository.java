package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<BugBaseInfo, Integer> {

    List<BugBaseInfo> findAllByAppId(int appId);

}
