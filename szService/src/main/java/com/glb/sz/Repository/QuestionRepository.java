package com.glb.sz.Repository;

import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    @Query(value = "select new com.glb.sz.model.dto.QuestionDTO(q.questionDesc,q.questionNum) from Question q " +
            "where q.paperId=?1")
    List<QuestionDTO> getQuestionByPaper(Integer paperId);

    @Query(value = "select new com.glb.sz.model.dto.QuestionDTO(q.questionDesc,q.questionNum) from Question q " +
            "where q.paperId=?1 and q.questionNum=?2")
    QuestionDTO getAQuestionByPaper(Integer paperId,Integer questionNum);

}
