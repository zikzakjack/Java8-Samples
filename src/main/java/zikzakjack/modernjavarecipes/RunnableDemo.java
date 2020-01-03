package zikzakjack.modernjavarecipes;

public class RunnableDemo {

	public static void main(String args[]) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("inside runnable using an anonyumous inner class..");
			}
		}).start();

		new Thread(() -> System.out.println("inside thread constructor using lamda")).start();

		Runnable r = () -> System.out.println("lambda expression implementing the run method");
		new Thread(r).start();

	}

}
