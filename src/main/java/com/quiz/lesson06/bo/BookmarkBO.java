package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// input: url
	// output: boolean 		중복: true 	사용가능: false
	public boolean isDuplicateUrl(String url) {
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkByUrl(url);
		// [] => false 사용가능
		// [O] [O, O] => true 중복
//		if (bookmarkList.isEmpty()) {
//			return false;
//		}
//		return true;
		
//		return bookmarkList.isEmpty() ? false : true;
		return !bookmarkList.isEmpty();
	}
	
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
}
