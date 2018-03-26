package outerhaven.sfti;

public class A {
	A() {
		i = (j++ != 0) ? ++j : --j;
	}

	public int i;
	public static int j = 0;
}


