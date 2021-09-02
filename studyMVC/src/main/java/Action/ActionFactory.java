package Action;

public class ActionFactory {
	public Action getAction(String command) {
		Action action = null;
		System.out.println("Action Factory:"+command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_view")){
			action = new BoardViewAction();
		}
		return action;
	}
}
