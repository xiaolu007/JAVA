package com.xiaolu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.xiaolu.entity.File;
import com.xiaolu.entity.User;
import com.xiaolu.service.FileService;
import com.xiaolu.service.UserService;
import com.xiaolu.util.CommandTransfer;

public class ServiceThread extends Thread{
	private Socket socket = null;
	private ObjectInputStream ois = null; //对象输入流
	private ObjectOutputStream oos = null; //对象输出流
	private FileService fs = new FileService();
	private UserService us = new UserService();
	public ServiceThread(Socket socket) {
		this.socket=socket;
	}
	public void run() {
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			CommandTransfer transfer =(CommandTransfer)ois.readObject();
			transfer=execute(transfer);
			oos.writeObject(transfer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public CommandTransfer execute(CommandTransfer transfer) {
		String cmd = transfer.getCmd();
		if(cmd.equals("login")) {
			User user = (User)transfer.getData();
			boolean flag = us.checkstandLog(user);
			transfer.setFlag(flag);
			if(flag) {
				transfer.setResult("登录成功！");
			}else {
				transfer.setResult("用户名或密码不正确！");
			}
		}else if(cmd.equals("reg")) {
			User user = (User)transfer.getData();
			us.add(user);
			boolean flag = us.checkstandLog(user);
			transfer.setFlag(flag);
			if (flag) {
				transfer.setResult("注册成功！");
			}else {
				transfer.setResult("注册失败！");
			}
		}else if(cmd.equals("uploadFile")){
			File file =(File) transfer.getData();
			fs.insert(file);
			transfer.setResult("上传成功！");
		}
		return transfer;
	}
	
}
