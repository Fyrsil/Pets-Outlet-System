package App;
import System.*;
public class MainApp {
	public static void main(String[] args) {
		IDataStore dataLists = new DataList();
		Controller controller = new Controller(dataLists);
		ConsoleUI userInterface = new ConsoleUI(controller);
		userInterface.start();
	}
}
