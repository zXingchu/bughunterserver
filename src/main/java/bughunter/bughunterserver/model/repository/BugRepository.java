package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<BugInfo, Integer> {


}
