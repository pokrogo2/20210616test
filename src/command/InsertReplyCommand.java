package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.ReplyDTO;

public class InsertReplyCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String content = request.getParameter("content");
		long boardIdx = Long.parseLong(request.getParameter("boardIdx"));
		String author = request.getParameter("author");
		
		ReplyDTO dto = new ReplyDTO();
		dto.setAuthor(author);
		dto.setBoardNo(boardIdx);
		dto.setContent(content);
		int result = BoardDAO.getInstance().insertReply(dto);
		ModelAndView mav = null;
		try {
			if (result == 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('댓글이 작성되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('댓글이 작성되었습니다.')");
				out.println("</script>");
				mav = new ModelAndView("/ServerProgram3/selectOneBoard.do?no=" + boardIdx, true);  // redirect
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;

	}

}
