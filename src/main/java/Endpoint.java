import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/presentr")
public class Endpoint {
	private List<User> onlineUsers = new CopyOnWriteArrayList<User>();
	
	@RequestMapping("/available-users")
	public String getOnlineUsers() {
		StringBuilder sb = new StringBuilder();
		for (User user : onlineUsers) {
			sb.append(user.getLogin()).append(":").append(new Date().getTime()).append("\n");
		}
		return sb.toString();
	}
	
	@RequestMapping(value = "/available-users/{login}", method = RequestMethod.POST)
	public void login(@PathVariable String login) {
		onlineUsers.add(new User(login));
	}

	
	public static void main(String[] args) {
		SpringApplication.run(Endpoint.class, args);
	}
}
