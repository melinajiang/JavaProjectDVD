package com.usst.favourate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.usst.pages.User_Page;

import dvdSockets.DVDClient;
import dvdSockets.getPicPath;


public class testReadFile {
	public static ArrayList< String>arrayListRent = new ArrayList<String>();
	public static ArrayList< String>arrayListFav = new ArrayList<String>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		writeFavFile("你的名字");
		readFavFile();
		for (int i = 0; i < arrayListFav.size(); i++) {
			System.out.println(arrayListFav.get(i));
		}
		
		writeFavFile("情书");
		readFavFile();
		for (int i = 0; i < arrayListFav.size(); i++) {
			System.out.println(arrayListFav.get(i));
		}
		
		writeFavFile("hello");
		readFavFile();
		
		writeRentFile("jjj");
		readRentFile();
		for (int i = 0; i < arrayListFav.size(); i++) {
			System.out.println(arrayListFav.get(i));
		}
		User_Page.setPersonalPage("czw");
	//reWriteFile();
	    }
	
	
	public static void writeFavFile(String name) throws IOException{
		//FileOutputStream fileOutputStream=new FileOutputStream("./stockinfo.dat");
		//ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		//objectOutputStream.writeObject(stockInfo);
		//objectOutputStream.close();
		//File file = new File(".//fav_movie.txt");
		FileWriter fileWriter=new FileWriter("/Users/jiangruishan/Documents/personalInfo.favM.txt",true);
		fileWriter.write(name+"\r\n");
		//fileWriter.write(stockIO.getSerialNumber());
		//fileWriter.write(stockIO.getPrice()+"\r\n");
		fileWriter.close();
	}
	public static void readFavFile() throws ClassNotFoundException, IOException{
		///FileInputStream fileInputStream=new FileInputStream("./stockinfo.dat");
		//ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		//DataInputStream dataInputStream=new DataInputStream(fileInputStream) ;
		String string;
		FileReader fileReader=new FileReader("/Users/jiangruishan/Documents/personalInfo.favM.txt");
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		while ((string=bufferedReader.readLine())!=null)
			arrayListFav.add(string);
		//它是一个级联操作，关闭了处理流的时候，节点流也会关闭。。。
		bufferedReader.close();
		//System.out.println();	
	}
	
	public static void writeRentFile(String name) throws IOException{
		//FileOutputStream fileOutputStream=new FileOutputStream("./stockinfo.dat");
		//ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		//objectOutputStream.writeObject(stockInfo);
		//objectOutputStream.close();
		FileWriter fileWriter=new FileWriter("/Users/jiangruishan/Documents/personalInfo.rentM.txt",true);
		fileWriter.write(name+"\r\n");
		//fileWriter.write(stockIO.getSerialNumber());
		//fileWriter.write(stockIO.getPrice()+"\r\n");
		fileWriter.close();
	}
	
	public static void readRentFile() throws ClassNotFoundException, IOException{
		///FileInputStream fileInputStream=new FileInputStream("./stockinfo.dat");
		//ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		//DataInputStream dataInputStream=new DataInputStream(fileInputStream) ;
		String string;
		FileReader fileReader=new FileReader("/Users/jiangruishan/Documents/personalInfo.rentM.txt");
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		while ((string=bufferedReader.readLine())!=null)
			arrayListRent.add(string);
		//它是一个级联操作，关闭了处理流的时候，节点流也会关闭。。。
		bufferedReader.close();
		//System.out.println();	
	}
	
	/*
	public static void reWriteFile(){
		
		File file = new File(".//fav_movie.txt");
		if (file.exists()) {
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(".//fav_movie.txt", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int j = 0; j < arrayList.size(); j++) {
			try {
				System.out.println("******"+arrayList.get(j));
				
				fileWriter.write(arrayList.get(j)+"\r\n");
				System.out.println("write success!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			/*
			try {
				
				//fileWriter.write(arrayList.get(j)+"\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	*/
	
}
