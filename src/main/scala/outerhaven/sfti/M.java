package outerhaven.sfti;

public class M {
	public static void main(String[] args) {
		A a1 = new A();

		System.out.println(a1.i);
		System.out.println(a2.i);
		
		System.out.println(FindNextPrime(4));
	}

	static A a2 = new A();
	
	
	public static int FindNextPrime(int i) {
		if ( i <= 1 ) {
			return 2;
		}
		int next = i-1;
		while ( true ) {
			++next;
			boolean isPrime = true;
			for ( int n = 2 ; n <= Math.floor(Math.sqrt(next)) && isPrime; ++n ) {
				if ( next % n == 0 ) {
					isPrime = false;
				}
			}
			if (isPrime) {
				return next;
			}
		}
		
	}
}
