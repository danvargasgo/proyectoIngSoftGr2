package com.unal.cronus.model.repository;

import com.unal.cronus.data.Data;
import com.unal.cronus.model.entitity.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class SubjectRepositoryTest {
    @Autowired
    SubjectRepository subjectRepository;

    @BeforeEach
    void setUp (){

        subjectRepository.save(Data.subject1());
        subjectRepository.save(Data.subject2());
        subjectRepository.save(Data.subject3());
        subjectRepository.save(Data.subject4());
        subjectRepository.save(Data.subject5());
        subjectRepository.save(Data.subject6());
        subjectRepository.save(Data.subject7());
        subjectRepository.save(Data.subject8());
    }

    @Test
    @DisplayName("Buscar materia por nombre")
    void searchSubjectsByName() {
        //GIVEN
        String subjectName1 = "Calculo";
        String subjectName2 = "Ingenieria";
        String subjectName3 = "Matematicas";
        String subjectName4 = "Probabilidad";
        String subjectName5 = "";
        String subjectName6 = "CALCULO";
        String subjectName7 = "a";
        //WHEN
        List<Subject> expected =subjectRepository.searchSubjectsByName(subjectName1);
        List<Subject> expected2 =subjectRepository.searchSubjectsByName(subjectName2);
        List<Subject> expected3 =subjectRepository.searchSubjectsByName(subjectName3);
        List<Subject> expected4 =subjectRepository.searchSubjectsByName(subjectName4);
        List<Subject> expected5 =subjectRepository.searchSubjectsByName(subjectName5);
        List<Subject> expected6 =subjectRepository.searchSubjectsByName(subjectName6);
        List<Subject> expected7 =subjectRepository.searchSubjectsByName(subjectName7);

        //THEN
        assertThat(expected.size() == 4).isTrue();
        assertThat(expected2.size() == 2).isTrue();
        assertThat(expected3.size() == 2).isTrue();
        assertThat(expected4.size() == 0).isTrue();
        assertThat(expected5.size() == 8).isTrue();
        assertThat(expected6.size() == 0).isTrue();
        assertThat(expected7.size() == 8).isTrue();
    }

    @Test
    @DisplayName("Buscar materia por codigo")
    void searchSubjectsByCode() {
        //GIVEN
        int subjectCode = 2015162;
        int subjectCode2 = 0;


        //WHEN
        Subject expected =subjectRepository.searchSubjectsByCode(subjectCode);

        Subject expected2 =subjectRepository.searchSubjectsByCode(subjectCode2);


        //THEN
        assertThat(expected).isEqualTo(Data.subject1());
        assertThat(expected2).isNull();

    }
}