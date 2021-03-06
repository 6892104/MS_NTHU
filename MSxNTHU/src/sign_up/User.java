package sign_up;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

import sign_up.SignUpServer.ConnectionThread;

public class User {
	private BufferedReader reader;
	private BufferedWriter writer;
	public HashMap<String, String> users;
	public HashMap<String, String> users_name;
	public ArrayList<String> isSignin;
	
	public User() {
			users = new HashMap<String, String>();
			users_name = new HashMap<String, String>();
			isSignin = new ArrayList<String>();
			updateUser();
	}
	
	private void updateUser(){
		try {
			String userName = new String();
			String userAccount = new String();
			String userPassword = new String();
			String userEmail = new String();
			URL u = new URL("http://s103062217.web.2y.idv.tw/java/pw.txt");
			Object obj=u.getContent();
			InputStreamReader isr = new InputStreamReader((InputStream) obj,"UTF-8");
			reader = new BufferedReader(isr);

			writer = new BufferedWriter(new FileWriter("resource/user_maintain/user_list.txt", false));
			String str = reader.readLine(); // name
			while(str != null) {
				writer.write(str + "\n");; // name
				writer.write(reader.readLine() + "\n");  //user account
				writer.write(reader.readLine() + "\n"); // pass word
				str = reader.readLine(); // email
				str = reader.readLine(); // name
			}
			writer.close();
			reader.close();
			
			users.clear();
			users_name.clear();
			reader = new BufferedReader(new FileReader(new File("resource/user_maintain/user_list.txt")));
			userName = reader.readLine();
			while(userName != null) {
				userAccount = reader.readLine();
				userPassword = reader.readLine();
				if(!(new File("resource/user_maintain/" + userAccount + ".txt").exists())) {
					Files.copy(new File("resource/user_maintain/model.txt").toPath(), new File("resource/user_maintain/" + userAccount + ".txt").toPath());
				}
				users.put(userAccount,  userPassword);
				users_name.put(userAccount,  userName);
				//userEmail = reader.readLine();
				userName = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkID(String inputAccount, String inputPassword) {
		updateUser();
		if(users.containsKey(inputAccount)) {
			if(users.get(inputAccount).equals(inputPassword) && !isSignin.contains(inputAccount)) {
				isSignin.add(inputAccount);
				return true;
			}
		}
		return false;
	}
	
	public void sendInfo(ConnectionThread connect, String userAccount) {
		try {
			connect.sendMessage(users_name.get(userAccount));
			reader = new BufferedReader(new FileReader(new File("resource/user_maintain/" + userAccount + ".txt")));
			String line = reader.readLine();
			while(line != null) {
				connect.sendMessage(line);
				line = reader.readLine();
			}
			connect.sendMessage("completed");
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeInfo(String inputAccount, String info) {
		try {
			writer = new BufferedWriter(new FileWriter("resource/user_maintain/" + inputAccount + ".txt", false));
			writer.write(info);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
