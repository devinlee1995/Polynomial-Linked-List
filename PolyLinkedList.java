
public class PolyLinkedList {
	
	//first node in list: dummy head node 
	private Node first = new Node(null); 
	
	//last node in linked list
	private Node last=first;
	
	
	public void append (Node a) {
		last.next = a; 
		last = a; 
	}

	public PolyLinkedList add(PolyLinkedList other) {
		PolyLinkedList sum = new PolyLinkedList(); 
		
		Node pcurrent = first.next; 
		Node qcurrent = other.first.next;
	
		while (pcurrent != null && qcurrent != null) {
			if (pcurrent.data.exponent == qcurrent.data.exponent) {
				Polynomial sum1 = new Polynomial (pcurrent.data.coef + qcurrent.data.coef, pcurrent.data.exponent);
				Node nodesum = new Node(sum1); 
				sum.append(nodesum); 
			
				pcurrent = pcurrent.next; 
				qcurrent = qcurrent.next; 
			}
		
			else if (pcurrent.data.exponent != qcurrent.data.exponent) {
				if (pcurrent.data.exponent > qcurrent.data.exponent) {
					Polynomial sum2 = new Polynomial (pcurrent.data.coef, pcurrent.data.exponent); 
					Node nodesum2 = new Node(sum2); 
					sum.append(nodesum2);
				
					pcurrent = pcurrent.next; 
					
				}
				else {
					Polynomial sum3 = new Polynomial (qcurrent.data.coef, qcurrent.data.exponent); 
					Node nodesum3 = new Node(sum3); 
					sum.append(nodesum3);
					
					qcurrent = qcurrent.next;
				}
			}	
		}
		
		if (pcurrent != null) {
			while (pcurrent != null) {
				Polynomial sum3 = new Polynomial (pcurrent.data.coef, pcurrent.data.exponent); 
				Node nodesum3 = new Node(sum3); 
				sum.append(nodesum3);
			
				pcurrent = pcurrent.next; 
			}
		}
		
		if (qcurrent != null) {
			while (qcurrent != null) {
				Polynomial sum3 = new Polynomial (qcurrent.data.coef, qcurrent.data.exponent); 
				Node nodesum3 = new Node(sum3); 
				sum.append(nodesum3);
			
				qcurrent = qcurrent.next; 
			}
		}	
		return sum; 
	}
	
	public PolyLinkedList subtract (PolyLinkedList other) {
		PolyLinkedList diff = new PolyLinkedList(); 
		
		Node pcurrent = first.next; 
		Node qcurrent = other.first.next;
	
		while (pcurrent != null && qcurrent != null) {
			if (pcurrent.data.exponent == qcurrent.data.exponent) {
				Polynomial diff1 = new Polynomial (pcurrent.data.coef - qcurrent.data.coef, pcurrent.data.exponent);
				Node nodediff = new Node(diff1); 
				diff.append(nodediff); 
			
				pcurrent = pcurrent.next; 
				qcurrent = qcurrent.next; 
			}
		
			else if (pcurrent.data.exponent != qcurrent.data.exponent) {
				if (pcurrent.data.exponent > qcurrent.data.exponent) {
					Polynomial diff2 = new Polynomial (pcurrent.data.coef, pcurrent.data.exponent); 
					Node nodediff2 = new Node(diff2); 
					diff.append(nodediff2);
				
					pcurrent = pcurrent.next; 
					
				}
				else {
					Polynomial diff3 = new Polynomial (qcurrent.data.coef, qcurrent.data.exponent); 
					Node nodediff3 = new Node(diff3); 
					diff.append(nodediff3);
					
					qcurrent = qcurrent.next;
				}
			}	
		}
		
		if (pcurrent != null) {
			while (pcurrent != null) {
				Polynomial diff3 = new Polynomial (pcurrent.data.coef, pcurrent.data.exponent); 
				Node nodediff3 = new Node(diff3); 
				diff.append(nodediff3);
			
				pcurrent = pcurrent.next; 
			}
		}
		
		if (qcurrent != null) {
			while (qcurrent != null) {
				Polynomial diff3 = new Polynomial (qcurrent.data.coef, qcurrent.data.exponent); 
				Node nodediff3 = new Node(diff3); 
				diff.append(nodediff3);
			
				qcurrent = qcurrent.next; 
			}
		}	
		return diff; 
	}
	
	public PolyLinkedList multiply (PolyLinkedList other) {
		PolyLinkedList product = new PolyLinkedList(); 
		
		Node pcurrent = first.next; 
		
		while (pcurrent!= null) {
			Node qcurrent = other.first.next;
			while (qcurrent!= null) {
				Polynomial temp1 = new Polynomial (pcurrent.data.coef*qcurrent.data.coef, 
									pcurrent.data.exponent+qcurrent.data.exponent);
				Node temp2 = new Node (temp1);
				product.insert(temp2); 
				qcurrent = qcurrent.next; 
			}
		pcurrent = pcurrent.next; 
		}
		
		return product; 
	}
	
	public void insert (Node newadd) {
		if (first.next == null) { //just inserts node if list is empty
			first.next = newadd; 
		}
		else {
			Node before = first; 
			Node after = before.next; 
			boolean added = false; 
			
				if (newadd.data.exponent > after.data.exponent) { //prepends if the new polynomial has a greater degree 
					newadd.next = after; 
					before.next = newadd;
					before = newadd; 
				}
				else { 
					while (after != null && after.data.exponent >= newadd.data.exponent) { //goes though linked list from the beginning to insert in right place
						if (after.data.exponent == newadd.data.exponent) {//adds new polynomial to an existing polynomial with the same degree
							//need an accumluator += for the node
							added = true; 
							after.data.coef += newadd.data.coef;
						}	
						before = after; 
						after = after.next;	//goes through list until it reaches the end OR the newly added polynomial has a greater degree than after
					}	
					if (!added) { //appends to the end of the list if new polynomial has a smaller degree than all the other polynomial objects
					newadd.next = after; 
					before.next = newadd;
					before = newadd; 
					}	 
				}
		}
	}
	
	public int evaluate (int n) {
		int finalanswer = 0; 
		Node gothrough = first.next; 
		int [] powers = new int [gothrough.data.exponent+1]; 
		powers[0] = 1; 
		int power = n; 
		for (int i = 1; i < powers.length; i++) {
			powers[i] = powers[i-1]*n; 
		}
		while (gothrough != null) {
				finalanswer += gothrough.data.coef*powers[gothrough.data.exponent]; 
				gothrough = gothrough.next; 
			}
	
		
		return finalanswer; 
	}

	
	
	public void print() {
		Node p = first.next;
        String polynomial = ""; 
        
        	while (p != null) { 
        		if (p.data.exponent == 0 && p.data.coef != 0) {
        			polynomial = polynomial + p.data.coef;
        		}
        		else {
        			if (p.data.coef != 0) {
        				if (p.next != null){
        					polynomial = polynomial + p.data.coef + "x^" + p.data.exponent + " + ";
        				}
        				else polynomial = polynomial + p.data.coef + "x^" + p.data.exponent; 
        			}
        	}
        	p = p.next;
        	}
        	
		 System.out.println(polynomial); 
	}

	
}
