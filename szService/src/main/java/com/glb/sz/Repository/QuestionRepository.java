package com.glb.sz.Repository;

import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value = "select new com.glb.sz.model.dto.QuestionDTO(q.questionDesc,q.questionNum) from Question q " +
            "where q.paperId=?1 and q.stateId=1")
    List<QuestionDTO> getQuestionByPaper(Integer paperId);

    @Query(value = "select new com.glb.sz.model.dto.QuestionDTO(q.questionDesc,q.questionNum) from Question q " +
            "where q.paperId=?1 and q.questionNum=?2 and q.stateId=1")
    QuestionDTO getAQuestionByPaper(Integer paperId, Integer questionNum);

    @Query(value = "select count(q.question_desc) from paper p,question q " +
            "where p.paper_id=?1 and q.paper_id=p.paper_id and q.state_id = 1",nativeQuery = true)
    Integer getQuestionCount(Integer paperId);

    @Query(value = "update question set question_desc=?3 where paper_id=?1 and question_num=?2 and state_id=1",nativeQuery = true)
    @Modifying
    Integer resetQuestion(Integer paperId,Integer questionNum,String questionDesc);

    @Query(value = "update question set question_desc=?2 where question_id=?1",nativeQuery = true)
    @Modifying
    Integer resetQuestion(Integer questionId,String questionDesc);

    @Query(value = "update question set state_id=2 where paper_id=?1 and question_num=?2 and state_id=1",nativeQuery = true)
    @Modifying
    Integer deleteQuestion(Integer paperId,Integer questionNum);

}
