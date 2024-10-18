package view;

public class ViewConsole {
	
	private static ViewConsole instance;
	
	private ViewConsole() {
		
	}
	
	public static ViewConsole getInstance() {
		
		if (instance == null) {
			instance = new ViewConsole();
		}
		
		return instance;
	}
	
	public void exibirMensagem(String msg) {
		System.out.println("\n" + msg + "\n");
	}

}
