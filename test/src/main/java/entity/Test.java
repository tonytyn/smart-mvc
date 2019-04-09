package entity;

public class Test {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("user");
		change(user);
		System.out.println(user.getUsername());
	}
	public static void change(User user) {
		user.setUsername("123");
		/*User user2 = new User();
		user2.setUsername("user2");
		user=user2;*/
		
	}
}
