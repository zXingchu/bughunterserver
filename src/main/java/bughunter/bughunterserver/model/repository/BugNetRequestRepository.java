package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugNetRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugNetRequestRepository extends JpaRepository<BugNetRequest, Integer> {


}
