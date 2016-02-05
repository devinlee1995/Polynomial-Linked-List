
public class Driver {
	
	public static void main (String [] args) {
		PolyLinkedList listp = new PolyLinkedList(); 
		Polynomial term1 = new Polynomial(3,2); 
		Polynomial term2 = new Polynomial(-3,1); 
		Polynomial term3 = new Polynomial(7,0); 
		
		Node termfirst = new Node (term1);
		Node termsecond = new Node (term2); 
		Node termthird = new Node (term3); 
		
		listp.append(termfirst); 
		listp.append(termsecond);
		listp.append(termthird); 
		
		listp.print(); 
		
		PolyLinkedList listq = new PolyLinkedList(); 
		Polynomial term4 = new Polynomial(1,2); 
		Polynomial term5 = new Polynomial(-2,0); 
		
		Node termfour = new Node (term4);
		Node termfive = new Node (term5); 
		
		listq.append(termfour); 
		listq.append(termfive);
		 
		
		listq.print(); 
		
		PolyLinkedList sum = listp.add(listq); 
		sum.print(); 
		
		PolyLinkedList diff = listp.subtract(listq); 
		diff.print(); 
		
		PolyLinkedList product = listp.multiply(listq); 
		product.print(); 
		
		System.out.println(listq.evaluate(2)); 
		
		Polynomial term6 = new Polynomial (1,1); 
		Polynomial term7 = new Polynomial (-2,0); 
		
		Node termsix = new Node(term6); 
		Node termseven = new Node(term7); 
		
		PolyLinkedList test = new PolyLinkedList (); 
		test.append(termsix); 
		test.append(termseven); 
		
		Polynomial term8 = new Polynomial (1,1); 
		Polynomial term9 = new Polynomial (2,0); 
		
		Node termeight = new Node(term8); 
		Node termnine = new Node(term9); 
		
		PolyLinkedList test2 = new PolyLinkedList (); 
		test2.append(termeight); 
		test2.append(termnine);
		
		PolyLinkedList product2 = test.multiply(test2); 
		product2.print(); 

	}

}
