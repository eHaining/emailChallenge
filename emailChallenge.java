import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class emailChallenge {

	public static void main(String[] args) throws Exception{
		Scanner usernameInput = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username = usernameInput.nextLine();
		String userURLString = "https://www.ecs.soton.ac.uk/people/" + username;
	    URL userURL = new URL(userURLString);
		BufferedReader input = new BufferedReader(new InputStreamReader(userURL.openStream()));
		String str;
		while ((str = input.readLine()) != null) {
			if (str.contains("property=\"name\">")) {
				//System.out.println(str);
				String name = str.substring(str.indexOf("property=\"name\">"), str.indexOf("<em property=\"honorificSuffix\""));
				name = name.replace("property=\"name\">", "");
				System.out.println(name);
			}
		}


	}


}