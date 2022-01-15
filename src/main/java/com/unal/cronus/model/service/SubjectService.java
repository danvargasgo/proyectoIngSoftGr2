package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> searchSubjectsByName(String keyword);
    Subject searchSubjectsByCode(int code);
}