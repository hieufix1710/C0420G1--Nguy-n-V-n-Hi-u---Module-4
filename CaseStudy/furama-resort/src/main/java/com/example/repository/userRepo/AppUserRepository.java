package com.example.repository.userRepo;

import com.example.entity.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
    @Query ( value ="select count ('ROLE_ID') from app_role", nativeQuery=true)
    Long countAppUserId ();
}
