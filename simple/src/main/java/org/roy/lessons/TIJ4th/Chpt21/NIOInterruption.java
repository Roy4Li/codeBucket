package org.roy.lessons.TIJ4th.Chpt21;

//: concurrency/NIOInterruption.java
//Interrupting a blocked NIO channel.
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.*;
import static org.roy.lessons.TIJ4th.common.util.Print.*;

class NIOBlocked implements Runnable {
	private final SocketChannel sc;

	public NIOBlocked(SocketChannel sc) {
		this.sc = sc;
	}

	public void run() {
		try {
			print("Waiting for read() in " + this);
			sc.read(ByteBuffer.allocate(1));
		} catch (ClosedByInterruptException e) {
			print("ClosedByInterruptException");
		} catch (AsynchronousCloseException e) {
			print("AsynchronousCloseException");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		print("Exiting NIOBlocked.run() " + this);
	}
}

public class NIOInterruption {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8080);
		InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);
		Future<?> f = exec.submit(new NIOBlocked(sc1));
		TimeUnit.SECONDS.sleep(1);
		exec.execute(new NIOBlocked(sc2));
		// ONLY exec.shutdownNow() will send interrupt 
		// exec.shutdown() will JUST thread itself to finish
		exec.shutdown();
		TimeUnit.SECONDS.sleep(1);
		// Produce an interrupt via cancel:
		// this will cause NIO ClosedByInterruptException
		f.cancel(true);
		TimeUnit.SECONDS.sleep(1);
		// Release the block by closing the channel:
//		sc1.close();
	}
} /*
 * Output: (Sample) Waiting for read() in NIOBlocked@7a84e4 Waiting for read()
 * in NIOBlocked@15c7850 ClosedByInterruptException Exiting NIOBlocked.run()
 * NIOBlocked@15c7850 AsynchronousCloseException Exiting NIOBlocked.run()
 * NIOBlocked@7a84e4
 */// :~

