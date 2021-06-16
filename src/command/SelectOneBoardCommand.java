package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;
import dto.ReplyDTO;

public class SelectOneBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		long no = Long.parseLong(request.getParameter("no"));
		if (session.getAttribute("open") == null) {
		       BoardDAO.getInstance().updateHit(no);
		       session.setAttribute("open", true);
		   }
		BoardDTO dto = BoardDAO.getInstance().selectOneBoardByNo(no);
		request.setAttribute("dto", dto);
		List<ReplyDTO> replyList = BoardDAO.getInstance().selectListReply(no); 
		request.setAttribute("replyList", replyList);
		ModelAndView mav = new ModelAndView("/board/viewBoard.jsp", false);  // forward
		return mav;
	}
	}


