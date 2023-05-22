package com.tikkeul.app.dao;

import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.InquiryBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.AnswerVO;
import com.tikkeul.app.domain.vo.UserVO;
import com.tikkeul.app.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDAO {

    @Autowired
    private final AdminMapper adminMapper;

    /*회원*/
    public List<UserVO> adminFindUserAll(){
        return adminMapper.adminSelectUserAll();
    }

    // 관리자페이지에서 회원 삭제
    public void adminDeleteUser(Long id){
         adminMapper.adminDeleteUser(id);
    }

    /* 문의 */
    //    관리자 페이지에서 문의 내역 전체 조회
    public List<InquiryBoardDTO> adminFindInquiryAll(Pagination pagination, Search search){
        return adminMapper.adminSelectInquiryAll(pagination, search);
    }

    //    관리자 페이지에서 문의 내역 상세 조회
    public Optional<InquiryBoardDTO> adminFindInquiry(Long id){
        return adminMapper.adminSelectInquiry(id);
    }

    //  관리자페이지에서  문의 내역 총개수
    public int findCountOfInquiry(Search search){
        return adminMapper.selectCountOfInquiry(search);
    }


    //    관리자 페이지에서 문의 답변
    public void adminSaveAnswer(AnswerVO answerVO){
            adminMapper.adminInsertAnswer(answerVO);
    }

    /*도란 게시판*/
    //    관리자 페이지에서 도란보드 목록 조회
    public List<DoranBoardDTO> adminFindDoranBoardAll(Pagination pagination, Search search){
        return adminMapper.adminSelectDoranBoardAll(pagination, search);
    }

    //  관리자 페이지에서 도란 보드 총 개수
    public int findCountOfDoranBoard(Search search){
        return adminMapper.selectCountOfDoranBoard(search);
    }

//    관리자 페이지에서 도란 보드 상세조회
    public Optional<DoranBoardDTO> adminFindDoranBoardById(Long id){
        return adminMapper.adminSelectDoranBoard(id);
    }


}
