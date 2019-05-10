package com.hirw.scala

// questo è il costruttore. Dietro le quinte, scala crea un costruttore con due proprietà: name e salary. Con var si indica che quella è una variabile.
// Per quanto riguarda i metodi getters and setter? Non occorrono.
class Employee (var name : String , var salary : Int) {

	var dept = 0  // possiamo anche aggiungere ulteriori proprietà oltre a quelle indicate nel costruttore. Basta indicare variabili var
	              // come si può osservare, non abbiamo indicato esplicitamente il tipo della variabile dept. Abbiamo però assegnato un valore direttamente.
	              // dal valore assegnato alla variabile, Scala in automatico inferisce il suo tipo. Questo è chiamato Type inference. Pertanto, dept è un intero
		
	//Per definire valori immutabili, cioè costanti, usiamo val dept = 1; 
	// val (scala) <-----> final (java)
	def printEmployee() = {
					println(name + " makes $" + salary)
	}    
}


/*
 * Come entry point usiamo il metodo Main. Java ce lo fornisce dentro la classe. Qui invece possiamo creare un object main. Ma cosa è un object.
 * Gli object in scala sono oggetti singleton, che significa che c'è una sola istanza di quell'oggetto nel nostro universo.
 * Dentro l'oggetto Main è stato definito un metodo main. Per definire un metodo usiamo la keyword 'def'. Come si può notare, tale metodo restituisce Unit, che è 
 * il duale di void. Quindi, 
 * Unit (scala) <----> void (java)
 */
object Main {
	def main(args: Array[String]): Unit = {

			var emily = new Employee("Emily", 10000) // creiamo un oggetto Employee chiamato emily 

					// COME SI PUO' OSSERVARE NON USIAMO ";" PER TERMINARE UNA RIGA DI CODICE

					// creato l'oggetto Emily, stampiamo le sue proprietà, cioè il nome e il salario. Possiamo accederci direttamente, perchè non occorrono metodi get e set.
					println(emily.name)
					println(emily.salary)

					// possiamo anche modificare le proprietà di un oggetto semplicemente assegnandoli valori. Non occorre usare metodi set.
					emily.salary = 20000    
					println(emily.salary.toString()) // per convertire in stringa usiamo toString()
					                                 // come si nota, abbiamo messo un toString() a una variabile con tipo apparentemente primitivo. In Java ci sono tipi primitivi e oggetti,
					                                 // in Scala invece non ci sono tipi primitivi, ma tutto è un oggetto, quindi hanno i classici metodi toString().

					// settiamo la proprietà dept (dipartimento)
					println(emily.dept)	  
					emily.dept = 10 //modifichiamo il dipartimento di emily

					emily.printEmployee()
	}
}

