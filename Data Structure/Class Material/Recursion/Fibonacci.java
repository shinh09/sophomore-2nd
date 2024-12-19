import java.util.*;

public class Fibonacci {
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		long t0, t1, fibo;
		
		System.out.println("n\tRecursion\tTail Recursion\tIteration\tStack\tMemory");

		for(int i = 1; i < 40 ; i++) {
			//recursion
			t0 = System.currentTimeMillis();
			fibo = f.recursive(i);
			t1 = System.currentTimeMillis();
			long time4recursion = t1-t0;
			
			// tail recursion			
			t0 = System.currentTimeMillis();
			fibo = f.tailRecursion(i, 1, 1);
			t1 = System.currentTimeMillis();
			long time4tail = t1-t0;
			
			// iteration
			t0 = System.currentTimeMillis();
			fibo = f.iteration(i);
			t1 = System.currentTimeMillis();
			long time4iteration = t1-t0;
			
			// using stack
			t0 = System.currentTimeMillis();
			fibo = f.usingStack(i);
			t1 = System.currentTimeMillis();
			long time4stack = t1-t0;
			
			// memorize the result
			t0 = System.currentTimeMillis();
			fibo = f.memorize(i);
			t1 = System.currentTimeMillis();
			long time4memory = t1-t0;


			System.out.println(i+"\t"+time4recursion+"\t"+time4tail+"\t"+time4iteration+"\t"+time4stack+"\t"+time4memory);
		}
	}
	public long recursive(int n) {
		if(n<0) {
			System.err.println("Number should be positive");
			System.exit(-1);
		}
		if(n<2) return (long)1;
//		return recursive(n-1)+recursive(n-2);

		long prePreFibo = recursive(n-1);
		long preFibo = recursive(n-2);
		long currentFibo = preFibo+prePreFibo;
		return currentFibo;
		
	}
	public long tailRecursion(int n, long preFibo, long prePreFibo) {
		long currentFibo;
		if (n < 3) return preFibo+prePreFibo;
//		return tailRecursion(n-1, preFibo+prePreFibo, preFibo);	
		
		currentFibo = preFibo+prePreFibo;
		prePreFibo = preFibo;
		preFibo = currentFibo;
		return tailRecursion(n-1, preFibo, prePreFibo);
		
	}
	public long iteration(int n) {
		long currentFibo=1;
		long preFibo=1,prePreFibo=1;
		for(int i=n; i > 1 ; i--) {
			currentFibo = preFibo+prePreFibo;
			prePreFibo = preFibo;
			preFibo = currentFibo;
		}		
		return currentFibo;
		
	}
	public long usingStack(int n) {
		ArrayDeque<Record> programStack = new ArrayDeque<>(100);
		programStack.push(new Record(n, 1, 1));
		long currentFibo = n;
		while(!programStack.isEmpty()) {
			Record topRecord = programStack.pop();
			currentFibo = topRecord.n;
			long preFibo = topRecord.pre;
			long prePreFibo = topRecord.prePre;
			if(currentFibo < 3)
				currentFibo =preFibo+prePreFibo;
			else
				programStack.push(new Record(currentFibo-1, preFibo+prePreFibo, preFibo));
		}
		return currentFibo;
	}
	private class Record{
		private long n;
		private long pre, prePre;
		public Record(long n, long pre, long prePre) {
			this.n = n;
			this.pre = pre;
			this.prePre = prePre;
		}		
	}
	private long[] fibonacci;
	private int num=2;
	private static final int MAX=1010;
	public Fibonacci() {
		fibonacci = new long[MAX];
		fibonacci[0]=fibonacci[1]=1;
	}
	public long memorize(int n) {
		if(n<num) return fibonacci[n];
		else if(n==num) {
			fibonacci[n]=fibonacci[n-1]+fibonacci[n-2];
			num++;
			return fibonacci[n];
		}
		else return memorize(n-1)+memorize(n-2);
	}

}
