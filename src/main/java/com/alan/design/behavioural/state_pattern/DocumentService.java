package com.alan.design.behavioural.state_pattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DocumentService {
    private String action = ""; // for test

    public void draftDocument() {
        action = "draft";
        log.info("Document draft");
    }

    public void submitDocument() {
        action = "submit";
        log.info("Document submit");
    }

    public void managerReviewDocument() {
        action = "managerReview";
        log.info("Document manager review");
    }

    public void publishDocument() {
        action = "published";
        log.info("Document published");
    }

    public String getAction() {
        return action;
    }
}
