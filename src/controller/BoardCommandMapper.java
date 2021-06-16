package controller;

import command.BoardCommand;
import command.DeleteBoardCommand;
import command.InsertBoardCommand;
import command.InsertBoardPageCommand;
import command.InsertReplyCommand;
import command.SelectListBoardCommand;
import command.SelectOneBoardCommand;
import command.ToBoardCommand;

public class BoardCommandMapper {
	private static BoardCommandMapper instance = new BoardCommandMapper();
	private BoardCommandMapper() {}
	public static BoardCommandMapper getInstance() {
		if (instance == null) {
			instance = new BoardCommandMapper();
		}
		return instance;
	}
	public BoardCommand getCommand(String cmd) {
		BoardCommand command = null;
		switch (cmd) {
		case "selectListBoardCommand.do":
			command=new SelectListBoardCommand();
			break;
		case "insertBoardPage.do":
			command = new InsertBoardPageCommand();
			break;
		case "insertBoard.do":
			command = new InsertBoardCommand();
			break;
		case "selectOneBoard.do":
			command = new SelectOneBoardCommand();
			break;
		case "board.do":
			command= new ToBoardCommand();
			break;
		case "insertReply.do":
			command = new InsertReplyCommand();
			break;
		case "deleteBoard.do":
			command = new DeleteBoardCommand();
			break;
		}
		
		
		return command;
		}
}
