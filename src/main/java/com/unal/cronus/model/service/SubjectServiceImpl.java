package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Grupo;
import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<Subject> searchSubjectsByGrupos(List<Grupo> grupos) {
        /*List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < grupos.size(); i++) {
            Subject subject = subjectRepository.searchSubjectsByCode(grupos.get(i).getSubject());
            if (subjects.contains(subject) == false) {
                subjects.add(subject);
            }
        }*/
        return null;
    }

    @Override
    public List<Integer> findSubjectsCodes(List<Grupo> grupos) {
        List<Integer> subjectsCodes = new ArrayList<Integer>();

        for (Grupo group : grupos) {
            if (!subjectsCodes.contains(group.getSubject().getCode())) {
                subjectsCodes.add(group.getSubject().getCode());
            }
        }

        return subjectsCodes;
    }
}
