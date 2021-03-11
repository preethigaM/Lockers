package com.LockedMe;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
public class LockedMe {
	public static void displayFiles()
	{
		File directory = new File("/home/premteksystems/eclipse-workspace/LockersMe/src");
		if(directory.length() == 0)
		{
			System.out.println("No files are found");
		}
		else
		{
			List<String> files = Arrays.asList(directory.list());
			for(String fileName : files)
			{
				System.out.println(fileName);
			}
		}
	}
	public static void addFile(String fileName,String text)
	{
		String path = "/home/premteksystems/eclipse-workspace/LockersMe/src/"+fileName;
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(text);
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		//scan.close();
	}
	public static void deleteFile(String fileName)
	{
		String path = "/home/premteksystems/eclipse-workspace/LockersMe/src/"+fileName;
		File file = new File(path);
		if(file.delete())
		{
			System.out.println("File Successfully deleted");
		}
		else
		{
			System.out.println("Failed to delete the file");
		}
	}
	public static void searchFile(String fileName)
	{
		try
		{
			String path = "/home/premteksystems/eclipse-workspace/LockersMe/src/"+fileName;
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			line = reader.readLine();
			while(line != null)
			{
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)//
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to LockedMe.com"+"\n"+"Developer Name: Preethiga M"+"\n--------------------");
		System.out.println("Select any one of the options");
		boolean status = true;
		while(status)
		{
			System.out.println("1. Display File Names\n2. Other Options\n3. Exit");
			int option = scan.nextInt();
			switch(option)
			{
				case 1:
					LockedMe.displayFiles();
					break;
				case 2:
					boolean status1 = true;
					while(status1)
					{
						System.out.println("Select any one of the option\na)Add a file\nb)Delete a file\nc)Search a file\nd)Go to main menu");
						char choice = scan.next().charAt(0);
						switch(choice)
						{
							case 'a':
								System.out.println("Enter the file name");
								String fileName = scan.nextLine();
								System.out.println("Enter the text you want to store in the file");
								String text = scan.nextLine();
								LockedMe.addFile(fileName,text);
								break;
							case 'b':
								System.out.println("Enter the file name to be deleted");
								String fileName1 = scan.nextLine();
								LockedMe.deleteFile(fileName1);
								break;
							case 'c':
								System.out.println("Enter the file name to be searched");
								fileName = scan.nextLine();
								LockedMe.searchFile(fileName);
								break;
							case 'd':
								status1 = false;
								break;
							default:
								System.out.println("Choose the valid option");
						}
						System.out.println("--------------------");
					}
					break;
				case 3:
					status = false;
					break;
				default:
					System.out.println("Choose the valid option");
			}
			System.out.println("--------------------");
		}
		scan.close();
	}
}
