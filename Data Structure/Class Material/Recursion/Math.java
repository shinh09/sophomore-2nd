public class Math {
	public static void main(String[] args) {
		Math f = new Math();
		System.out.println("3!="+ f.factorial(3));
		System.out.println("3^2="+ f.power(3,2));
		System.out.println("3^3="+ f.power(3,3));
		for(double i = 0 ; i < 6 ; i+=0.1) 
			System.out.println( i + "\t"+ f.sin(i, 20)+ "\t"+f.cos(i, 20));
	}
	public long factorial(int n){
		if(n<0) {
			System.err.println("Number should be positive");
			System.exit(-1);
		}
		if(n<=1) return 1;
		else return n * factorial(n-1);
	}
	public long power(int x, int n) {
		if(n<0) {
			System.err.println("Number should be positive");
			System.exit(-1);
		}
		if(n==0) return 1;
		if(n%2==0) {
			long temp = power(x, n/2);
			return temp*temp;
		} else {
			long temp = power(x, (n-1)/2);
			return x* temp*temp;
		}
	}
	/**
	 * Calculating the sine function
	 * @param x : degree
	 * @param num : the number of recursion
	 * @return sin(x)
	 */
	public double sin(double x, int num) {
		if(num==0) return x;
		else return 2*sin(x/2, num-1)*cos(x/2, num-1);
	}

	/**
	 * Calculating the cosine function
	 * @param x : degree
	 * @param num : the number of recursion
	 * @return cos(x)
	 */
	public double cos(double x, int num) {
		if(num==0) return 1;
		else {
			double cos = cos(x/2, num-1);
			double sin = sin(x/2, num-1);
			return cos*cos-sin*sin;
		}
	}

}
