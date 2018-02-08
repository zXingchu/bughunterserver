package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.BugConsoleLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugConsoleLogRepository  extends JpaRepository<BugConsoleLog, Integer> {


}
