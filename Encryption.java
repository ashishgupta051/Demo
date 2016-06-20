import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Encryption {
	static String fileName;

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the file name :");
		fileName = s.nextLine();
		String encryptedFileName = "";
		String decryptedFileName = "";

		try {

			encryptedFileName = changefileName(fileName, "Encrypted");
			encrypt(fileName, encryptedFileName);
			decryptedFileName = changefileName(fileName, "Decrypted");
			decrypt(encryptedFileName, decryptedFileName);

		} catch (Exception e) {
			// if any I/O error occurs
			e.printStackTrace();
		}

	}

	static String changefileName(String fileName, String methodName) {
		int index = fileName.lastIndexOf(".");
		return fileName.substring(0, index) + methodName + fileName.substring(index);
	}

	static void encrypt(String fileName, String encryptedFileName) throws IOException {
		InputStream inStream = null;
		OutputStream outStream = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bout = null;
		// open input stream test.txt for reading purpose.
		inStream = new FileInputStream(fileName);

		// input stream is converted to buffered input stream
		bis = new BufferedInputStream(inStream);
		byte[] data;
		int count = 0;
		// read until a single byte is available
		while (bis.available() > 0) {
			count++;
			bis.read();

		}

		data = new byte[count];
		inStream = new FileInputStream(fileName);
		bis = new BufferedInputStream(inStream);
		bis.read(data);
		bis.close();
		for (int i = 0; i < count; i++) {

			data[i] = (byte) (data[i] + 7);
		}
		System.out.println("Encryption done");
		System.out.println("Encryted file created successfully with name :" + encryptedFileName);
		outStream = new FileOutputStream(encryptedFileName);
		bout = new BufferedOutputStream(outStream);
		bout.write(data);
		bout.flush();
		bout.close();

	}

	static void decrypt(String fileName, String decryptedFileName) throws IOException {
		InputStream inStream = null;
		OutputStream outStream = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bout = null;
		// open input stream test.txt for reading purpose.
		inStream = new FileInputStream(fileName);

		// input stream is converted to buffered input stream
		bis = new BufferedInputStream(inStream);
		byte[] data;
		int count = 0;
		// read until a single byte is available
		while (bis.available() > 0) {
			count++;
			bis.read();

		}

		data = new byte[count];
		inStream = new FileInputStream(fileName);
		bis = new BufferedInputStream(inStream);
		bis.read(data);
		bis.close();
		for (int i = 0; i < count; i++) {

			data[i] = (byte) (data[i] - 7);
		}
		System.out.println("Decryption done");
		System.out.println("Encryted file created successfully with name :" + decryptedFileName);
		outStream = new FileOutputStream(decryptedFileName);
		bout = new BufferedOutputStream(outStream);
		bout.write(data);
		bout.flush();
		bout.close();
	}
}