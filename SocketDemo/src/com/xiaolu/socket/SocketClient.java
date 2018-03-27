package com.xiaolu.socket;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.xiaolu.entity.*;
import com.xiaolu.util.CommandTransfer;

public class SocketClient {
	Scanner scan = new Scanner(System.in);
	private Socket socket =null;
	
	public void showMainMenu() throws IOException {
		System.out.println("******��ӭʹ���ļ��ϴ���*******");
		System.out.println("         1 �û���¼");
		System.out.println("         2 �û�ע��");
		System.out.println("*************************");
		System.out.println("��ѡ�񣺡���������������");
		int choose = scan.nextInt();
		switch (choose) {
		case 1:
			login();
			break;
		case 2:
			register();
			break;
		default:
			System.out.println("��������");
			System.exit(-1);
		}
	} 
	public void login() throws IOException {
		User user=new User();
		System.out.println("��ӭ��¼��");
		CommandTransfer transfer = new CommandTransfer();
		int count=0;
		while(true) {
			if(count>=3) {
				System.out.println("����������Σ��ټ�������");
				System.exit(0);
			}
			System.out.println("�������û�����");
			user.setUserName(scan.next());
			System.out.println("���������룺");
			user.setPassWord(scan.next());
			transfer.setCmd("login");
			transfer.setData(user);
			count++;
			try {
				socket=new Socket("localhost", 5656);
				sendData(transfer);
				transfer=getData();
				System.out.println("  "+transfer.getResult());
				System.out.println("***********************");
				if(transfer.isFlag()) {
					break;
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				closeAll();
			}
		}
		uploadFile();
	} 
	
	public void register() throws IOException {
		User user = new User();
		System.out.println("��ӭʹ��ע�᣺");
		CommandTransfer transfer = new CommandTransfer();
		while(true) {
			System.out.println("�������û�����");
			user.setUserName(scan.next());
			System.out.println("���������룺");
			user.setPassWord(scan.next());
			System.out.println("���ٴ��������룺");
			String repassword = scan.next();
			if(!user.getPassWord().equals(repassword)) {
				System.out.println("�������벻һ�£�");
				System.out.println("**********************");
				continue;
			}
			transfer.setCmd("reg");
			transfer.setData(user);
			try {
				socket = new Socket("localhost", 5656);
				sendData(transfer);
				transfer=getData();
				System.out.println("***"+transfer.getResult());
				System.out.println("***************************");
				if(transfer.isFlag()) {
					break;
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				closeAll();
			}
			
		}
		login();
	} 
	
	public void uploadFile() throws IOException {
		System.out.println("����������ϴ�·������I://JavaProject");
		String path=scan.next();
		File file = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		String fname = path.substring(path.lastIndexOf("/")+1);
		try {
			fis = new FileInputStream(path);
			byte[] fcontent = new byte[fis.available()];
			bis = new BufferedInputStream(fis);
			bis.read(fcontent);
			file = new File(fname, fcontent);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		CommandTransfer transfer = new CommandTransfer();
		transfer.setCmd("uploadFile");
		transfer.setData(file);
		try {
			socket = new Socket("localhost", 5656);
			sendData(transfer); 
			transfer=getData();
			System.out.println(transfer.getResult());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	} 
	
	
	public CommandTransfer sendData(CommandTransfer transfer) {
		ObjectOutputStream oos = null;  //���������
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(transfer);
			return transfer;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	public CommandTransfer getData() {
		ObjectInputStream ois = null;  //����������
		CommandTransfer transfer = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			transfer = (CommandTransfer) ois.readObject();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return transfer;
	}
	
	public void closeAll() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
