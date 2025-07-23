package com.yashh.service;

import com.yashh.domain.PlanType;
import com.yashh.model.Subscription;
import com.yashh.model.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);
    Subscription getUserSubscription(Long userId) throws Exception;
    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
