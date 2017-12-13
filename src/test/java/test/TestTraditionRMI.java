package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import com.yuan.www.service.TeacherService;

public class TestTraditionRMI {

	public static void main(String[] args) {

		String serviceUrl = "rmi:/teacherService";
		try {
			TeacherService teacherService = (TeacherService) Naming
					.lookup(serviceUrl);

			System.out.println(teacherService.selectByPrimaryKey(1));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
