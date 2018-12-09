package com.albenyuan.thread.pipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeStream {

	private static final Logger logger = LoggerFactory.getLogger(PipeStream.class);


	private static class Reader extends Thread {

		private PipedInputStream inputStream;

		public Reader(PipedInputStream inputStream) {
			this.inputStream = inputStream;
		}

		@Override
		public void run() {
			logger.info("read:");
			byte[] bytes = new byte[20];
			int length;
			try {
				while ((length = inputStream.read(bytes)) != -1) {
					logger.info("data:{}", new String(bytes, 0, length));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				PipeStream.close(inputStream);
			}
		}

	}


	private static class Writer extends Thread {

		private PipedOutputStream outputStream;

		public Writer(PipedOutputStream outputStream) {
			this.outputStream = outputStream;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 300; i++) {
					outputStream.write(("" + i).getBytes());
				}
			} catch (Exception e) {
				logger.error("write error:", e);
			}finally {
				PipeStream.close(outputStream);
			}
		}

	}

	public static void main(String[] args) {

		PipedInputStream inputStream = new PipedInputStream();
		PipedOutputStream outputStream = new PipedOutputStream();
		try {


			outputStream.connect(inputStream);

			Writer writer = new Writer(outputStream);
			Reader reader = new Reader(inputStream);

			reader.start();


			Thread.sleep(2000);
			writer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	public static void close(Closeable... closeables) {
		for (Closeable closeable:closeables) {
			if (null != closeable) {
				try {
					closeable.close();
				} catch (IOException e) {
					logger.warn("IO close error", closeable);
				} finally {
					closeable = null;
				}
			}
		}
	}


}



