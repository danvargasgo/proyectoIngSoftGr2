package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Subject> searchSubjectsByName(String keyword) {
        return subjectRepository.searchSubjectsByName(keyword);
    }

    @Override
    @Transactional(readOnly = true)
    public Subject searchSubjectsByCode(int code) {
        return subjectRepository.searchSubjectsByCode(code);
    }
}
