package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ModelAndView mav = null;
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		String author = request.getParameter("author");
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setAuthor(author);
		int result = BoardDAO.getInstance().insertBoard(dto);
	
		try {
			if (result == 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('게시글이 저장되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				mav = new ModelAndView("/ServerProgram3/selectListBoardCommand.do", true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	return mav;
	}

}
