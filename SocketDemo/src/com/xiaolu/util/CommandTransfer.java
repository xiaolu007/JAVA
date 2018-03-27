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
//		System.out.println("    1.用户注册");
//		System.out.println("    2.用户登录");
//		System.out.println("    3.上传文件");
//		System.out.println("*****************");
//		System.out.println("请输入选项，或者按0退出！");
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
//					System.out.println("请输入用户名:");
//					String username = CommandTransfer.ScannerInfoString();
//					System.out.println("请输入密码:");
//					String password = CommandTransfer.ScannerInfoString();
//					ArrayList<User> userinfo = new UserService().checkstandLog(username);
//					if(userinfo == null || userinfo.size()==0) {
//						System.out.println("用户名输入有误！请重新输入");
//					}
//					else {
//						User user = userinfo.get(0);
//						if(password.equals(user.getPassWord())) {
//							System.out.println("登录成功！");
//						}else {
//							System.out.println("密码错误！");
//						}
//					}
//					break;
//				case 3:
//					
//					break;
//				case 0:
//					System.out.println("你已退出系统！");
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
//		System.out.println("请输入：");
//		return scanner.nextLine();
//	}
	
}
