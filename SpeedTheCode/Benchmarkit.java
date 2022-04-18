import java.util.*;

public class Benchmarkit {
	public static void benchmark(final int trials,
															 final int n,
															 Benchmark b) {
		long totalTime = 0;
		long times[] = new long[trials];
		for (int t = 0; t < trials; t++) {
			long t0 = System.nanoTime();
			b.doit(n);
			long t1 = System.nanoTime();
			final long elapsed = t1-t0;
			times[t] = elapsed;
			totalTime += elapsed;
		}
		System.out.printf("Benchmark %s trials=%d n=%d\n", b, trials, n);
		for (int i = 0; i < trials; i++)
			System.out.printf("%6.3f\t", times[i] * 1e-9);
		System.out.println();
		System.out.printf("average=%6.3f\n", totalTime/trials*1e-9);
	}
}
