package com.yxf.demo.design;

import lombok.Getter;
import lombok.Setter;

/**
 * Description：建造者模式 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午3:00:18 <br>
 */
public class Builder {
	
	public static void main(String[] args) {
		Build build = new UserBuider();
		Director director = new Director(build);
		User user = director.getUser("yxf", "123", 21);
		System.out.println(user.toString());
		
		UsersBuilder users = UsersBuilder.builder()
		.setUserName("yxf")
		.setPassWord("123")
		.userBuilder();
		System.out.println(users.toString());
	}

}
/*************************方法一*************************************/
class UsersBuilder{
	
	private String userName;
	private String passWord;

	@Override
	public String toString() {
		return "UsersBuilder [userName=" + userName + ", passWord=" + passWord + "]";
	}

	private UsersBuilder(String userName,String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	// 静态方法，用于生成一个 Builder，这个不一定要有，不过写这个方法是一个很好的习惯，
    // 有些代码要求别人写 new User.UserBuilder().a()...build() 看上去就没那么好
	public static Builder builder() {
        return new Builder();
    }
	
	public static class Builder{
		
		private String userName;
		private String passWord;
		
		/**
		 * Description：返回方法返回this,启动链式调用 <br>
		 * author：袁小飞 <br>
		 * date：2019年7月4日 下午3:54:28 <br>
		 */
		public Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder setPassWord(String passWord) {
			this.passWord = passWord;
			return this;
		}
		
		public UsersBuilder userBuilder() {
			if (null == userName || null == passWord) {
				throw new RuntimeException("用户名和密码必填");
			}
			return new UsersBuilder(userName,passWord);
		}
	}
}


/*************************方法二*************************************/

/**
 * Description：目标类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午3:13:28 <br>
 */
@Setter
@Getter
class User{
	private String userName;
	private String passWord;
	private int age;
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + ", age=" + age + "]";
	}
}

/**
 * Description：构建建造抽象类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午3:14:25 <br>
 */
interface Build{
	public void createUserName(String userName);
	public void createPassWord(String passWord);
	public void createAge(int age);
	public User getUser();
	
}

/**
 * Description：具体的建造者 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午3:17:34 <br>
 */
class UserBuider implements Build{
	
	private User user = new User();

	@Override
	public void createUserName(String userName) {
		user.setUserName(userName);
	}

	@Override
	public void createPassWord(String passWord) {
		user.setPassWord(passWord);
	}

	@Override
	public void createAge(int age) {
		user.setAge(age);
	}

	@Override
	public User getUser() {
		return user;
	}
	
	
}

/**
 * Description：创建指挥者,用于设置Builder与创建具体对象 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午3:24:48 <br>
 */
class Director{
	
	private Build build = null;
	
	public Director(Build build) {
		this.build = build;
	}
	
	public void setBuild(Build build) {
		this.build = build;
	}
	
	public User getUser(String userName,String passWord,int age) {
		this.build.createUserName(userName);
		this.build.createPassWord(passWord);
		this.build.createAge(age);
		return this.build.getUser();
	}
}
