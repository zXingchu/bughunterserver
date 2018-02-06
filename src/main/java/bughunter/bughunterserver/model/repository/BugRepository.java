package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<BugInfo, Integer> {

    List<BugInfo> findAllByAppId(int appId);

}
