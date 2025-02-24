package ccoem_admin1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import ccoem_admin1.models.User;

import java.io.File;
import java.util.List;

public class JsonReader {
	public static List<User> getUsers(String filePath) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(new File(filePath), UserList.class).getUsers();
		} catch (Exception e) {
			throw new RuntimeException("Failed to read user data from JSON", e);
		}
	}
}

// Helper class for JSON mapping
class UserList {
	private List<User> users;

	public List<User> getUsers() { 
		return users;
	}
	public void setUsers(List<User> users) { 
		this.users = users;
	}
}
