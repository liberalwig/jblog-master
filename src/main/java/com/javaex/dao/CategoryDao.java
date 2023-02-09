package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	SqlSession sqlSession;
	
	//회원가입시 첫 카테고리 강제 생성
	public void setFirst(CategoryVo categoryVo) {
		System.out.println("[CategoryDao.setFirst]");
		
		int count = sqlSession.insert("category.setFirst", categoryVo);
		System.out.println("["+count+"건이 추가되었습니다.(CategoryDao)]");
	}
	
	//카테고리 리스트 가져오기(asc)
	public List<CategoryVo> getCategory(String id){
		System.out.println("[CategoryDao.getCategory]");
		return sqlSession.selectList("category.getList", id);
	}
	
	//카테고리 리스트 가져오기(desc)
	public List<CategoryVo> getCategoryDesc(String id){
		System.out.println("[CategoryDao.getCategoryDesc]");
		return sqlSession.selectList("category.getListDesc", id);
	}
	
	//카테고리 추가
	public int addCategory(CategoryVo categoryVo) {
		System.out.println("[CategoryDao.addCategory]");
		System.out.println(categoryVo);
		int count = sqlSession.insert("category.addCategory", categoryVo);
		System.out.println("["+count+"건이 추가되었습니다.(CategoryDao)]");
		
		return count;
	}
	
	//카테고리 삭제
	public int delCategory(int cateNo) {
		System.out.println("[CategoryDao.delCategory]");
		System.out.println(cateNo);
		int count = sqlSession.delete("category.delCategory", cateNo);
		
		System.out.println("["+count+"건이 삭제되었습니다.(CategoryDao)]");
		return count;
	}
}
