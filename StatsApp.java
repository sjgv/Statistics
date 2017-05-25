package tools;

public class StatsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stats myS = new Stats("res/data.txt");
		//for(double el: myS.get()) System.out.println(el);
		
		System.out.println("mean " + myS.mean());
		System.out.println("median " + myS.median());
		System.out.println("mode " + myS.mode());
		System.out.println("stdDev " + myS.stdDev());
		System.out.println("sigma " + myS.sigma());
		System.out.println("variance " + myS.variance());
	}

}
