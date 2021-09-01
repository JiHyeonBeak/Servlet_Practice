package Action;

public class ActionFactory {
	public Action getAction(String command) {
		Action action = null;
		System.out.println("Action Factory:"+command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}
		return action;
	}
}
