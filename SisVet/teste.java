public class teste{
	
	public static void main(String args[]){
		
		Cachorro c1 = new Cachorro("Joao","Jose", 10, 1);
		Cachorro c2 = new Cachorro("Joao","Jose", 10, 1);
		
		String x = "Casa";
		String y = "Casa";
		
		if (x.equals(y))
			System.out.println("Sao iguais");
			else System.out.println("Sao diferentes");
	}
}