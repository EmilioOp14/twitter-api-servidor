package org.vedruna.apitwitter1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vedruna.apitwitter1.persistance.model.User;

public interface FollowService {

    Page<User> getAllFollowingByUsername(String username, Pageable pageable);
    Page<User> getAllFollowersByUsername(String username, Pageable pageable);
    
}
