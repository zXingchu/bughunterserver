package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.AppMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppMemberRepository extends JpaRepository<AppMember, Integer>{

    List<AppMember> findByUId(Integer uId);

    List<AppMember> findAllByUId(int uId);

}
