package io.github.biezhi.db;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by biezhi on 2017/3/26.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
