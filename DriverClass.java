import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverClass {

	public static String inp;
	public static Scanner x;
	
	// ---------------------------------------------- Write Resume ------------------------------------------------------
	public static void writeResume(String filePath, ArrayList<Resume> resumes, Resume resume) {
		
		File f = new File(filePath);
		FileWriter fw = null;
		try {
			if (!f.exists()) {
				fw = new FileWriter(f,true);
				fw.append("Title, Name, Address, Email, Mobile, Degree, Skills, Work Experience, Projects, Reference");
				fw.append("\n");
			}
			else {
				x = new Scanner(new File(filePath));
				if (!x.hasNext()) {
					fw = new FileWriter(f,true);
					fw.append("Title, Name, Address, Email, Mobile, Degree, Skills, Work Experience, Projects, Reference");
					fw.append("\n");
				}
				else {
					fw = new FileWriter(f,true);
				}
				
			}
			
			for(Resume r: resumes) {
				fw.append(r.getTitle());
				fw.append(",");
				fw.append(r.getName());
				fw.append(",");
				fw.append(r.getAddress());
				fw.append(",");
				fw.append(r.getEmail());
				fw.append(",");
				fw.append(r.getMobile());
				fw.append(",");
				fw.append(r.getDegree());
				fw.append(",");
				fw.append(r.getSkills());
				fw.append(",");
				fw.append(r.getWorkExp());
				fw.append(",");
				fw.append(r.getProjects());
				fw.append(",");
				fw.append(r.getRefference());
				fw.append("\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.flush();
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// ---------------------------------------------- Read Resume ------------------------------------------------------
	public static void readResume(String filePath) {

		BufferedReader br = null;
		
		try {
			ArrayList<Resume> resumes = new ArrayList<Resume>();
			String line = "";
			br = new BufferedReader(new FileReader(filePath));
			br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] f = line.split(",");
				
				if(f.length>0) {
					Resume resume = new Resume();
					resume.setTitle(f[0]);
					resume.setName(f[1]);
					resume.setAddress(f[2]);
					resume.setEmail(f[3]);
					resume.setMobile(f[4]);
					resume.setDegree(f[5]);
					resume.setSkills(f[6]);
					resume.setWorkExp(f[7]);
					resume.setProjects(f[8]);
					resume.setRefference(f[9]);
					resumes.add(resume);
				}
			}
			System.out.println("\n-----------------------------------=========================---------------------------------\n");
			for(Resume r: resumes) {
				System.out.printf("[Title = %s, Name = %s, Address = %s, Email = %s, Mobile = %s, Degree = %s, Skills = %s, Work Experience = %s, Projects = %s, Reference = %s]\n", r.getTitle(),r.getName(),r.getAddress(),r.getEmail(),r.getMobile(),r.getDegree(),r.getSkills(),r.getWorkExp(),r.getProjects(),r.getRefference());
			}
			System.out.println("\n-----------------------------------=========================---------------------------------\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// ---------------------------------------------- Search Resume ------------------------------------------------------
	public static void searchResume(String filePath, String n) {
		
		BufferedReader br = null;
		
		try {
			ArrayList<Resume> resumes = new ArrayList<Resume>();
			String line = "";
			br = new BufferedReader(new FileReader(filePath));
			br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] f = line.split(",");
				
				if(f.length>0) {
					Resume resume = new Resume();
					resume.setTitle(f[0]);
					resume.setName(f[1]);
					resume.setAddress(f[2]);
					resume.setEmail(f[3]);
					resume.setMobile(f[4]);
					resume.setDegree(f[5]);
					resume.setSkills(f[6]);
					resume.setWorkExp(f[7]);
					resume.setProjects(f[8]);
					resume.setRefference(f[9]);
					resumes.add(resume);
				}
			}
			
			int flag = 0;
			
			for(Resume r: resumes) {
				if(r.getTitle().equals(n)) {
					System.out.printf("[Title = %s, Name = %s, Address = %s, Email = %s, Mobile = %s, Degree = %s, Skills = %s, Work Experience = %s, Projects = %s, Reference = %s]\n", r.getTitle(),r.getName(),r.getAddress(),r.getEmail(),r.getMobile(),r.getDegree(),r.getSkills(),r.getWorkExp(),r.getProjects(),r.getRefference());
					flag=1;
				}
			}
			if(flag == 0) {
				System.out.println("Not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// ------------------------------------------- User Information Delete --------------------------------------------------
	public static void userInfoDelete(String filePathUser) {
		
		try {
			File f = new File(filePathUser);
			f.delete();
			System.out.println("Deletion successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ---------------------------------------------- User Information ------------------------------------------------------
		public static void userInfoWriteCsv(String filePathUser,ArrayList<User> users, User user) {

			File file = new File(filePathUser);
			FileWriter fw = null;
			try {
				if (!file.exists()) {
					fw = new FileWriter(file,true);
					fw.append("User Name, Password");
					fw.append("\n");
				}
				else {
					x = new Scanner(new File(filePathUser));
					if (!x.hasNext()) {
						fw = new FileWriter(file,true);
						fw.append("User Name, Password");
						fw.append("\n");
					}
					else {
						fw = new FileWriter(file,true);
					}
				}
				for(User r: users) {
					fw.append(r.getUserName());
					fw.append(",");
					fw.append(r.getPassword());
					fw.append("\n");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					fw.flush();
					fw.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		// ---------------------------------------------- Check User Info ------------------------------------------------------
		static boolean s = false;
		public static boolean userInfoCheckCsv(String filePathUser, String n, String p) {
			
			File file = new File(filePathUser);
			FileWriter fw = null;
			BufferedReader br = null;
			
			try {
				if(!file.exists()) {
					fw = new FileWriter(file,true);
					fw.append("User Name, Password");
					fw.append("\n");
				}
				ArrayList<User> users = new ArrayList<User>();
				String line = "";
				br = new BufferedReader(new FileReader(filePathUser));
				br.readLine();
				
				while((line = br.readLine()) != null) {
					String[] f = line.split(",");
					
					if(f.length>0) {
						User user = new User();
						user.setUserName(f[0]);
						user.setPassword(f[1]);
						users.add(user);
					}
				}
				
				int flag = 0;
				for(User u: users) {
					if(u.getUserName().equals(n) && u.getPassword().equals(p)) {
						flag=1;
						s = true;
					}
				}
				if(flag == 0) {
					System.out.println("\nPlease enter valid user and password\n");
					s=false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					br.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}return s;
		}
	
	// -------------------------------------------- start Admin ---------------------------------------------------
	public static void startAdmin() {
		Scanner s = new Scanner(System.in);
		System.out.println("----  1. Add new resume -=-=- 2. Search Resume -=-=- 3. Display all Resume -=-=- 4.Delete All User Information -=-=- 5. Quit  ----");
		inp = s.nextLine();
	}
	
	// -------------------------------------------- start User ----------------------------------------------------
		public static void startUser() {
			Scanner s = new Scanner(System.in);
			System.out.println("----  1. Add new resume -=-=- 2. Post -=-=- 3. Search Resume -=-=- 4. Display all Resume -=-=- 5. Display Posts -=-=- 6. Quit  ----");
			inp = s.nextLine();
		}
	
	// ----------------------------------------------- read -------------------------------------------------------
	public static void read() {
		Scanner s = new Scanner(System.in);
		String enter;
		enter = s.nextLine();
		if(enter.isEmpty()) {
			System.out.println("");
		}
	}
	
	// ---------------------------------------------- Admin ------------------------------------------------------
	public static void admin() {
		
		Scanner in = new Scanner(System.in);
		ArrayList<Resume> resumes = new ArrayList<Resume>();
		
		String filePath = "C:\\eclipse-workspace\\Career Information Management System\\src\\Resumes.csv";
		String filePathUser = "C:\\eclipse-workspace\\Career Information Management System\\src\\User.csv";
		
		System.out.println();
		System.out.println("                      -------------------------------------");
		System.out.println("                      Career Information Management System");
		System.out.println("                      -------------------------------------\n");
		do {			
			startAdmin();
			if(inp.equals("1")) {
				//Enter resume of user
				System.out.println("\n-----------------------------------=========================---------------------------------\n");
				
				Resume resume = new Resume();
				System.out.println("Title");
				resume.setTitle(in.nextLine());
				System.out.println("Name");
				resume.setName(in.nextLine());
				System.out.println("Address");
				resume.setAddress(in.nextLine());
				System.out.println("Email");
				resume.setEmail(in.nextLine());
				System.out.println("Mobile");
				resume.setMobile(in.nextLine());
				System.out.println("Degree");
				resume.setDegree(in.nextLine());
				System.out.println("Skills");
				resume.setSkills(in.nextLine());
				System.out.println("Work Experience");
				resume.setWorkExp(in.nextLine());
				System.out.println("Projects");
				resume.setProjects(in.nextLine());
				System.out.println("Reference");
				resume.setRefference(in.nextLine());
				
				resumes.add(resume);
				writeResume(filePath,resumes,resume);
				
				System.out.println("\n-----------------------------------=========================---------------------------------\n");
			}
			else if(inp.equals("2")) {
				System.out.println("Search by Title:");
				searchResume(filePath,in.nextLine());
				read();
			}
			else if(inp.equals("3")) {
				
				readResume(filePath);
				read();
			}
			else if(inp.equals("4")) {
				userInfoDelete(filePathUser);
				System.out.println();
			}
		}while(!inp.equals("5"));
		
		System.out.println("Goodbye");
	}
	
	// ---------------------------------------------- User ------------------------------------------------------
	public static void user() {
		
		Scanner in = new Scanner(System.in);
		ArrayList<Resume> resumes = new ArrayList<Resume>();
		ArrayList<Post> posts = new ArrayList<Post>();
		String filePath = "C:\\eclipse-workspace\\Career Information Management System\\src\\Resumes.csv";
		String postFilePath = "C:\\eclipse-workspace\\Career Information Management System\\src\\Post.csv";
		
		System.out.println();
		System.out.println("                        ------------------------------");
		System.out.println("                        Welcome to Career Information");
		System.out.println("                        ------------------------------\n");
		do {
			startUser();
			if(inp.equals("1")) {
				//Enter resume of user
				System.out.println("\n-----------------------------------=========================---------------------------------\n");
				
				Resume resume = new Resume();
				System.out.println("Title");
				resume.setTitle(in.nextLine());
				System.out.println("Name");
				resume.setName(in.nextLine());
				System.out.println("Address");
				resume.setAddress(in.nextLine());
				System.out.println("Email");
				resume.setEmail(in.nextLine());
				System.out.println("Mobile");
				resume.setMobile(in.nextLine());
				System.out.println("Degree");
				resume.setDegree(in.nextLine());
				System.out.println("Skills");
				resume.setSkills(in.nextLine());
				System.out.println("Work Experience");
				resume.setWorkExp(in.nextLine());
				System.out.println("Projects");
				resume.setProjects(in.nextLine());
				System.out.println("Reference");
				resume.setRefference(in.nextLine());
				
				resumes.add(resume);
				writeResume(filePath,resumes,resume);
				
				System.out.println("\n-----------------------------------=========================---------------------------------\n");
			}
			else if(inp.equals("2")) {
				//post of user
				System.out.println("\n-----------------------------------========= Post ===========---------------------------------\n");
				
				Post post = new Post();
				System.out.println("Title");
				post.setTitle(in.nextLine());
				System.out.println("Description");
				post.setDescription(in.nextLine());
				System.out.println("Salary");
				post.setSalary(in.nextLine());
				
				posts.add(post);
				postJob(postFilePath, posts, post);
				
				System.out.println("\n-----------------------------------=========================---------------------------------\n");
			}
			else if(inp.equals("3")) {
				System.out.println("Search by Title:");
				searchResume(filePath,in.nextLine());
				read();
			}
			else if(inp.equals("4")) {
				System.out.println("Displaying all resumes:\n");
				readResume(filePath);
				read();
			}
			else if(inp.equals("5")) {
				displayPostJob(postFilePath);
				read();
			}
		}while(!inp.equals("6"));
		
		System.out.println("\n                               ====  Goodbye  ====\n");
	}
	
	// ---------------------------------------------- Edit Resume ------------------------------------------------------
	public static void editResumeCsv() {
		
	}
	
	// ------------------------------------------------  Post  --------------------------------------------------------
	public static void postJob(String postFilePath, ArrayList<Post> posts, Post post) {
		File f = new File(postFilePath);
		FileWriter fw = null;
		try {
			if (!f.exists()) {
				fw = new FileWriter(f,true);
				fw.append("Title, Description, Salary");
				fw.append("\n");
			}
			else {
				x = new Scanner(new File(postFilePath));
				if (!x.hasNext()) {
					fw = new FileWriter(f,true);
					fw.append("Title, Description, Salary");
					fw.append("\n");
				}
				else {
					fw = new FileWriter(f,true);
				}
				
			}
			
			for(Post r: posts) {
				fw.append(r.getTitle());
				fw.append(",");
				fw.append(r.getDescription());
				fw.append(",");
				fw.append(r.getSalary());
				fw.append("\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.flush();
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// --------------------------------------------- Display Post  -----------------------------------------------------
	public static void displayPostJob(String postFilePath) {
		BufferedReader br = null;
		
		try {
			ArrayList<Post> posts = new ArrayList<Post>();
			String line = "";
			br = new BufferedReader(new FileReader(postFilePath));
			br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] f = line.split(",");
				
				if(f.length>0) {
					Post post = new Post();
					post.setTitle(f[0]);
					post.setDescription(f[1]);
					post.setSalary(f[2]);
					posts.add(post);
				}
			}
			System.out.println("\n-----------------------------------=========  Posts ==========---------------------------------\n");
			for(Post r: posts) {
				System.out.println("\nTitle: \n"+r.getTitle());
				System.out.println("Description: \n"+r.getDescription());
				System.out.println("Salary: \n"+r.getSalary());
				System.out.println("============================================================================================");
			}
			System.out.println("\n-----------------------------------=========================----------------------------------\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	// ---------------------------------------------- Main Method ------------------------------------------------------
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		a1: while(true) {
		String admin, pass, user;
		System.out.println("\n                ----  1. Admin -=-=- 2. User -=-=- 3. Close  ----");
		String a = in.nextLine();
			if(a.equals("1")) {
				System.out.print("Admin name: ");
				admin = in.nextLine();
				System.out.print("Password: ");
				pass = in.nextLine();
				if(admin.equals("admin") && pass.equals("admin")) {
					admin();
				}
				else {
					System.out.println("\nEnter a valid username and password");
					continue a1;
				}
			}
			else if(a.equals("2")){
				System.out.println("\n                       ----  1. Sign Up  -=-=-  2. Login  ----");
				a = in.nextLine();
				t1: while(true) {
					
					if(a.equals("1")) {
							String filePathUser = "C:\\eclipse-workspace\\Career Information Management System\\src\\User.csv";
							ArrayList<User> users = new ArrayList<User>();
							User u = new User();
							System.out.print("User name: ");
							u.setUserName(in.nextLine());
							System.out.print("Password: ");
							u.setPassword(in.nextLine());
							users.add(u);
							userInfoWriteCsv(filePathUser, users, u);
							user();
							break;
					}
					else if(a.equals("2")) {
						a2: while(true) {
							String filePathUser = "C:\\eclipse-workspace\\Career Information Management System\\src\\User.csv";
							User u = new User();
							System.out.print("User name: ");
							String uN = in.nextLine();
							System.out.print("Password: ");
							String pN = in.nextLine();
							
							if(userInfoCheckCsv(filePathUser, uN, pN) == true) {
								user();
								continue a1;
							}
							else {
								System.out.println("\n               ----  1. Sign Up  -=-=-  2. Try again  ----");
								a = in.nextLine();
								if(a.equals("1")) {
									continue t1;
								}
								else if(a.equals("2")){
									continue a2;
								}
								else {
									continue a1;
								}
							}
						}
					}
					else {
						System.out.println("\nPlease enter a valid number");
						break;
					}
				}
			}
			else if(a.equals("3")) {
				break;
			}
			else {
				System.out.println("\nPlease enter a valid number");
			}
		}

	}

}
