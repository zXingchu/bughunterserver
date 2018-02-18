package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugUserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugUserDataRepository  extends JpaRepository<BugUserData, Integer> {



}
