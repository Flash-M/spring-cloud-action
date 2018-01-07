package top.flashm.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import top.flashm.springcloud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
