package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class SelectListBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = BoardDAO.getInstance().selectList();
		request.setAttribute("list", list);

		ModelAndView mav = new ModelAndView("/board/listBoard.jsp", false);  // 포워드 이동
		return mav;
	}

}
