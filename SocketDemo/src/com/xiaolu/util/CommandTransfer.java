package com.xiaolu.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.xiaolu.entity.User;
import com.xiaolu.service.UserService;

public class CommandTransfer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String cmd;
	private Object data;
	private boolean flag;
	private String result;
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public CommandTransfer() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		
//		CommandTransfer.mainPage();
//		
//	}
//	public static void mainPage() {
//		System.out.println("*****************");
//		System.out.println("    1.�û�ע��");
//		System.out.println("    2.�û���¼");
//		System.out.println("    3.�ϴ��ļ�");
//		System.out.println("*****************");
//		System.out.println("������ѡ����߰�0�˳���");
//		do {
//			String choice = ScannerInfoString();
//			String regex = "[0-3]";
//			if(choice.matches(regex)) {
//				int info = Integer.parseInt(choice);
//				switch (info) {
//				case 1:
//					UserService.addPage();
//					break;
//				case 2:
//					System.out.println("�������û���:");
//					String username = CommandTransfer.ScannerInfoString();
//					System.out.println("����������:");
//					String password = CommandTransfer.ScannerInfoString();
//					ArrayList<User> userinfo = new UserService().checkstandLog(username);
//					if(userinfo == null || userinfo.size()==0) {
//						System.out.println("�û���������������������");
//					}
//					else {
//						User user = userinfo.get(0);
//						if(password.equals(user.getPassWord())) {
//							System.out.println("��¼�ɹ���");
//						}else {
//							System.out.println("�������");
//						}
//					}
//					break;
//				case 3:
//					
//					break;
//				case 0:
//					System.out.println("�����˳�ϵͳ��");
//					System.exit(-1);;
//					break;
//				default:
//					break;
//				}
//			}
//		}while(true);
//	}
//	
//	public static String ScannerInfoString() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("�����룺");
//		return scanner.nextLine();
//	}
	
}
