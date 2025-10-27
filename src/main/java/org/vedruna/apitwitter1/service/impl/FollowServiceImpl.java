package org.vedruna.apitwitter1.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.vedruna.apitwitter1.persistance.model.User;
import org.vedruna.apitwitter1.persistance.repository.FollowRepository;
import org.vedruna.apitwitter1.service.FollowService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class FollowServiceImpl implements FollowService{


    FollowRepository followRepository;

    @Override
    public Page<User> getAllFollowingByUsername(String username, Pageable pageable) {
        return followRepository.findAllFollowingByUsername(username, pageable);
    }

    @Override
    public Page<User> getAllFollowersByUsername(String username, Pageable pageable) {
        return followRepository.findAllFollowersByUsername(username, pageable);
    }

    
    
}
